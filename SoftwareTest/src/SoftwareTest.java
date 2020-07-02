import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 自动对比两个文件夹下的相同文件
 *
 * 格式如下：
 *
 * The line : Lines 9-9//从第几行到第几行
 * @@Class: //返回值类型
 * Integer
 * Call method: //方法名
 * parseInt//方法名
 * Input parameters: //输入参数
 * //参数
 * Return value: 2
 */
public class SoftwareTest {

    /**
     * TODO:填入根目录
     */
    private static final String rootPath = "C:/Users/Shinelon/Desktop/AcmCode";

    private static Integer sameFile = 0;

    private static LinkedList<String> fileName7;
    private static LinkedList<String> fileName8;
    private static String java7Path;
    private static String java8Path;

    private static ArrayList<DiffDescribe> outputList = new ArrayList<>();

    public static void main(String[] args) {
        java7Path = rootPath + "/" + "java7_output";
        java8Path = rootPath + "/" + "java8_output";

        System.out.println("java7文件路径："+java7Path);
        System.out.println("java8文件路径："+java8Path);


        getFiles();
//        fileName7 = new LinkedList<>();
//        fileName8 = new LinkedList<>();
//        fileName7.add("1000A_output.txt");
//        fileName8.add("1000A_output.txt");


        BufferedReader br7;
        BufferedReader br8;

        Iterator<String> it = fileName7.iterator();
        while(it.hasNext()){
            String temp7 = it.next();
//            String temp7 = "1000A_output.txt";
            if(fileName8.contains(temp7)){
                //如果包含相同文件在java8
                File java7 = new File(java7Path+"/"+temp7);
                File java8 = new File(java8Path+"/"+temp7);

                //如果文件相同直接跳过
                if(getFileMD5(java7).equals(getFileMD5(java8))){
                    sameFile++;
                    continue;
                }

                try {

                    //文件不同时需要比较
                    br7 = new BufferedReader(new FileReader(java7));
                    br8 = new BufferedReader(new FileReader(java8));

                    DiffDescribe diff = new DiffDescribe();
                    diff.setFileName(temp7);
                    compareFile(br7,br8,diff);

                    br7.close();
                    br8.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        System.out.println("相同文件数量为："+sameFile);
        System.out.println("java7中文件数量为："+fileName7.size());
        System.out.println("java8中文件数量为："+fileName8.size());
        System.out.println("不同List的size: "+outputList.size());
        for (DiffDescribe diffDescribe : outputList) {
//            writeToTXT(diffDescribe.toString());
            writeToTXT(diffDescribe.getOnlyOutputDiff(),"output_diff.txt");
            writeToTXT(diffDescribe.getOnlyError(),"before_output_diff.txt");
        }
    }

    private static void getFiles(){
        fileName7 = new LinkedList<>();
        fileName8 = new LinkedList<>();

        File filePath = new File(java7Path);
        File[] files = filePath.listFiles();

        for (File file : files) {
            if(file.isFile()){
                fileName7.add(file.getName());
            }
        }

        System.out.println("java7:  "+fileName7.size());

        filePath = new File(java8Path);
        files = filePath.listFiles();

        for (File file : files) {
            if(file.isFile()){
                fileName8.add(file.getName());
            }
        }

        System.out.println("java8:  "+fileName8.size());
    }

    /**
     * 计算文件的 MD5 值
      */
    private static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest =MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void compareFile(BufferedReader b1,BufferedReader b2,DiffDescribe diff) throws IOException {
        String line1 = b1.readLine();
        String line2 = b2.readLine();

        String funcName = "";
        String lineNumber = "";

        while(line1!=null&&
                line2!=null){

            //行数不同的情况
            if(line1.contains("The line")&&line2.contains("The line")){
                if(line1.equals(line2)){
                    lineNumber = line1;
                    line1 = b1.readLine();
                    line2 = b2.readLine();
                    continue;
                }

                //为了读到方法名
                line1 = b1.readLine();
                line2 = b2.readLine();

                diff.getError().add(new OtherError("行数不同","java7: " + b1.readLine() + "\njava8: "+b2.readLine()+"\n"));
                line1 = jump2NextFunction(b1);
                line2 = jump2NextFunction(b2);
                continue;
            }
//
//            //返回参数不同的情况
//            if(line1.contains("@@Class")&&line2.contains("@@Class")){
//
//                line1 = b1.readLine();
//                line2 = b2.readLine();
//
//                if(line1.equals(line2)){
//
//                    line1 = b1.readLine();
//                    line2 = b2.readLine();
//                    continue;
//                }
//
//                diff.getError().add(new OtherError("返回参数不同","java7: "+line1+ "\njava8: "+line2));
//                line1 = jump2NextFunction(b1);
//                line2 = jump2NextFunction(b2);
//                continue;
//            }
//
//            //方法名不同
            if(line1.contains("Call method")&&line2.contains("Call method")){

                line1 = b1.readLine();
                line2 = b2.readLine();

                if(line1.equals(line2)){
                    funcName = line1;

                    line1 = b1.readLine();
                    line2 = b2.readLine();
                    continue;
                }

                diff.getError().add(new OtherError("方法名不同","java7 :" + line1 + "\njava8: " + line2 +"\n"));
                line1 = jump2NextFunction(b1);
                line2 = jump2NextFunction(b2);
                continue;
            }
//
//            //输入参数不同
//            if(line1.contains("Input parameters")&&line2.contains("Input parameters")){
//
//                line1 = b1.readLine();
//                line2 = b2.readLine();
//                while (line1!=null&&line2!=null&&(!line1.contains("Return value")&&(!line1.contains("The line")))
//                &&(!line2.contains("Return value"))){
//
//                    if(line1==null&&line2==null||
//                            line1!=null&&line2!=null&&line1.equals(line2)){
//
//                        line1 = b1.readLine();
//                        line2 = b2.readLine();
//                        continue;
//                    }
//
//                    diff.getError().add(new OtherError("输入参数不同",funcName));
//                    line1 = jump2NextFunction(b1);
//                    line2 = jump2NextFunction(b2);
//                    break;
//                }
//                continue;
//            }


            //输出不同，重点部分

            if(!line1.equals(line2)){
                line1 = jump2NextFunction(b1);
                line2 = jump2NextFunction(b2);
                continue;
            }

            if(line1.contains("Return")&&line2.contains("Return")){
                StringBuilder java7 = new StringBuilder(line1);
                StringBuilder java8 = new StringBuilder(line2);

                line1 = b1.readLine();
                line2 = b2.readLine();
                while(line1!=null&&line2!=null&&!line1.contains("The line")&&
                !line2.contains("The line")){

                    java7.append(line1);
                    java8.append(line2);

                    line1 = b1.readLine();
                    line2 = b2.readLine();
                }

                String string7 = java7.toString();
                String string8 = java8.toString();
                if(string7.equals(string8)||string7.contains("@")){
                    continue;
                }else{

                    if(line1==null){
                        diff.getOutputDiff().add(new OutputDiff(java7.toString(),java8.toString(),lineNumber,funcName));
                    }else{
                        diff.getOutputDiff().add(new OutputDiff(java7.toString(),java8.toString(),lineNumber,funcName));
                    }
                }
            }

            if(line1!=null&&line1.equals(line2)){
                line1 = b1.readLine();
                line2 = b2.readLine();
                continue;
            }
        }

        outputList.add(diff);
    }

    private static String jump2NextFunction(BufferedReader br) throws IOException {
        String line = br.readLine();
        while(line!=null&&!line.contains("The line")){
            line = br.readLine();
        }

        return line;
    }


    private static void writeToTXT(String str,String fileName){
        FileOutputStream o = null;
        String path="C:/Users/Shinelon/Desktop/AcmCode";
        byte[] buff = new byte[]{};
        try{
            File file = new File(path+"/"+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            buff=str.getBytes();
            o=new FileOutputStream(file,true);
            o.write(buff);
            o.flush();
            o.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
