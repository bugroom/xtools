package constxiong.interview.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constxiong.interview.aop.GreetingImpl;
import constxiong.interview.proxy.springaop.Apology;

public class Test {
	
	private static final String WHO = "constxiong";
	
	public static void main(String[] args) {
//		aspectj();
//		aspectjDeclareParents();
		aspectUseXmlConfig();
	}
	
	public static void aspectj() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aspect.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("aopGreetingImpl");
		greeting.sayHello(WHO);
	}
	
	public static void aspectjDeclareParents() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aspect.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("aopGreetingImpl");
		greeting.sayHello(WHO);
		
		Apology apology = (Apology)greeting;
		apology.saySorry(WHO);
	}
	
	public static void aspectUseXmlConfig() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aspect_declare_parent.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("greetingImpl");
		greeting.sayHello(WHO);
	}
}
