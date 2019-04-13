package constxiong.interview.threadlocal;

public class SequenceA implements Sequence {

	private static int number = 0;
	
	public int getNumber() {
		number += 1;
		return number;
	}

}
