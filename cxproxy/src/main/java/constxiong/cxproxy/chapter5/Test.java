package constxiong.cxproxy.chapter5;

import constxiong.cxproxy.chapter5.proxy.CglibProxy;
import constxiong.cxproxy.chapter5.service.Service;
import constxiong.cxproxy.chapter5.service.ServiceImpl;

/**
 * 测试类
 * @author ConstXiong
 * @date 2019-06-04 16:16:30
 */
public class Test {

	public static void main(String[] args) {
		Service service = CglibProxy.getInstance().getProxy(ServiceImpl.class);
		service.login("ConstXiong", "123456");
		service.getUserInfo("ConstXiong");
	}
	
}
