/**
 * 输出不同
 */
public class OutputDiff {
    private String java7Output;
    private String java8Output;
    private String lines;
    private String functionName;

    public OutputDiff(String java7Output, String java8Output, String lines, String functionName) {
        this.java7Output = java7Output;
        this.java8Output = java8Output;
        this.lines = lines;
        this.functionName = functionName;
    }

    public String getJava7Output() {
        return java7Output;
    }

    public void setJava7Output(String java7Output) {
        this.java7Output = java7Output;
    }

    public String getJava8Output() {
        return java8Output;
    }

    public void setJava8Output(String java8Output) {
        this.java8Output = java8Output;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        String regx = "[a-zA-Z]+\\s+";
        String showLine = lines.replaceAll(regx,"");
        return "\n方法名='" + functionName + "\'\n"+
                "java8输出='" + java8Output + "\'\n" +
                "java7输出='" + java7Output + "\'\n"+
                "行数" + showLine +"\n";
    }
}
