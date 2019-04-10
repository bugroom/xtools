package constxiong.interview.proxy.staticproxy;

public class HelloProxy implements Hello {

	private Hello hello;
	
	public HelloProxy() {
		hello = new HelloImpl();
	}
	
	public void say(String who) {
		before();
		hello.say(who);
		after();
	}
	
	private void before() {
		System.out.println("before");
	}
	
	private void after() {
		System.out.println("after");
	}

}
