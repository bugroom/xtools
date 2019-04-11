package constxiong.interview.proxy.springaop.proxyagain;

import constxiong.interview.proxy.springaop.Greeting;

public class StaticProxy implements Greeting{
	
	private Greeting greeting;
	
	public StaticProxy(Greeting greeting) {
		this.greeting = greeting;
	}
	
	public void sayHello(String name) {
		before();
		greeting.sayHello(name);
		after();
	}

	private void before() {
		System.out.println("before");
	}
	
	private void after() {
		System.out.println("after");
	}

}
