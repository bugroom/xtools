package constxiong.cxproxy.chapter4;

import constxiong.cxproxy.chapter4.proxy.JdkDynamicProxy;
import constxiong.cxproxy.chapter4.service.Service;
import constxiong.cxproxy.chapter4.service.ServiceImpl;

/**
 * 测试类
 * @author ConstXiong
 * @date 2019-06-02 22:16:30
 */
public class Test {

	public static void main(String[] args) {
		JdkDynamicProxy proxy = new JdkDynamicProxy(new ServiceImpl());
		Service service = proxy.getProxy();
		service.login("ConstXiong", "123456");
		service.getUserInfo("ConstXiong");
	}
	
}
