package simple.framework.helper;

import java.util.Properties;

import simple.framework.consts.ConfigConstant;
import simple.framework.util.PropertiesUtil;

public class ConfigHelper {

	private static final Properties CONFIG_PROPERTIES = 
			PropertiesUtil.loadProperties(ConfigConstant.CONFIG_FILE);
	
	private static final Properties JDBC_PROPERTIES = 
			PropertiesUtil.loadProperties(ConfigConstant.CONFIG_JDBC_FILE);
	
	
	public static String getJdbcDriver() {
		return PropertiesUtil.getString(JDBC_PROPERTIES, ConfigConstant.JDBC_DRIVER);
	}
	
	public static String getJdbcUrl() {
		return PropertiesUtil.getString(JDBC_PROPERTIES, ConfigConstant.JDBC_URL);
	}
	
	public static String getJdbcUsername() {
		return PropertiesUtil.getString(JDBC_PROPERTIES, ConfigConstant.JDBC_USERNAME);
	}
	
	public static String getJdbcPassword() {
		return PropertiesUtil.getString(JDBC_PROPERTIES, ConfigConstant.JDBC_PASSWORD);
	}
	
	public static String getBasePackage() {
		return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.BASE_PACKAGE);
	}
	
	public static String getJspPackage() {
		return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JSP_PATH);
	}
	
	public static String getAssertPackage() {
		return PropertiesUtil.getString(CONFIG_PROPERTIES, ConfigConstant.ASSERT_PATH);
	}
	
}
