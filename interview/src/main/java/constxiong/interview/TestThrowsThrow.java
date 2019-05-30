package constxiong.interview;

import java.io.IOException;

public class TestThrowsThrow {

	public static void main(String[] args) {
		testThrows();
		
		Integer i = null;
		testThrow(i);
		
		String filePath = null;
		try {
			testThrow(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试 throws 关键字
	 * @throws NullPointerException
	 */
	public static void testThrows() throws NullPointerException {
		Integer i = null;
		System.out.println(i + 1);
	}
	
	/**
	 * 测试 throw 关键字抛出 运行时异常
	 * @param i
	 */
	public static void testThrow(Integer i) {
		if (i == null) {
			throw new NullPointerException();//运行时异常不需要在方法上申明
		}
	}
	
	/**
	 * 测试 throw 关键字抛出 非运行时异常，需要方法体需要加 throws 异常抛出申明
	 * @param i
	 */
	public static void testThrow(String filePath) throws IOException {
		if (filePath == null) {
			throw new IOException();//运行时异常不需要在方法上申明
		}
	}
}
