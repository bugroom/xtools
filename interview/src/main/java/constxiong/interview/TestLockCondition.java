package constxiong.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 Lock Condition 的使用
 * @author ConstXiong
 * @date 2019-12-09 11:46:17
 */
public class TestLockCondition {
	
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				lock.lock();
				try {
					System.out.println(Thread.currentThread().getName() + " wait for the signal");
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				System.out.println(Thread.currentThread().getName() + " receive the signal, go on ");
			}).start();
		}
		
//		休眠5秒
		Thread.sleep(5000);
		
		new Thread(() -> {
			try {
				lock.lock();
				System.out.println("signal all current lock's condition");
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}).start();
		
	}
	
	
}
