package constxiong.interview;

public class TestSynchronized {
	
	public void sync() {
		synchronized (this) {
			System.out.println("sync");
		}
	}
}
