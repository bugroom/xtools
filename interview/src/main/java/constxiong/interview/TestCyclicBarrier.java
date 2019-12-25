package constxiong.interview;

import java.util.concurrent.CyclicBarrier;

/**
 * 测试 CyclicBarrier 的使用
 * @author ConstXiong
 * @date 2019-12-25 19:22:50
 */
public class TestCyclicBarrier {

	public static void main(String[] args) {
		int parts = 10;
		final CyclicBarrier cb = new CyclicBarrier(parts, () -> {
			System.out.println(Thread.currentThread().getName() + ": I'am is last Thread");
		});
		
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + ": I'am come");
				try {
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ": go together");
			}).start();
		}
		
	}
	
}
