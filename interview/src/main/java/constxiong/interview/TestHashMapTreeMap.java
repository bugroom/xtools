package constxiong.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMapTreeMap {

	public static void main(String[] args) {
		testHashMap();
		testTreeMap();
	}
	
	public static void testHashMap() {
		long s1 = System.currentTimeMillis();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			map.put(i, i);
		}
		long s2 = System.currentTimeMillis();
		System.out.println(s2 - s1);
	}
	
	public static void testTreeMap() {
		long s1 = System.currentTimeMillis();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			map.put(i, i);
		}
		long s2 = System.currentTimeMillis();
		System.out.println(s2 - s1);
	}
	
}
