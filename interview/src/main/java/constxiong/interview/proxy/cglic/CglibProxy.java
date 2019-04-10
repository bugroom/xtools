package constxiong.interview.proxy.cglic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	private static CglibProxy instance = new CglibProxy();
	
	private CglibProxy() {
		
	}
	
	public static CglibProxy getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T)Enhancer.create(cls, this);
	}
	
	public Object intercept(Object obj, Method method,
			Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj, args);
		after();
		return result;
	}

	private void after() {
		System.out.println("before");
	}

	private void before() {
		System.out.println("after");
	}

}
