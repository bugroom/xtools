package simpleweb.service;

import java.util.List;

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
		Assert.assertEquals(2, users.size());
		System.out.println(users.get(0).getId());
		System.out.println(users.get(0).getEmail());
	}
}
