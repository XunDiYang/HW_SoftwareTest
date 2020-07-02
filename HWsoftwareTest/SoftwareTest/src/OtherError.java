/**
 * 输出之前不同的报错
 */
public class OtherError {
    private String errName;
    private String funName;

    public OtherError(String errName, String funName) {
        this.errName = errName;
        this.funName = funName;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    @Override
    public String toString() {
        return "\n错误类型='" + errName + '\'' + '\n'+
                "出错方法名='" + funName + '\'' +'\n';
    }
}
