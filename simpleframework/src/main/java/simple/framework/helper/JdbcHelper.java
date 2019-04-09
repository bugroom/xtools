package simple.framework.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.framework.util.PropertiesUtil;

public class JdbcHelper {

	private static final Logger LOG = LoggerFactory.getLogger(JdbcHelper.class);
	
	private static final QueryRunner QUERY_RUNNER;
	private static final ThreadLocal<Connection> CONNECTION_HOLDER;
	private static final BasicDataSource DATA_SOURCE;
	
	static {
		CONNECTION_HOLDER = new ThreadLocal<Connection>();
		QUERY_RUNNER = new QueryRunner();
		
		Properties properties = PropertiesUtil.loadProperties("jdbc.properties");
		String driver = properties.getProperty("jdbc_driver");
		String url = properties.getProperty("jdbc_url");
		String username = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");
		
		DATA_SOURCE = new BasicDataSource();
		DATA_SOURCE.setDriverClassName(driver);
		DATA_SOURCE.setUrl(url);
		DATA_SOURCE.setUsername(username);
		DATA_SOURCE.setPassword(password);
	}
	
	public static Connection getConnection() {
		Connection conn = CONNECTION_HOLDER.get();
		if (conn == null) {
			try {
				conn = DATA_SOURCE.getConnection();
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
	
	public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fields) {
		if (MapUtils.isNotEmpty(fields)) {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ").append(getTableName(entityClass)).append(" (");
			List<String> keyList = new ArrayList<String>();
			List<Object> valueList = new ArrayList<Object>();
			List<String> placeholders = new ArrayList<String>();
			for (Map.Entry<String, Object> entity : fields.entrySet()) {
				keyList.add(entity.getKey());
				valueList.add(entity.getValue());
				placeholders.add("?");
			}
			sql.append(StringUtils.join(keyList, ",")).append(") values (").append(StringUtils.join(placeholders, ",")).append(")");
			return executeUpdate(sql.toString(), valueList.toArray()) == 1;
		}
		return false;
	}
	
	public static <T> boolean updateEntity(Class<T> entityClass, int id, Map<String, Object> fields) {
		if (MapUtils.isNotEmpty(fields)) { 
			StringBuilder sql = new StringBuilder();
			sql.append("update ").append(getTableName(entityClass)).append(" set ");
			List<Object> valueList = new ArrayList<Object>();
			List<String> placeholders = new ArrayList<String>();
			for (Map.Entry<String, Object> entity : fields.entrySet()) {
				placeholders.add(entity.getKey() + " = ?");
				valueList.add(entity.getValue());
			}
			sql.append(StringUtils.join(placeholders, ",")).append(" where id = ?");
			valueList.add(id);
			return executeUpdate(sql.toString(), valueList.toArray()) == 1;
		}
		return false;
	}
	
	public static <T> boolean deleteEntity(Class<T> entityClass, int id) {
		String sql = "delete from " + getTableName(entityClass) + " where id = ?";
		return executeUpdate(sql, id) == 1;
	}
	
	public static String getTableName(Class<?> entityClass) {
		return entityClass.getSimpleName();
	}
	
	public static void executeSqlFile(String filePath) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String sql;
		try {
			while ((sql = br.readLine()) != null) {
				executeUpdate(sql);
			}
		} catch (IOException e) {
			LOG.error("executeSqlFile failed", e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				LOG.error("close io failed", e);
			}
		}
	}
}
