// package tem1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest {
	private static final Pattern ESCAPER_PATTERN = Pattern.compile("[^a-zA-Z0-9\\p{P}\\s]*");

	/**
	 * @param args
	 */
	public static void main(String[] args)

	{
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 7);
		System.out.println("-" + 7);
		System.out.println("@@Class: ");
		System.out.println("Pattern");
		System.out.println("Call method: ");
		System.out.println("compile");
		System.out.println("Input parameters: ");
		System.out.println("[^a-zA-Z0-9\\p{P}\\s]*");
		System.out.println("Return Value: ");
		System.out.println(ESCAPER_PATTERN);

		String unaccentedText = "Aa123 \\/*-+.ac!e§('\"~´][{^";
		Matcher matcher = ESCAPER_PATTERN.matcher(unaccentedText);
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 16);
		System.out.println("-" + 16);
		System.out.println("@@Class: ");
		System.out.println("Pattern");
		System.out.println("Call method: ");
		System.out.println("matcher");
		System.out.println("Input parameters: ");
		System.out.println(unaccentedText);
		System.out.println("Return Value: ");
		System.out.println(matcher);

		String str = matcher.replaceAll("");
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 17);
		System.out.println("-" + 17);
		System.out.println("@@Class: ");
		System.out.println("Matcher");
		System.out.println("Call method: ");
		System.out.println("replaceAll");
		System.out.println("Input parameters: ");
		System.out.println("");
		System.out.println("Return Value: ");
		System.out.println(str);

		System.out.println();
		System.out.println(str);

	}
}
