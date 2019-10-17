package constxiong.interview;

/**
 * 测试 & &&
 * @author ConstXiong
 */
public class TestAnd {

	public static void main(String[] args) {
		int x = 10;
		int y = 9;
		if (x == 9 & ++y > 9) {
		}
		System.out.println("x = " + x + ", y = " + y);
		
		int a = 10;
		int b = 9;
		if (a == 9 && ++b > 9) {//a == 9 为 false，所以 ++b 不会运算，b=9
		}
		System.out.println("a = " + a + ", b = " + b);
		
		/*
		00000000000000000000000000000001
		&
		00000000000000000000000000000010
		=
		00000000000000000000000000000000
		*/
		System.out.println(1 & 2);//打印0
	}
	
}
