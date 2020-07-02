# 软件测试与质量保证课程作业

## 作业说明

​	自动检测在JRE7 和 JRE8 运行环境下，返回结果不同的函数

## 小组成员

- 1120172169杨训迪(组长)
- 1120170121黄舒心
- 1120171197孙浩辰
- 1120171210张帜航

## 文件夹内容

- CFspider.py

  爬虫代码，主要爬取codeforce上提交的java代码

- SearchFiles.py

  爬取Java7和Java8源码下的所有.java文件，并将文件名分别保存在jre1.7.json和jre1.8.json下。

- tem4
  
  插桩部分和运行部分
  
  1. code_init
  
     需要插桩所有源码，为输入
  
  2. code_stub
  
     存放中间结果，经过自动化插桩后的.java文件及相应的输入
  
  3. bat 
  
     存放 java7.bat和java8.bat，即批量运行的命令
  
  4. java7_output 
  
     存放在jre7下批量运行的结果
  
  5. java8_output 
  
     存放在jre8下批量运行的结果
  
  6. src\com\yxd\tem4
  
     存放源码。其中GenerateStubFile.java为主运行代码, Parser.java实现自动化插桩过程,  SrcFileSearch.java实现确定是否为jre7(jre8)中接口调用
  
- SoftwareTest
  
  比较分别在jre7和jre8运行下的输出结果的代码部分
  
  1. SoftwareTest\src\softwareTest
  
     主函数入口，处理并且比较java7文件夹与java8文件夹下同名文件的内容。
  
  2. SoftwareTest\src\OutputDiff
  
     输出不同的纪录类，用来记录java7与Java8中同一方法的不同输出。
  
  3. SoftwareTest\src\OtherError
  
     输出之前不同的纪录类，用来记录java7与java8中同一方法除了输出之外的不同。
  
  4. SoftwareTest\src\DiffDescribe
  
     所有不同的包装类，其中拥有输出不同的List、输出之前不同的List、当前比较稳健的文件名等信息。
  
- output
  
  输出结果及相关文件
  
  1. output_diff.txt
  
     最终java7和java8的输出结果比较情况
  
  2. bug
  
     提取与最终比较结果所对应的中间结果(包含自动化插桩后，经过手动修改后的插桩文件)