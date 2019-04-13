package constxiong.interview.aop;

import org.springframework.stereotype.Service;

//import constxiong.interview.aspectj.annotation.Tag;

@Service("aopGreetingImpl")
public class GreetingImpl implements Greeting {

//	@Tag
	public void sayHello(String name) {
		System.out.println("Hello! " + name);
	}

	public void googMorning(String name) {
		System.out.println("GoogMorning! " + name);
	}
	
	public void googNight(String name) {
		System.out.println("GoogNight! " + name);
	}
}
