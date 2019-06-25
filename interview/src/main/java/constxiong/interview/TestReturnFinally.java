package constxiong.interview;

/**
 * 测试finally 和 return的执行顺序 对返回结果的影响
 * 
 * @author ConstXiong
 * @date 2019-04-15 09:31:54
 */
public class TestReturnFinally {

	public static void main(String[] args) {
		 System.out.println(getString());
		// System.out.println(getStringBuffer().toString());
	}

	// public static String getString() {
		// String str = "A";
		// try {
		// str = "B";
		// return str;
		// } finally {
		// System.out.println("finally change return string to C");
		// str = "C";
		// // return str;
		// }
	// }

	public static String getString() {
		StringBuffer str = new StringBuffer("A");
		try {
			str.append("B");
			return str.toString();
		} finally {
			str.append("ccc");
			System.out.println("finally change return string to C");
			// return str; // 如果该行未注释 返回 C
		}
	}

	public static StringBuffer getStringBuffer() {
		StringBuffer str = new StringBuffer("A");
		try {
			str.append("B");
			return str;
		} finally {
			// str.append("c");
			str = new StringBuffer("ABC");
			System.out.println("finally change return string to C");
			// return str; // 如果该行未注释 返回 C
		}
	}
}
