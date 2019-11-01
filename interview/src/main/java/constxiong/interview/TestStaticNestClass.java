package constxiong.interview;

/**
 * 测试静态内部类
 * @author ConstXiong
 * @date 2019-11-01 09:16:12
 */
public class TestStaticNestClass {
	
	static int a = 1;

	public static void main(String[] args) {
//		TestStaticNestClass.StaicInner si = new TestStaticNestClass.StaicInner();
		StaicInner si = new TestStaticNestClass.StaicInner();
		si.print();
	}
	
	static class StaicInner {
		
		public void print() {
			System.out.println(a);
		}
	}
}
