package simple.framework.loader;

import simple.framework.helper.AopHelper;
import simple.framework.helper.BeanHelper;
import simple.framework.helper.ClassHelper;
import simple.framework.helper.ConfigHelper;
import simple.framework.helper.ControllerHelper;
import simple.framework.helper.IocHelper;
import simple.framework.helper.JdbcHelper;
import simple.framework.util.ClassUtil;

public final class HelpLoader {

	public static void init() {
		Class<?>[] classList = {
				ConfigHelper.class,
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class,
				JdbcHelper.class
				};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName(), true);
		}
	}
	
}
