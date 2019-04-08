package simpleweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcHelper {

	private static final Logger LOG = LoggerFactory.getLogger(JdbcHelper.class);
	
	private static final String DRIVER;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	private static final QueryRunner QUERY_RUNNER = new QueryRunner();
	
	static {
		Properties properties = PropertiesUtil.loadProperties("jdbc.properties");
		DRIVER = properties.getProperty("jdbc_driver");
		URL = properties.getProperty("jdbc_url");
		USERNAME = properties.getProperty("jdbc_username");
		PASSWORD = properties.getProperty("jdbc_password");
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			LOG.error(DRIVER + " jdbc driver not found", e);
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			LOG.error("get database connection failed", e);
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.error("close database connection failed", e);
			}
		}
	}
	
	public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
		List<T> entityList = null;
		try {
			entityList = QUERY_RUNNER.query(sql, new BeanListHandler<T>(entityClass), params);
		} catch (SQLException e) {
			LOG.error("query entity list failed", e);
			throw new RuntimeException(e);
		} finally {
			
		}
		return entityList;
	}
}
