package constxiong.interview;

import java.util.Hashtable;
import java.util.Map;

public class TestHashTable {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
//		map.put(null, "1");
		map.put("1", null);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
	}
	
}
