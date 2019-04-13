package simple.framework.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.framework.annotation.Aspect;
import simple.framework.annotation.Controller;

@Aspect(value = Controller.class)
public class ControllerAspect extends AspectProxy {
	
	private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);
	
	private long begin;

	@Override
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
		LOG.debug("-------- begin --------");
		LOG.debug("class:{}", new Object[]{cls.getName()});
		LOG.debug("method:{}", new Object[]{method.getName()});
		begin = System.currentTimeMillis();
	}
	
	@Override
	public void after(Class<?> cls, Method method, Object[] params,
			Object result) throws Throwable {
		LOG.debug("cost millis : {}", new Object[]{System.currentTimeMillis() - begin});
		LOG.debug("-------- end --------");
	}

}
