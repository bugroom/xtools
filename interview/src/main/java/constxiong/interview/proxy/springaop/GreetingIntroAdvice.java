package constxiong.interview.proxy.springaop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;

public class GreetingIntroAdvice extends DelegatePerTargetObjectIntroductionInterceptor
	implements Apology {

	public GreetingIntroAdvice(Class<?> defaultImplType, Class<?> interfaceType) {
		super(defaultImplType, interfaceType);
	}

	private static final long serialVersionUID = -8928078133866166702L;

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		return super.invoke(mi);
	}

	public void saySorry(String name) {
		System.out.println("Sorry! " + name);
	}

}
