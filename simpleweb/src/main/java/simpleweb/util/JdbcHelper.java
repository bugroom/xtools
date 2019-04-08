package simpleweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcHelper {

	private static final Logger LOG = LoggerFactory.getLogger(JdbcHelper.class);
	
	private static final String DRIVER;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	private static final QueryRunner QUERY_RUNNER = new QueryRunner();
	
	private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();
	
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
		Connection conn = CONNECTION_HOLDER.get();
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				LOG.error("get database connection failed", e);
				throw new RuntimeException(e);
			} finally {
				CONNECTION_HOLDER.set(conn);
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		Connection conn = CONNECTION_HOLDER.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.error("close database connection failed", e);
				throw new RuntimeException(e);
			} finally {
				CONNECTION_HOLDER.remove();
			}
		}
	}
	
	public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
		List<T> entityList = null;
		try {
			Connection conn = getConnection();
			entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
		} catch (SQLException e) {
			LOG.error("query entity list failed", e);
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
		return entityList;
	}
	
	public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
		T entity = null;
		try {
			Connection conn = getConnection();
			entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
		} catch (SQLException e) {
			LOG.error("query entity failed", e);
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
		return entity;
	}
	
	public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
		List<Map<String, Object>> result = null;
		try {
			Connection conn = getConnection();
			result = QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			LOG.error("query map failed", e);
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
		return result;
	}
	
	public static int executeUpdate(String sql, Object... params) {
		int rows = 0;
		try {
			Connection conn = getConnection();
			rows = QUERY_RUNNER.update(conn, sql, params);
		} catch (SQLException e) {
			LOG.error("execute update failed", e);
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
		return rows;
	}
}