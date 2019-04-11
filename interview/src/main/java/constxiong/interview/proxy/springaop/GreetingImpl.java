package constxiong.interview.proxy.springaop;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

	public void sayHello(String name) {
		System.out.println("Hello! " + name);
//		throw new RuntimeException("error");
	}

}
