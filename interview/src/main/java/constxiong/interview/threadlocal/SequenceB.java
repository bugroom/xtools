package constxiong.interview.threadlocal;

public class SequenceB implements Sequence {

	private static ThreadLocal<Integer> integerContainer = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};
	
	public int getNumber() {
		integerContainer.set(integerContainer.get() + 1);
		return integerContainer.get();
	}

}
