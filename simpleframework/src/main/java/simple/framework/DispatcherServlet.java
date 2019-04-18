package simple.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import simple.framework.bean.Data;
import simple.framework.bean.Handler;
import simple.framework.bean.Param;
import simple.framework.bean.View;
import simple.framework.consts.ConfigConstant;
import simple.framework.helper.BeanHelper;
import simple.framework.helper.ConfigHelper;
import simple.framework.helper.ControllerHelper;
import simple.framework.helper.RequestHelper;
import simple.framework.helper.ServletHelper;
import simple.framework.helper.UploadHelper;
import simple.framework.loader.HelpLoader;
import simple.framework.util.JsonUtil;
import simple.framework.util.RefectionUtil;

@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
	
	private static final long serialVersionUID = 7714136327434268585L;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		HelpLoader.init();
		ServletContext servletContext = servletConfig.getServletContext();
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getJspPackage() + "*");
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAssertPackage() + "*");
		
		UploadHelper.init(servletContext);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletHelper.init(req, resp);
		try {
			String requestMethod = req.getMethod().toLowerCase();
			String requestPath = req.getPathInfo();
			
			if (requestPath.equals("/favicon.ico")) {
				return;
			}
			
			Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
			if (handler != null) {
				Class<?> controllerClass = handler.getControllerClass();
				Object controllerBean = BeanHelper.getBean(controllerClass);
				
				Param param;
				if (UploadHelper.isMultipart(req)) {
					param = UploadHelper.createParam(req);
				} else {
					param = RequestHelper.createParam(req);
				}
				
				Object result;
				Method actionMethod = handler.getActionMethod();
				if (param.isEmpty()) {
					result = RefectionUtil.invokeMethod(controllerBean, actionMethod);
				} else {
					result = RefectionUtil.invokeMethod(controllerBean, actionMethod, param);
				}
				
				if (result instanceof View) {
					handleViewResult((View)result, req, resp);
				} else if (result instanceof Data) {
					handleDataResult((Data)result, req, resp);
				}
			}
		} finally {
			ServletHelper.destroy();
		}
	}

	private void handleViewResult(View view, HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		String path = view.getPath();
		if (StringUtils.isNotEmpty(path)) {
			if (path.startsWith("/")) {
				resp.sendRedirect(req.getContextPath() + path);
			} else {
				Map<String, Object> model = view.getModel();
				for (Map.Entry<String, Object> entry : model.entrySet()) {
					req.setAttribute(entry.getKey(), entry.getValue());
				}
				req.getRequestDispatcher(ConfigHelper.getJspPackage() + path).forward(req, resp);
			}
		}
	}

	private void handleDataResult(Data data, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		Object model = data.getModel();
		if (model != null) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding(ConfigConstant.CHARSET_UTF8);
			PrintWriter writer = resp.getWriter();
			writer.write(JsonUtil.toJson(model));
			writer.flush();
			writer.close();
		}
	}
	
	
}

