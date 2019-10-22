package constxiong.interview;

public class TestSub extends TestSuper {
	
	public TestSub() {
		super();
		System.out.println(1);
	}
	
	TestSub(int x) {
		System.out.println(x);
	}

	@Override
	public Integer add(int x, int y) {
		return  x + y;
	}
	
	public static void main(String[] args) {
		TestSub ts = new TestSub(2);
	}

}
