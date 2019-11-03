package constxiong.interview;

/**
 * 测试修改形参
 * 
 * @author ConstXiong
 */
public class TestExchange {
	String str = new String("1");
	char[] arr = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		TestExchange te = new TestExchange();
		te.exchange(te.str, te.arr);
		System.out.print(te.str + " ");
		System.out.print(te.arr);
	}

	public void exchange(String str, char arr[]) {
		str = "2";
		arr[0] = 'd';
//		arr = new char[0];
	}
}
