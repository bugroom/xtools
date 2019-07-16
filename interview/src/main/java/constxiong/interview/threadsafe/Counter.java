package constxiong.interview.threadsafe;

/**
 * 计数类
 * @author ConstXiong
 * @date 2019-07-16 14:35:40
 */
public class Counter {

	private int count = 0;
	
	public void addAndPrint() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(++count);
	}
	
}
