package constxiong.interview;

/**
 * 递归计算n的阶乘
 * @author ConstXiong
 */
public class TestRecursionNFactorial {
	
	public static void main(String[] args) {
		System.out.println(recursionN(5));
	}
	
	/**
	 * 递归计算n的阶乘
	 * @param n
	 * @return
	 */
	private static int recursionN(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("参数必须大于0");
		} else if (n == 1) {
			return 1;
		} else {
			return n * recursionN(n - 1);
		}
	}

}
