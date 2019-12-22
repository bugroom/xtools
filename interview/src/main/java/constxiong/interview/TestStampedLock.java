package constxiong.interview;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

/**
 * 测试 StampedLock
 * @author ConstXiong
 */
public class TestStampedLock {

	private static final StampedLock sl = new StampedLock();
	
	private static volatile int count = 0;
	
	private static final Random r = new Random();
	
	public static void main(String[] args) {
		//启动 5个线程写计数,95 个线程读计数,
		for (int i = 0; i < 100; i++) {
			if (i % 20 == 0) {
				new Thread(() -> {
					try {
						Thread.sleep(r.nextInt(10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " 计数新增 1 :" + add());
				}).start();
			} else {
				new Thread(() -> {
					try {
						Thread.sleep(r.nextInt(10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " 读计数:" + read());
				}).start();
			}	
		}
	}
	
	/**
	 * 读取计数
	 * @return
	 */
	private static int read() {
		int r;
		long stamp = sl.tryOptimisticRead();
		r = count;
		if (!sl.validate(stamp)) {
			stamp = sl.readLock();
			try {
				r = count;
			} finally {
				sl.unlockRead(stamp);
			}
		}
		return r; 
	}
	
	/**
	 * 计数加 1
	 */
	private static int add() {
		long stamp = sl.writeLock();
		try {
			count++;
		} finally {
			sl.unlockWrite(stamp);
		}
		return count;
	}
	
}
