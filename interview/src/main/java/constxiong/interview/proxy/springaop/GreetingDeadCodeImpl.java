package constxiong.interview.proxy.springaop;

public class GreetingDeadCodeImpl implements Greeting {

	public void sayHello(String name) {
		before();
		System.out.println("Hello! " + name);
		after();
	}

	private void before() {
		System.out.println("before");
	}
	
	private void after() {
		System.out.println("after");
	}

}
