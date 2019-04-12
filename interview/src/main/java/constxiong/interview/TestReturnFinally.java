package constxiong.interview;

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
