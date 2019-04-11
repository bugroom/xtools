package constxiong.interview.proxy.springaop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constxiong.interview.proxy.springaop.programmatic.GreetingAfterAdvice;
import constxiong.interview.proxy.springaop.programmatic.GreetingAroundAdvice;
import constxiong.interview.proxy.springaop.programmatic.GreetingBeforeAdvice;
import constxiong.interview.proxy.springaop.programmatic.GreetingBeforeAfterAdvice;
import constxiong.interview.proxy.springaop.proxyagain.CGLibDynamicProxy;
import constxiong.interview.proxy.springaop.proxyagain.JDKDynamicProxy;
import constxiong.interview.proxy.springaop.proxyagain.StaticProxy;

public class Test {
	
	public static final String WHO = "constxiong";

	public static void main(String[] args) {
//		deadCodeAddBeforeAfter();
//		staticProxy();
//		jdkDynamicProxy();
//		cglibDynamicProxy();
//		springBeforeAfterAdvice();
//		springBeforeAfterInOneAdvice();
//		aopAllianceAround();
//		springXmlConfigProxy();
		springIntroProxy();
		
	}
	
	public static void deadCodeAddBeforeAfter() {
		Greeting greeting = new GreetingDeadCodeImpl();
		greeting.sayHello(WHO);
	}
	
	public static void staticProxy() {
		StaticProxy proxy = new StaticProxy(new GreetingImpl());
		proxy.sayHello(WHO);
	}
	
	public static void jdkDynamicProxy() {
		Greeting proxy = new JDKDynamicProxy(new GreetingImpl()).getProxy();
		proxy.sayHello(WHO);
	}
	
	public static void cglibDynamicProxy() {
		Greeting proxy = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
		proxy.sayHello(WHO);
	}
	
	public static void springBeforeAfterAdvice() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingBeforeAdvice());
		proxyFactory.addAdvice(new GreetingAfterAdvice());
		Greeting greeting = (Greeting) proxyFactory.getProxy();
		greeting.sayHello(WHO);
	}
	
	public static void springBeforeAfterInOneAdvice() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingBeforeAfterAdvice());
		Greeting greeting = (Greeting) proxyFactory.getProxy();
		greeting.sayHello(WHO);
	}

	//AOP联盟环绕切面
	public static void aopAllianceAround() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingAroundAdvice());
		Greeting greeting = (Greeting) proxyFactory.getProxy();
		greeting.sayHello(WHO);
	}
	
	public static void springXmlConfigProxy() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Greeting greeting = (Greeting) context.getBean("greetingProxy");
		greeting.sayHello(WHO);
	}
	
	public static void springIntroProxy() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_intro.xml");
		GreetingImpl greeting = (GreetingImpl)context.getBean("greetingProxy");
		greeting.sayHello(WHO);
	}
	
}
