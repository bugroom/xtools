package constxiong.interview.proxy.springaop.programmatic;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("after");
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("before");
	}

}
