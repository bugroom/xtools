package constxiong.interview.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * org.springframework.aop.support.RegexpMethodPointcutAdvisor         正则
 * org.springframework.aop.support.DefaultPointcutAdvisor              默认
 * org.springframework.aop.support.NameMatchMethodPointcutAdvisor      方法名称
 * org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor  匹配静态方法
 * @author ConstXiong
 * @date 2019-04-12 15:54:26
 */
public class Test {

	public static final String WHO = "constxiong";
	
	public static void main(String[] args) {
//		pointcut();
//		beanScan();
		pointcutScan();
	}
	
	public static void pointcut() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("greetingProxy");
		greeting.sayHello(WHO);
	}

	/**
	 * 扫描bean名称
	 */
	public static void beanScan() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop_scan.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("aopGreetingImpl");
		greeting.sayHello(WHO);
	}
	
	/**
	 * 扫描切面
	 */
	public static void pointcutScan() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop_scan_advisor.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("aopGreetingImpl");
		greeting.sayHello(WHO);
	}
	
	//扩展DefaultPointcutAdvisor类，自定义一个切面
	
}
