package constxiong.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JDK 原子类测试
 * @author ConstXiong
 * @date 2019-06-11 11:22:01
 */
public class TestAtomic {

//	private int count = 0;
//	
//	public int getAndIncrement() {
//		return count++;
//	}
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public int getAndIncrement() {
		return count.getAndIncrement();
	}
	
	public static void main(String[] args) {
		final TestAtomic test = new TestAtomic();
		for (int i = 0; i < 3; i++) {
			new Thread(){
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " 获取递增值：" + test.getAndIncrement());
					}
				}
			}.start();
		}
	}
	
	
}
