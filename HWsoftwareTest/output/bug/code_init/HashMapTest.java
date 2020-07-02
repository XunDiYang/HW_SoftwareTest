package tem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("var1".toUpperCase(), "var");
		map.put("var".toUpperCase(), "var1");
		Set<String> varKeys = map.keySet();

	}

}
