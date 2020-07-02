 package tem1;

import java.text.NumberFormat;

class NumberFormatTest {

    public static void main(String[] args) {
        NumberFormat format = (NumberFormat) NumberFormat.getInstance();
//        format.setParseIntegerOnly(true);
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(1);
        
        String ans = format.format(83.65);
        System.out.println(ans);
    }
  }