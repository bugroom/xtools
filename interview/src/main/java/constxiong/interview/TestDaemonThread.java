package constxiong.interview;

public class TestDaemonThread {

	public static void main(String[] args) {
		testDaemonThread();
	}
	
	public static void testDaemonThread() {
		Thread t = new Thread() {

			@Override
			public void run() {
				//创建线程，校验守护线程内创建线程是否为守护线程
				Thread t2 = new Thread() {

					@Override
					public void run() {
						System.out.println("t2 : " + (Thread.currentThread().isDaemon() ? "daemon thread" : "non-daemon thread"));
					} 
					
				};
				t2.start();
				
				//当所有用户线程执行完，守护线程会被直接杀掉，程序停止运行
				int i = 1;
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t : " + (Thread.currentThread().isDaemon() ? "daemon thread" : "non-daemon thread") + " , time : " + i);
					if (i++ >= 10) {
						break;
					}
				}
			}
			
		};
		t.start(); //setDaemon(true) 必须在 start() 之前设置，否则会抛出IllegalThreadStateException异常，该线程仍默认为用户线程，继续执行
		t.setDaemon(true);
//		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
