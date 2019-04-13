package simple.framework.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AspectProxy implements Proxy {

	public static final Logger LOG = LoggerFactory.getLogger(AspectProxy.class);

	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result = null;
		Class<?> cls = proxyChain.getTargetClass();
		Method method = proxyChain.getTargetMethod();
		Object[] params = proxyChain.getMethodParams();
		
		begin();
		try {
			if (intercept(cls, method, params)) {
				before(cls, method, params);
				result = proxyChain.doProxyChain();
				after(cls, method, params, result);
			}
		} catch (Exception e) {
			LOG.error("proxy failed", e);
			error(cls, method, params, e);
			throw e;
		} finally {
			end();
		}
		
		return result;
	}
	
	public void error(Class<?> cls, Method method, Object[] params, Exception e) {
		
	}
	
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
		
	}

	public void after(Class<?> cls, Method method, Object[] params,
			Object result) throws Throwable  {
		
	}

	public void begin() {
		
	}

	public void end() {
		
	}

	public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
		return true;
	}
	
	
}
