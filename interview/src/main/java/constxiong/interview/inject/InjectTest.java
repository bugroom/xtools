package constxiong.interview.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_inject.xml");
		Person person = (Person)context.getBean("person");
		person.eat();
	}
}
