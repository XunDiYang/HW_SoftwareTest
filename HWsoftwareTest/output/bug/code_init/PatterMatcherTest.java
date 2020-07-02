package tem1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest {
	private static final Pattern ESCAPER_PATTERN = Pattern.compile("[^a-zA-Z0-9\\p{P}\\s]*");

	/**
	 * @param args
	 */
	public static void main(String[] args)

	{	
		String unaccentedText = "Aa123 \\/*-+.ac!e§('\"~´][{^";
		Matcher matcher = ESCAPER_PATTERN.matcher(unaccentedText);
		String str =matcher.replaceAll("");

		System.out.println(str);

	}
}
