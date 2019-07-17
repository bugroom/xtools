package constxiong.interview.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AssembleTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_assemble.xml");
		Person person = (Person)context.getBean("person");
		person.fish();
	}
	
}
