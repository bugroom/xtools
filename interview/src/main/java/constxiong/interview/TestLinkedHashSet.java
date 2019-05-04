package constxiong.interview;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("1");
		for (String s : set) {
			System.out.println(s);
		}
	}
	
}
