package constxiong.cxproxy.chapter3;

import constxiong.cxproxy.chapter3.proxy.StaticServiceProxy;
import constxiong.cxproxy.chapter3.service.Service;

/**
 * 测试类
 * @author ConstXiong
 * @date 2019-06-02 00:16:30
 */
public class Test {

	public static void main(String[] args) {
		Service service = new StaticServiceProxy();
		service.login("ConstXiong", "123456");
		service.getUserInfo("ConstXiong");
	}
	
}
