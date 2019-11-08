package constxiong.interview;

import java.util.concurrent.CountDownLatch;

/**
 * 创建 n 多个线程，如何保证这些线程同时启动？
 * @author ConstXiong
 * @date 2019-11-07 17:17:08
 */
public class TestCountDownLatch {

	private static CountDownLatch cdl = new CountDownLatch(10);
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						cdl.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
				}
			});
			t.start();
			cdl.countDown();
		}
	}
	
}
