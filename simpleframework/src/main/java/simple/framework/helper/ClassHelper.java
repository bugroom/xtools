package simple.framework.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import simple.framework.annotation.Controller;
import simple.framework.annotation.Service;
import simple.framework.util.ClassUtil;

public class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;
	
	static {
		String basePackage = ConfigHelper.getBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}
	
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> classSet = 
				new HashSet<Class<?>>(getControllerClassSet());
		classSet.addAll(getServiceClassSet());
		return classSet;
	}
	
	public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (superClass.isAssignableFrom(cls)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
	
	public static Set<Class<?>> getClassSetByAnnotation(
			Class<? extends Annotation> annotationClass) {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(annotationClass)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}
}
