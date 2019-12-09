package constxiong.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过 Condition 实现生产者、消费者模式
 * 
 * @author ConstXiong
 * @date 2019-12-09 14:08:49
 */
public class TestProducerAndConsumerByCondition {

	static List<Object> list = new ArrayList<Object>();

	static int maxSize = 10;

	static Lock lock = new ReentrantLock();

	static Condition full = lock.newCondition();

	static Condition empty = lock.newCondition();
	
	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while (true) {
				lock.lock();
				try {
					if (list.size() >= maxSize) {
						System.out.println("集合已满，等待消费");
						full.await();
					}
					list.add(new Object());
					System.out.println("生产一个对象，剩余" + list.size());
					empty.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}, "Producer").start();

		// 启动消费者线程
		new Thread(() -> {
			while (true) {
				lock.lock();
				try {
					if (list.size() == 0) {
						System.out.println("集合为空，等待生产");
						empty.await();
					}
					System.out.println("消费一个对象，剩余：" + list.size());
					list.remove(0);
					full.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}, "Consumer").start();

	}

}
