// package tem1;

import java.text.NumberFormat;

class NumberFormatTest {

	public static void main(String[] args) {
		NumberFormat format = (NumberFormat) NumberFormat.getInstance();
//        format.setParseIntegerOnly(true);	
		format.setMinimumFractionDigits(1);
		format.setMaximumFractionDigits(1);

		String ans = format.format(83.65);
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 13);
		System.out.println("-" + 13);
		System.out.println("@@Class: ");
		System.out.println("NumberFormat");
		System.out.println("Call method: ");
		System.out.println("format");
		System.out.println("Input parameters: ");
		System.out.println(83.65);
		System.out.println("Return Value: ");
		System.out.println(ans);

		System.out.println();
		System.out.println(ans);
	}
}
