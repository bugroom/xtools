package simpleweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleweb.model.User;
import simpleweb.util.JdbcHelper;

public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	public List<User> getUsers(String key) {
		List<User> users = null;
		Connection conn = null;
		try {
			conn = JdbcHelper.getConnection();
			String sql = "select * from user";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTel(rs.getString("tel"));
				users.add(user);
			}
		} catch (SQLException e) {
			LOG.error("execute sql failed", e);
		} finally {
			JdbcHelper.closeConnection(conn);
		}
		return users;
	}

	public User getUser(int id) {
		return null;
	}
	
	public int createUser(Map<String, Object> user) {
		return 0;
	}
	
	public int updateUser(int id, Map<String, Object> user) {
		return 0;
	}
	
	public int deleteUser(int id) {
		return 0;
	}
	
}
