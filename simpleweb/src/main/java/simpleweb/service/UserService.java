package simpleweb.service;

import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import simpleweb.model.User;
import simpleweb.util.JdbcHelper;

public class UserService {

//	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	public List<User> getUsers(String key) {
		String sql = "select * from user";
		return JdbcHelper.queryEntityList(User.class, sql);
	}

	public User getUser(int id) {
		String sql = "select * from user";
		return JdbcHelper.queryEntity(User.class, sql);
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
