import requests
from bs4 import BeautifulSoup
import asyncio, aiohttp
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.select import Select
from selenium import webdriver
from multiprocessing import Pool, Process
import os, time
import re
import shutil

options = Options()
options.add_argument('--headless')
options.add_argument('--blink-settings=imagesEnabled=false')
options.add_argument('--disable-gpu')
driver_path = '../driver/chromedriver.exe'

basic_URL = 'https://codeforces.com'

problemDict = {}


class codeforcesSpider():
    def __init__(self, startpage, endPage):
        self.startPage = startPage
        self.endPage = endPage
        self.basic_URL = 'https://codeforces.com'
        self.sem = asyncio.Semaphore(10)  # 信号量，控制协程数，防止爬的过快
        self.options = Options()
        self.options.add_argument('--headless')
        self.options.add_argument('--blink-settings=imagesEnabled=false')
        self.options.add_argument('--disable-gpu')
        self.driver_path = '../driver/chromedriver.exe'

    '''
    协程调用方法，请求题目网页
    '''

    def get_problem(self):
        problems_URL = [self.basic_URL + '/problemset/page/{}'.format(index) for index in
                        range(self.startPage, self.endPage + 1)]
        loop = asyncio.get_event_loop()  # 获取事件循环
        tasks = [self.parse_ProblemListHtml(url) for url in problems_URL]  # 把所有任务放到一个列表中
        loop.run_until_complete(asyncio.wait(tasks))  # 激活协程
        loop.close()  # 关闭事件循环

    '''
    多协程提交请求获取题目列表网页html并解析
    '''

    async def parse_ProblemListHtml(self, url):
        async with(self.sem):
            # async with是异步上下文管理器
            async with aiohttp.ClientSession() as session:  # 获取session
                print('异步获取%s下的html.' % url)
                async with session.request('GET', url, ssl=False) as resp:  # 提出请求
                    html = await resp.read()  # 直接获取到html内容
                    soup = BeautifulSoup(html, 'html.parser')
                    table = soup.table
                    for tr in table.find_all('tr'):
                        if tr.a.string:
                            problemNo = tr.a.string.strip()
                            problemInfoURL = self.basic_URL + tr.a.attrs['href']
                            problemDict[problemNo] = {}
                            problemDict[problemNo]['problemInfoURL'] = problemInfoURL
                            if tr.find('a', attrs={'title': 'Participants solved the problem'}):
                                problemSolvedURL = self.basic_URL + tr.find('a',
                                                                            attrs={
                                                                                'title': 'Participants solved the problem'}).get(
                                    'href')
                                problemDict[problemNo]['problemSolvedURL'] = problemSolvedURL
                            else:
                                problemDict.pop(problemNo)


'''
    获取题目提交ID的链接
'''


def get_submission(submissionsInfo):
    problemNo, url = submissionsInfo
    print('正在获取题目{}的提交ID'.format(problemNo))
    # 打开浏览器
    browser = webdriver.Chrome(executable_path=driver_path, options=options)
    browser.get(url)  # 访问网页
    selectname = browser.find_element_by_id("programTypeForInvoker")
    Select(selectname).select_by_value("java8")
    browser.find_element_by_xpath('//*[@id="sidebar"]/div/div[4]/form/div[5]/input[1]').click()
    soup = BeautifulSoup(browser.page_source, 'html.parser')
    submit_ID = soup.find('tbody').findAll('a', class_='view-source')[0].contents[0]
    submitID_codeURL = basic_URL + soup.find('tbody').findAll('a', class_='view-source')[0].get('href')
    browser.close()
    browser.quit()
    print(f'{problemNo}题目提交ID获取成功！')
    return [problemNo, submitID_codeURL]


''' 
    爬取测试用例并保存
'''


def save_testCase(testCaseInfo):
    problemNo, url = testCaseInfo
    print(f'正在解析{problemNo}的题目信息页面')
    text = requests.get(url).text
    soup = BeautifulSoup(text, 'html.parser')
    input = soup.find('div', class_='input').find('pre').contents
    input_text = ''.join(str(char) for char in input).replace('<br/>', '\n').lstrip('\n')
    output = soup.find('div', class_='output').find('pre').contents
    output_text = ''.join(str(char) for char in output).replace('<br/>', '\n').lstrip('\n')
    try:
        DirName = problemNo
        if not os.path.exists(DirName):  # 判断对应题目文件夹是否存在，不存在创建一个
            os.mkdir(DirName)
        '''
            设置相关文件名，并保存到相应文件夹目录中
        '''
        input_filePath = DirName + '/' + problemNo + '_input.txt'
        output_filePath = DirName + '/' + problemNo + '_output.txt'
        with open(input_filePath, 'w') as f:
            f.write(input_text)
        with open(output_filePath, 'w') as f:
            f.write(output_text)
    except  Exception as e:
        print(f"题目{problemNo}测试用例保存错误Except:", e)
    else:
        print(f'题目{problemNo}测试用例保存成功！')


