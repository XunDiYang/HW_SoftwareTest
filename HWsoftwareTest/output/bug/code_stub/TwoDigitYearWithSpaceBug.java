// package tem1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TwoDigitYearWithSpaceBug {

	public static void main(String[] args) throws ParseException {
		final SimpleDateFormat parseFormat = new SimpleDateFormat("MM/dd/yy", Locale.US);
		final SimpleDateFormat fmtFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

		// Parse input without space:
		final Date d1 = parseFormat.parse("01/01/12");
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 15);
		System.out.println("-" + 15);
		System.out.println("@@Class: ");
		System.out.println("SimpleDateFormat");
		System.out.println("Call method: ");
		System.out.println("parse");
		System.out.println("Input parameters: ");
		System.out.println("01/01/12");
		System.out.println("Return Value: ");
		System.out.println(d1);

		System.out.println("Without Space: " + fmtFormat.format(d1));

		// BUG HERE - Parse input with space:
		final Date d2 = parseFormat.parse("01/01/ 12");
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 19);
		System.out.println("-" + 19);
		System.out.println("@@Class: ");
		System.out.println("SimpleDateFormat");
		System.out.println("Call method: ");
		System.out.println("parse");
		System.out.println("Input parameters: ");
		System.out.println("01/01/ 12");
		System.out.println("Return Value: ");
		System.out.println(d2);

		System.out.println("With Space: " + fmtFormat.format(d2));
	}
}
