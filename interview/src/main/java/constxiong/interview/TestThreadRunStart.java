package constxiong.interview;

public class TestThreadRunStart {

	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
				//休眠3秒
				try {
					Thread.sleep(3000);
					System.out.println("休眠3秒");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread running...");
			}
		};
		
//		testRun(t);
		testStart(t);
	}
	
	private static void testRun(Thread t) {
		t.run();
		//休眠1秒
		try {
			Thread.sleep(1000);
			System.out.println("休眠1秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void testStart(Thread t) {
		t.start();
		//休眠1秒
		try {
			Thread.sleep(1000);
			System.out.println("休眠1秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
