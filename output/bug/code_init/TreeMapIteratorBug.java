package tem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapIteratorBug {
	public static void main(String[] argv) throws Exception {
		NavigableMap<String, Object> map = new TreeMap<String, Object>();
		map.put("a", 1);
		map.put("b", 1);
		map.put("c", 1);

		List<String> keys = new ArrayList<String>();
		keys.addAll(map.descendingMap().keySet());

		Iterator<String> iterator = map.navigableKeySet().descendingIterator();

		for (int i = 0; i < 3; i++) {

			System.out.println("keys.get: " + keys.get(i));

			if (i == 2) {
				iterator.remove();
			}
			
			String key = iterator.next();
			System.out.println("key: " + key);
		}
	}
}
