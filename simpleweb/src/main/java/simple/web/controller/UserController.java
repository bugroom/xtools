package simple.web.controller;

import simple.framework.annotation.Action;
import simple.framework.annotation.Autowired;
import simple.framework.annotation.Controller;
import simple.framework.bean.Data;
import simple.framework.bean.Param;
import simple.framework.bean.View;
import simple.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Action("get:/users")
	public Data getUsers(Param param) {
		return new Data(userService.getUsers(null));
	}
	
	@Action("get:/toUsers")
	public View toUsers(Param param) {
		View view = new View("user.jsp");
		view.addModel("users", userService.getUsers(null));
		return view;
	}
	
}
