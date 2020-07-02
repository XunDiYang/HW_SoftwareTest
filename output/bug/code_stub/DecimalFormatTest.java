//package tem1;

import java.text.DecimalFormat;

public class DecimalFormatTest {
	public static void main(String[] args) {
		DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
		format.setDecimalSeparatorAlwaysShown(true);
		format.setMinimumFractionDigits(1);
		format.setMaximumFractionDigits(1);

		String ans = format.format(83.65);
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 12);
		System.out.println("-" + 12);
		System.out.println("@@Class: ");
		System.out.println("DecimalFormat");
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
