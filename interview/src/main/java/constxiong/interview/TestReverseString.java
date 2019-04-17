package constxiong.interview;

public class TestReverseString {

	public static void main(String[] args) {
		String str = "ABCDE";
		System.out.println(reverseStringByStringBuilderApi(str));
		System.out.println(reverseString(str));
	}
	
	public static String reverseStringByStringBuilderApi(String str) {
		if (str != null && str.length() > 0) {
			return new StringBuilder(str).reverse().toString();
		}
		return str;
	}
	
	public static String reverseString(String str) {
		if (str != null && str.length() > 0) {
			int len = str.length();
			char[] chars = new char[len];
			for (int i = len - 1; i >= 0; i--) {
				chars[len - 1 - i] = str.charAt(i);
			}
			return new String(chars);
		}
		return str;
	}
}
