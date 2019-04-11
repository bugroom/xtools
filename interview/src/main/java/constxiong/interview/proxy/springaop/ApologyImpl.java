package constxiong.interview.proxy.springaop;

public class ApologyImpl implements Apology {

	public void saySorry(String name) {
		System.out.println("So... " + name);
	}

}
