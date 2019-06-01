package constxiong.cxproxy.chapter3.proxy;

import java.util.Map;

import java.util.Random;

import constxiong.cxproxy.chapter3.service.Service;
import constxiong.cxproxy.chapter3.service.ServiceImpl;

/**
 * Service 接口的静态代理类
 * @author ConstXiong
 * @date 2019-06-02 00:10:02
 */
public class StaticServiceProxy implements Service {

	//持有Serrvice接口的实现类
	private Service service;
	
	public StaticServiceProxy() {
		service = new ServiceImpl(); 
	}
	
	@Override
	public boolean login(String username, String password) {
		long start = System.currentTimeMillis();//计时开始
		
		//调用 ServiceImpl 的登录方法
		boolean result = service.login(username, password);
		
		long end = System.currentTimeMillis();//计时结束
		System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
		
		return result;
	}

	@Override
	public Map<String, Object> getUserInfo(String username) {
		long start = System.currentTimeMillis();//计时开始
		
		Map<String, Object> result = null;
		if (checkIsLogined()) {//校验登录
			result = service.getUserInfo(username);//调用 ServiceImpl 的获取用户信息方法 
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
