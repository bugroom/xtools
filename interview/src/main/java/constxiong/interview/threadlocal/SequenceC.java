package constxiong.interview.threadlocal;

public class SequenceC implements Sequence {

	private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};
	
	public int getNumber() {
		numberContainer.set(numberContainer.get() + 1);
		return numberContainer.get();
	}

}
