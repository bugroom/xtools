package constxiong.cxproxy.chapter1;

import constxiong.cxproxy.chapter1.service.Service;
import constxiong.cxproxy.chapter1.service.ServiceImpl;

/**
 * 测试类
 * @author ConstXiong
 * @date 2019-05-29 11:01:30
 */
public class Test {

	public static void main(String[] args) {
		Service service = new ServiceImpl();
		service.login("ConstXiong", "123456");
		service.getUserInfo("ConstXiong");
	}
	
}
