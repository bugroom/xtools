package constxiong.interview.threadlocal;

public class ThreadLocalClient extends Thread {

	private Sequence sequence;
	
	public ThreadLocalClient(Sequence sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 30000; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " => " + sequence.getNumber());
		}
	}
	
	public static void main(String[] args) {
//		testSeqA();
		testSeqB();
	}
	
	public static void testSeqA() {
		Sequence sequence = new SequenceA();
		ThreadLocalClient c1 = new ThreadLocalClient(sequence);
		ThreadLocalClient c2 = new ThreadLocalClient(sequence);
		ThreadLocalClient c3 = new ThreadLocalClient(sequence);
		c1.start();
		c2.start();
		c3.start();
	}
	
	public static void testSeqB() {
		Sequence sequence = new SequenceB();
		ThreadLocalClient c1 = new ThreadLocalClient(sequence);
		ThreadLocalClient c2 = new ThreadLocalClient(sequence);
		ThreadLocalClient c3 = new ThreadLocalClient(sequence);
		c1.start();
		c2.start();
		c3.start();
	}
}
