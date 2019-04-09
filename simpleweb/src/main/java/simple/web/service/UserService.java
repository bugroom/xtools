package simple.web.service;

import java.util.List;
import java.util.Map;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;import simple.framework.util.JdbcHelper;


import simple.framework.helper.JdbcHelper;
import simple.web.model.User;

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
	
	public boolean createUser(Map<String, Object> user) {
		return JdbcHelper.insertEntity(User.class, user);
	}
	
	public boolean updateUser(int id, Map<String, Object> user) {
		return JdbcHelper.updateEntity(User.class, id, user);
	}
	
	public boolean deleteUser(int id) {
		return JdbcHelper.deleteEntity(User.class, id);
	}
	
}
