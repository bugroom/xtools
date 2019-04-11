package constxiong.interview.proxy.springaop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * 拦截获取异常信息
 * @author ConstXiong
 * @date 2019-04-11 19:28:01
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
		System.out.println("---------- throw exception ----------");
		System.out.println("target class:" + target.getClass().getName());
		System.out.println("method name:" + method.getName());
		System.out.println("exception message:" + e.getMessage());
		System.out.println("---------- ----------");
	}

}
