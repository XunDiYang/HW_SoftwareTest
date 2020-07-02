// package tem1;

import java.util.Locale;
import java.util.Locale.Category;

public class LocalTest {
	public static void main(String[] args) {
		Locale loc = Locale.forLanguageTag("zh-Hans-CN");
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 8);
		System.out.println("-" + 8);
		System.out.println("@@Class: ");
		System.out.println("Locale");
		System.out.println("Call method: ");
		System.out.println("forLanguageTag");
		System.out.println("Input parameters: ");
		System.out.println("zh-Hans-CN");
		System.out.println("Return Value: ");
		System.out.println(loc);

		// Set default locale to en-US
		Locale.setDefault(Locale.US);

		System.out.println("Default Locale: en-US");
		String language = loc.getDisplayLanguage();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 14);
		System.out.println("-" + 14);
		System.out.println("@@Class: ");
		System.out.println("Locale");
		System.out.println("Call method: ");
		System.out.println("getDisplayLanguage");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(language);
		System.out.println();

		System.out.println(" langauge: " + language);
		String script = loc.getDisplayScript();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 16);
		System.out.println("-" + 16);
		System.out.println("@@Class: ");
		System.out.println("Locale");
		System.out.println("Call method: ");
		System.out.println("getDisplayScript");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(script);
		System.out.println();

		System.out.println(" script: " + script);

		// Set DISPLAY locale to zh-Hans-CN
		Locale.setDefault(Category.DISPLAY, loc);

		System.out.println("Default DISPLAY Locale: zh-Hans-CN");
		language = loc.getDisplayLanguage();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 23);
		System.out.println("-" + 23);
		System.out.println("@@Class: ");
		System.out.println("Locale");
		System.out.println("Call method: ");
		System.out.println("getDisplayLanguage");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(language);
		System.out.println();

		System.out.println(" langauge: " + language);
		script = loc.getDisplayScript();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 25);
		System.out.println("-" + 25);
		System.out.println("@@Class: ");
		System.out.println("Locale");
		System.out.println("Call method: ");
		System.out.println("getDisplayScript");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(script);
		System.out.println();

		System.out.println(" script: " + script);

	}
}
