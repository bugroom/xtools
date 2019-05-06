package constxiong.interview;

import java.util.Arrays;
import java.util.List;


public class TestConvertorBetweenArrayAndList {

	public static void main(String[] args) {
		testArray2List();
		testList2Array();
	}
	
	public static void testArray2List() {
		String[] strs = new String[] {"aaa", "bbb", "ccc"};
		List<String> list = Arrays.asList(strs);
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	public static void testList2Array() {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		String[] array = list.toArray(new String[list.size()]);
		for (String s : array) {
			System.out.println(s);
		}
	}
}
