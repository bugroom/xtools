package constxiong.interview;

/**
 * 测试 ++i 和 i++
 * @author ConstXiong
 * @date 2019-10-17 13:44:05
 */
public class TestAdd {
	
	TestAdd () {
		
	}

	public static void main(String[] args) {
		int a = 3;
		int b = a++;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		int x = 3;
		int y = ++x;
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
	
}
