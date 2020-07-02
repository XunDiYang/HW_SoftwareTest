import java.util.ArrayList;

/**
 * 文件的不同信息
 */
public class DiffDescribe {
    /**
     * 内容不同文件的文件名
     */
    private String fileName;
    /**
     * 输出之前的报错列表
     */
    private ArrayList<OtherError> error;
    /**
     * 输出不同的格式
     */
    private ArrayList<OutputDiff> outputDiff;

    public DiffDescribe() {
        error = new ArrayList<>();
        outputDiff = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<OtherError> getError() {
        return error;
    }

    public ArrayList<OutputDiff> getOutputDiff() {
        return outputDiff;
    }

    public String getOnlyOutputDiff(){
        String result = "";
        if(outputDiff.size()!=0){
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "输出不同=" + outputDiff +"\n"
                    +"-------------------------\n";
        }
        return result;
    }

    public String getOnlyError(){
        String result = "";
        if(error.size()!=0){
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "输出之前的不同=" + error + "\n"+
                    "-------------------------\n";
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        if(error.size()==0&&outputDiff.size()==0){
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "文件在java7或java8中为空\n" +
                    "-------------------------\n";
        }else if(error.size()==0){
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "输出不同=" + outputDiff +"\n" +
                    "-------------------------\n";
        }else if(outputDiff.size()==0){
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "输出之前的不同=" + error + "\n"+
                    "-------------------------\n";
        }else{
            result = "\n-------------------------\n"+
                    "文件名='" + fileName + '\'' + '\n'+
                    "输出之前的不同=" + error + "\n"+
                    "输出不同=" + outputDiff +"\n"
                    +"-------------------------\n";
        }

        return result;
    }
}
