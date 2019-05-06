package constxiong.interview;

import java.util.ArrayList;
import java.util.List;

public class TestListCapacity {

	public static void main(String[] args) {
		List list = new ArrayList(3);
		list.add(1);
		list.add("1");
		list.add(new Double("1.1"));
		list.add("第四个元素,已经超过初始长度");
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
