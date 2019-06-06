package constxiong.cxproxy.chapter6.proxy;

import java.util.Random;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 使用spring aop 完成环绕代理
 * @author ConstXiong
 * @date 2019-06-06 14:49:36
 */
public class ServiceAroundAdvice implements MethodInterceptor {

	//获取用户信息的方法名
	private static final String METHOD_GET_USERINFO = "getUserInfo";
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		long start = System.currentTimeMillis();//计时开始
		if (METHOD_GET_USERINFO.equals(invocation.getMethod().getName())) {//获取用户信息方法
			if (checkIsLogined()) {//校验是否登录
				result = invocation.proceed();//目标类的方法调用，与结果获取
			}
		} else {//非获取用户信息方法，不校验是否登录
			result = invocation.proceed();//目标类的方法调用，与结果获取
		}
		long end = System.currentTimeMillis();//计时结束
		System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
		return result;
	}

	/**
	 * 模拟  当前用户是否登录
	 */
	private boolean checkIsLogined() {
		Random r = new Random();
		int i = r.nextInt(10);
		if (i % 2 == 0) {
			System.out.println("已登录");
			return true;
		}
		System.out.println("未登录");
		return false;
	}
	
}
