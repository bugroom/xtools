package constxiong.interview;

/**
 * 跳出多重循环
 * @author ConstXiong
 */
public class TestBreakMulti {

	public static void main(String[] args) {
		A:for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(j);
				if (j == 5) {
					break A;
				}
			}
			
		}
	}
	
}
