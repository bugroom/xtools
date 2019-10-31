package constxiong.interview;

public class TestDoWhile {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		
		do{
			--b;
			a = a - 1;
		} while (b > 0);
		
		System.out.println(b);
	}
}
