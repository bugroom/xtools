package simpleweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simpleweb.model.User;
import simpleweb.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = -3110119739902035076L;

	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<User> users = userService.getUsers(null);
		req.setAttribute("users", users);
		req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
	}

}
