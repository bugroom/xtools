package constxiong.interview.proxy.springaop.proxyagain;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
	
	public static CGLibDynamicProxy getInstance() {
		return instance;
	}
	
	private CGLibDynamicProxy() {
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<?> clazz) {
		return (T) Enhancer.create(clazz, this);
	}
	
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj, args);
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
