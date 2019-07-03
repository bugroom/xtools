package constxiong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsonp servlet
 * @author ConstXiong
 * @date 2019-07-03 09:56:37
 */
@WebServlet("/jsonp")
public class JsonpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder jsonp = new StringBuilder();
		String sid = request.getParameter("sid");
		String function = request.getParameter("callback");
		jsonp.append(function).append("(");
		jsonp.append(getStudent(sid));
		jsonp.append(")");
		response.getWriter().write(jsonp.toString());
	}

	/**
	 * 根据学号获取学生信息
	 * @param sid
	 * @return
	 */
	private String getStudent(String sid) {
		String student = null;
		if ("1".equals(sid)) {
			student = "{'sid':'1', 'name':'ConstXiong'}";
		}
		return student;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
