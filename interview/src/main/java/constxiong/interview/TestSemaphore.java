package constxiong.interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试使用信号量实现锁的效果
 * @author ConstXiong
 * @date 2019-12-18 14:18:47
 */
public class TestSemaphore {

	private static int count;
	
	private static AtomicInteger acount = new AtomicInteger(0);
	
	private static Semaphore semaphore = new Semaphore(10); 
	
	public static void main(String[] args) {
//		testAdd();
		testAddAtomic();
	}
	
	private static void testAdd() {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				add();
				System.out.println(count);
			}).start();
		}
	}
	
	private static void add() {
		try {
			semaphore.acquire();
			Thread.sleep(100);
			count++;
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private static void testAddAtomic() {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				System.out.println(addAtomic());
			}).start();
		}
	}
	
	private static int addAtomic() {
		try {
			semaphore.acquire();
			Thread.sleep(100);
			return acount.incrementAndGet();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
		return -1;
	}
	
}
