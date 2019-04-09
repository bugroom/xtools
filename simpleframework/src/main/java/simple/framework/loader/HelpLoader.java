package simple.framework.loader;

import simple.framework.helper.BeanHelper;
import simple.framework.helper.ClassHelper;
import simple.framework.helper.ControllerHelper;
import simple.framework.helper.IocHelper;
import simple.framework.util.ClassUtil;

public final class HelpLoader {

	public static void init() {
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				IocHelper.class,
				IocHelper.class,
				ControllerHelper.class
				};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName(), false);
		}
	}
	
}
