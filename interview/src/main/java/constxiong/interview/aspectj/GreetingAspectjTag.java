package constxiong.interview.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspectjTag {


	//@Around @Before @After @AfterThrowing @DeclareParents-引入增强
	
	@Around("@annotation(constxiong.interview.aspectj.annotation.Tag)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		before();
		Object result = pjp.proceed();
		after();
		return result;
	}

	private void before() {
		System.out.println("before");
	}

	private void after() {
		System.out.println("after");
	}
	
}
