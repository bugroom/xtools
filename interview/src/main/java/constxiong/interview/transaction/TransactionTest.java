package constxiong.interview.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext("spring_transaction.xml");
	
	public static void main(String[] args) throws Exception {
		testManualTransaction();     //测试手动控制事务
		testUseTransactionProxy();   //测试使用 spring TransactionProxyFactoryBean
		testAnnotationTransaction(); //测试注解控制事务
		testAspectjTransaction();    //测试切面控制事务
	}
	
	private static void testUseTransactionProxy() {
		final UserDao userDao = (UserDao)context.getBean("userProxy");
		printUsers(userDao);//打印用户
		userDao.deleteUser(1);//删除 id=1 用户
	}
 
	private static void testManualTransaction() throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_transaction.xml");
		DataSource ds = (DataSource)context.getBean("datasource");
		Connection conn = ds.getConnection();
		try {
			initTable(conn);//初始化表
			conn.setAutoCommit(false);//设置不自动提交事务
			queryUsers(conn);//查询打印用户表
			deleteUser(conn);//删除 id=1 用户
			conn.rollback();//回滚
			queryUsers(conn);//查询打印用户表
		} finally {
			conn.close();
		}
	}
 
	private static void initTable(Connection conn) throws SQLException {
		conn.createStatement().execute("drop table if exists user");
		conn.createStatement().execute("create table user(id int, username varchar(60)) ENGINE=InnoDB DEFAULT CHARSET=utf8 ");//是否支持事务与数据库引擎有关，此处删除 ENGINE=InnoDB DEFAULT CHARSET=utf8 可能不支持事务
		conn.createStatement().execute("insert into user values(1, 'user1')");
		conn.createStatement().execute("insert into user values(2, 'user2')");
	}
 
	private static void deleteUser(Connection conn) throws SQLException {
		conn.createStatement().execute("delete from user where id = 1");
	}
 
	private static void queryUsers(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		st.execute("select * from user");
		ResultSet rs = st.getResultSet();
		while (rs.next()) {
			System.out.print(rs.getString("id"));
			System.out.print(" ");
			System.out.print(rs.getString("username"));
			System.out.println();
		}
	}
	
	private static void testAspectjTransaction() {
		UserDao userDao = (UserDao)context.getBean("userDao");
		printUsers(userDao);
		userDao.deleteUser(1);
	}
	
	private static void testAnnotationTransaction() {
		UserDao userDao = (UserDao)context.getBean("userDao");
		printUsers(userDao);
		userDao.deleteUser(1);
	}


	private static void printUsers(UserDao userDao) {
		for (Map<String, Object> user : userDao.getUsers()) {
			System.out.println(user);
		}
	}

}