'''
    爬取题解代码并保存
'''


def save_Code(codeInfo):
    problemNo, url = codeInfo
    print(f'正在解析{problemNo}的代码信息页面')
    html = requests.get(url).text
    soup = BeautifulSoup(html, 'html.parser')
    temp = soup.select("#program-source-text")[0].contents
    code = str(temp[0])
    code_clean = code.replace('\r', ' ').replace('\n', ' ').replace('\t', ' ')
    code_re = ' '.join(code_clean.split())
    pattern = re.compile('public class [^\s]* ')
    className = pattern.findall(code_re)[0].split(' ')[2].rstrip('{')
    try:
        '''
            设置相关文件名，并保存到相应文件夹目录中
        '''
        DirName = problemNo
        if not os.path.exists(DirName):  # 判断对应题目文件夹是否存在，不存在创建一个
            os.mkdir(DirName)
        code_filePath = DirName + '/' + className + '.java'
        with open(code_filePath, 'w') as f:
            f.write(code)
    except  Exception as e:
        print(f"题目{problemNo}代码保存错误Except:", e)
    else:
        print(f'题目{problemNo}代码保存成功！')


'''
    多进程回调函数，将题目对应Java8的解的代码链接返回并存入字典中
'''


def appendDict(codeURL):
    problemNo, submitID_codeURL = codeURL
    problemDict[problemNo]['submitID_codeURL'] = submitID_codeURL


'''
    多进程依次爬取题解提交ID、爬取测试用例并保存、爬取代码并保存
'''


def multiSpider():
    submissionsInfo = []
    for problemNo in problemDict:
        submit_URL = problemDict[problemNo]['problemSolvedURL']  # + '?order=BY_CONSUMED_TIME_ASC'
        submissionsInfo.append([problemNo, submit_URL])
    '''
        多进程爬取题目提交代码ID
    '''
    pool_getSubmission = Pool()
    for submission in submissionsInfo:
        pool_getSubmission.apply_async(get_submission, args=(submission,), callback=appendDict)
    pool_getSubmission.close()
    pool_getSubmission.join()
    print('——————————题目提交代码ID爬取保存完成——————————————')

    codesInfo = []
    testCaseInfo = []
    '''
        判断是否有Java8解，如果没有则删除对应题目，如果有添加代码链接和题目信息链接
    '''
    for problemNo in list(problemDict):
        if 'submitID_codeURL' in problemDict[problemNo]:
            codesInfo.append([problemNo, problemDict[problemNo]['submitID_codeURL']])
            testCaseInfo.append([problemNo, problemDict[problemNo]['problemInfoURL']])
        else:
            problemDict.pop(problemNo)
    '''
           多进程爬取题目测试用例并保存
    '''
    pool_getTestCase = Pool()
    for testCase in testCaseInfo:
        pool_getTestCase.apply_async(save_testCase, args=(testCase,))
    pool_getTestCase.close()
    pool_getTestCase.join()
    print('——————————题目测试用例爬取保存完成——————————————')
    '''
           多进程爬取题目代码并保存
    '''
    pool_getCode = Pool()
    for code in codesInfo:
        pool_getCode.apply_async(save_Code, args=(code,))
    pool_getCode.close()
    pool_getCode.join()
    print('——————————题目通过解代码爬取保存完成——————————————')


''' 
    遍历目录文件，检查爬取结果
'''


def checkFile():
    path = os.getcwd()
    countSum = 0
    countCompleted = 0
    for file in os.listdir(path):
        if file in ['.DS_Store', '.idea', 'codeforcesSpider.py', '__pycache__']:
            continue
        countSum += 1
        countChd = 0
        for fileChd in os.listdir(path + '/' + file):
            countChd += 1
        if countChd == 3:
            countCompleted += 1
        else:
            print('不完整文件夹', file)
            shutil.rmtree(file)
    print(f'爬取总文件数目:{countSum},完整文件数{countCompleted},爬取成功率{countCompleted / countSum}')


if __name__ == "__main__":
    start = time.time()
    startPage = 1  # 爬取多少页的题目数据
    endPage = 5
    codeforcesSpider = codeforcesSpider(startPage, endPage)
    codeforcesSpider.get_problem()
    multiSpider()
    end = time.time()
    print('耗费时间:', end - start)

    checkFile()
8