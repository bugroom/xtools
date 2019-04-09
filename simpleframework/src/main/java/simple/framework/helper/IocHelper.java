package simple.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import simple.framework.annotation.Autowired;
import simple.framework.util.RefectionUtil;

public class IocHelper {

	static {
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (MapUtils.isNotEmpty(beanMap)) {
			for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtils.isNotEmpty(beanFields)) {
					for (Field beanField : beanFields) {
						if (beanField.isAnnotationPresent(Autowired.class)) {
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if (beanFieldInstance != null) {
								RefectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
				
			}
		}
	}
	
}
