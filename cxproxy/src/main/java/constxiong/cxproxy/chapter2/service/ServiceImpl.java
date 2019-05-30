package constxiong.cxproxy.chapter2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 服务接口实现
 * @author ConstXiong
 * @date 2019-05-29 11:02:15
 */
public class ServiceImpl implements Service {

	@Override
	public boolean login(String username, String password) {
		long start = System.currentTimeMillis();//计时开始
		
		simulateDaOperation(100);
		System.out.println("用户名：" + username + ", 密码：" + password + "  登录成功");
		
		long end = System.currentTimeMillis();//计时结束
		System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
		
		return true;
	}

	@Override
	public Map<String, Object> getUserInfo(String username) {
		long start = System.currentTimeMillis();//计时开始
		
		Map<String, Object> userInfo = null;
		
		//校验是否登录
		if (checkIsLogined()) {
			userInfo = new HashMap<String, Object>();
			simulateDaOperation(150);
			userInfo.put("username", username);
			userInfo.put("sex", "男");
			userInfo.put("age", 18);
			System.out.println("用户名：" + username + ", 获取用户信息：" + userInfo);
		}
		
		long end = System.currentTimeMillis();//计时结束
		System.out.println("耗时：" + (end - start) + "毫秒");//打印耗时
		
		return userInfo;
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

	/**
	 * 模拟数据库操作，休眠
	 * @param millis 毫秒数
	 */
	private void simulateDaOperation(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
