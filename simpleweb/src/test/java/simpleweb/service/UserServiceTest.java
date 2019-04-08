package simpleweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import simpleweb.model.User;

public class UserServiceTest {

	private UserService userService;
	
	public UserServiceTest() {
		this.userService = new UserService();
	}
	
	@Before
	public void init() {
		System.out.println("init");
	}
	
	@Test
	public void getUsersTest() {
		System.out.println("test");
		List<User> users = userService.getUsers(null);
		Assert.assertEquals(3, users.size());
		System.out.println(users.get(0).getId());
		System.out.println(users.get(0).getEmail());
	}
	
	@Test
	public void createUserTest() {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("id", null);
		user.put("username", "user3");
		user.put("password", "password3");
		user.put("name", "用户3");
		user.put("email", "用户3@qq.com");
		Assert.assertTrue(userService.createUser(user));
	}
	
	@Test
	public void updateUserTest() {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("username", "user33");
		user.put("password", "password33");
		user.put("name", "用户33");
		user.put("email", "用户33@qq.com");
		Assert.assertTrue(userService.updateUser(3, user));
	}
	
	@Test
	public void deleteUserTest() {
		Assert.assertTrue(userService.deleteUser(4));
	}
}
