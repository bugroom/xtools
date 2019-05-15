package constxiong.interview;

public class TestWaitSleep {

	private static Object obj = new Object();
	
	public static void main(String[] args) {
		
		//测试sleep()
		//测试 RunnableImpl1 wait(); RunnableImpl2 notify()
		Thread t1 = new Thread(new RunnableImpl1(obj));
		Thread t2 = new Thread(new RunnableImpl2(obj));
		t1.start();
		t2.start();
		
		//测试RunnableImpl3 wait(long timeout)方法
		Thread t3 = new Thread(new RunnableImpl3(obj));
		t3.start();
	}

	
}

class RunnableImpl1 implements Runnable {

	private Object obj;
	
	public RunnableImpl1(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		System.out.println("run on RunnableImpl1");
		synchronized (obj) {
			System.out.println("obj to wait on RunnableImpl1");
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("obj continue to run on RunnableImpl1");
		}
	}
}

class RunnableImpl2 implements Runnable {

	private Object obj;
	
	public RunnableImpl2(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		System.out.println("run on RunnableImpl2");
		System.out.println("睡眠3秒...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (obj) {
			System.out.println("notify obj on RunnableImpl2");
			obj.notify();
		}
	}
}

class RunnableImpl3 implements Runnable {

	private Object obj;
	
	public RunnableImpl3(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		System.out.println("run on RunnableImpl3");
		synchronized (obj) {
			System.out.println("obj to wait on RunnableImpl3");
			try {
				obj.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("obj continue to run on RunnableImpl3");
		}
	}
}