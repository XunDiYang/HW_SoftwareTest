package tem1;

import java.util.Locale;
import java.util.Locale.Category;

public class LocalTest {
	public static void main(String [] args) {
		Locale loc = Locale.forLanguageTag("zh-Hans-CN");

		// Set default locale to en-US
		Locale.setDefault(Locale.US);

		System.out.println("Default Locale: en-US");
		String language = loc.getDisplayLanguage();
		System.out.println(" langauge: " + language);
		String script = loc.getDisplayScript();
		System.out.println(" script: " + script);

		// Set DISPLAY locale to zh-Hans-CN
		Locale.setDefault(Category.DISPLAY, loc);

		System.out.println("Default DISPLAY Locale: zh-Hans-CN");
		language = loc.getDisplayLanguage();
		System.out.println(" langauge: " + language);
		 script = loc.getDisplayScript();
		System.out.println(" script: " + script);



	}
}
