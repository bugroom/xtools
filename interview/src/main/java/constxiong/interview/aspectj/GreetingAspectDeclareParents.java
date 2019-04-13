package constxiong.interview.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import constxiong.interview.proxy.springaop.Apology;

@Aspect
@Component
public class GreetingAspectDeclareParents {

	@DeclareParents(value="constxiong.interview.aop.GreetingImpl",
			defaultImpl=constxiong.interview.proxy.springaop.ApologyImpl.class)
	private Apology apology;
}
