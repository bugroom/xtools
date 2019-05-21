package constxiong.interview;

public class TestDeadLock {

	final static Object o1 = new Object();
	
	final static Object o2 = new Object();
	
	public static void main(String[] args) {
		//先持有 o1 的锁，再去获取 o2 的锁
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				synchronized (o1) {
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到 o1 对象的锁");
					try {
						System.out.println("休眠1秒");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("线程：" + Thread.currentThread().getName() + " 去获取 o2 对象的锁");
					synchronized (o2) {
						System.out.println("线程：" + Thread.currentThread().getName() + " 成功获取 o2 对象的锁");
					}
				}
			}
			
		};
		
		//先持有 o2 的锁，再去获取 o1 的锁
		Thread t2 = new Thread() {
			
			@Override
			public void run() {
				synchronized (o2) {
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到 o2 对象的锁");
					try {
						System.out.println("休眠1秒");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("线程：" + Thread.currentThread().getName() + " 去获取 o1 对象的锁");
					synchronized (o1) {
						System.out.println("线程：" + Thread.currentThread().getName() + " 成功获取 o1 对象的锁");
					}
				}
			}
			
		};
		
		
		t1.start();
		t2.start();
	}
	
}

