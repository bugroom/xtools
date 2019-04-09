package simple.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import simple.framework.util.RefectionUtil;

public class BeanHelper {

	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
	
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> cls : beanClassSet) {
			Object instance = RefectionUtil.newInstance(cls);
			BEAN_MAP.put(cls, instance);
		}
	}
	
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls) {
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean by class:" + cls);
		}
		return (T)BEAN_MAP.get(cls);
	}
	
}
