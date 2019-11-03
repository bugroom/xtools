package constxiong.interview;

import java.util.regex.Pattern;

/**
 * 测试实现 replaceAll 方法
 * @author ConstXiong
 */
public class TestReplaceAll {

	public static void main(String[] args) {
		String s = "01234abcd";
		System.out.println(replaceAll(s, "[a-z]", "CX"));
	}
	
	public static String replaceAll(String s, String regex, String replacement) {
		return Pattern.compile(regex).matcher(s).replaceAll(replacement);
	}
}
