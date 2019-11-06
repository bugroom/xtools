package constxiong.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 测试剔除List的相同元素
 * @author ConstXiong
 * @date 2019-11-06 16:33:17
 */
public class TestRemoveListSameElement {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("1", "2", "3", "1");
		Set<String> s = new HashSet<String>(l);
		System.out.println(s);
	}
	
}
