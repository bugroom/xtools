package constxiong.interview;

public class TestOmitTryCatchFinally {

	public static void main(String[] args) {
		omitFinally();
		omitCatch();
	}
	
	/**
	 * 省略finally 语句块
	 */
	public static void omitFinally() {
		try {
			int i = 0;
			i += 1;
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 省略 catch 语句块
	 */
	public static void omitCatch() {
		int i = 0;
		try {
			i += 1;
		} finally {
			i = 10;
		}
		System.out.println(i);
	}
}
