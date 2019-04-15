package constxiong.interview;

/**
 * 测试finally 和 return的执行顺序  对返回结果的影响
 * @author ConstXiong
 * @date 2019-04-15 09:31:54
 */
public class TestReturnFinally {

	public static void main(String[] args) {
		System.out.println(getString());
	}
	
	public static String getString() {
		String str = "A";
		try {
			str = "B";
			return str;
		} finally {
			System.out.println("finally change return string to C");
			str = "C";
//			return str;
		}
	}
}
