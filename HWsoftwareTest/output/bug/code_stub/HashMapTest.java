//package tem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("var1".toUpperCase(), "var");
		map.put("var".toUpperCase(), "var1");

		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 11);
		System.out.println("-" + 12);
		System.out.println("@@Class: ");
		System.out.println("Map");
		System.out.println("Call method: ");
		System.out.println("put");
		System.out.println("Input parameters: ");
		System.out.println("var1".toUpperCase() + "=var");
		System.out.println("var".toUpperCase() + "=var1");
		System.out.println("Return Value: ");
		System.out.println(map);

		Set<String> varKeys = map.keySet();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 13);
		System.out.println("-" + 13);
		System.out.println("@@Class: ");
		System.out.println("Map");
		System.out.println("Call method: ");
		System.out.println("keySet");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(varKeys);

	}

}
