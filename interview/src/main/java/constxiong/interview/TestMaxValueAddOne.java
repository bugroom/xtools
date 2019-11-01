package constxiong.interview;

/**
 * 测试最大值加1
 * @author ConstXiong
 */
public class TestMaxValueAddOne {

	public static void main(String[] args) {
		// int i = Integer.MAX_VALUE;
		// System.out.println(i+1< i);
		// System.out.println(i+1);
		int i = 2;
		int result = 0;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i * 2;
		case 3:
			result = result + i * 3;
		}
		System.out.println(result);
	}

}
