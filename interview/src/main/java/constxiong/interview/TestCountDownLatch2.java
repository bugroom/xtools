package constxiong.interview;

import java.util.concurrent.CountDownLatch;

/**
 * 测试使用100个线程，并发访问和等待多线程完成后处理
 * @author ConstXiong
 */
public class TestCountDownLatch2 {

	private static CountDownLatch cdl = new CountDownLatch(100);
	
	private static int count = 0;
	
	public static void main(String[] args) {
		testConcurrent();
//		testDoAfterOtherThreadComplete();
	}
	
	/**
	 * 测试并发  do something...
	 */
	private static void testConcurrent() {
		for (int i = 0; i < 100; i++) {
			//启动线程
			new Thread(() -> {
				try {
					//当发令枪计数未减到 0 之前线程都会在此阻塞
					cdl.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " do something...");
			}).start();
			
			//发令枪计数减 1
			cdl.countDown();
		}
	}
	
	//测试等待多线程完成后处理
	private static void testDoAfterOtherThreadComplete() {
		//启动 100 个线程，对 count 递增
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				count++;
				//发令枪计数减 1
				cdl.countDown();
			}).start();
		}
		
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread print count : " + count);
	}
	
}
