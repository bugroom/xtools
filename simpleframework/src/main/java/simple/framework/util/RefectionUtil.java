package simple.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RefectionUtil {

	private static final Logger LOG = LoggerFactory.getLogger(RefectionUtil.class);
	
	public static Object newInstance(Class<?> cls) {
		Object instance = null;
		try {
			instance = cls.newInstance();
		} catch (Exception e) {
			LOG.error("instance Object failed", e);
			throw new RuntimeException(e);
		}
		return instance;
	}
	
	public static Object invokeMethod(Object obj, Method method, Object... args) {
		Object result = null;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (Exception e) {
			LOG.error("method invoke failed", e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void setField(Object obj, Field field, Object value) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			LOG.error("set field failed", e);
			throw new RuntimeException(e);
		}
	}
	
}
