//package simple.web.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/hello")
//public class HelloServlet extends HttpServlet{
//
//	private static final long serialVersionUID = 655721307586121359L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		req.setAttribute("currentMillis", System.currentTimeMillis());
//		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
//	}
//	
//
//}
