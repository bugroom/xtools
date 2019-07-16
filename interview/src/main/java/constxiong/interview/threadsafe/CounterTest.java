package constxiong.interview.threadsafe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CounterTest {
	
	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("spring_safe.xml");

		for (int i = 0; i < 10; i++) {
			new Thread(){
				@Override
				public void run() {
					Counter counter = (Counter)context.getBean("counter");
					for (int j = 0; j < 1000; j++) {
						counter.addAndPrint();
					}
				}
			}.start();
		}
		
	}
	
}
