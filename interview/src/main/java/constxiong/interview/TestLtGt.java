package constxiong.interview;

public class TestLtGt {
	
	public static void main(String[] args) {
		testDisplacement();
	}

	/**
	 * 测试位移
	 */
	public static void testDisplacement() {
		System.out.println("16 << 1 : " + (16 << 1));
		System.out.println("16 >> 3 : " + (16 >> 3));
		System.out.println("16 >> 10 : " + (16 >> 10));
		System.out.println("1 >> 1 : " + (16 >> 10));
		System.out.println("16 >>> 2 : " + (16 >>> 2));
		System.out.println("-16 >> 2 : " + (-16 >> 2));
		System.out.println("-16 << 2 : " + (-16 << 2));
		System.out.println("-16 >>> 2 : " + (-16 >>> 2));
	}
	
}
