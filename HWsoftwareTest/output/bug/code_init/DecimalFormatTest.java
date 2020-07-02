package tem1;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.setDecimalSeparatorAlwaysShown(true);
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(1);
        
        String ans = format.format(83.65);
        
        System.out.println(ans);
    }
}
