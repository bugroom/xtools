package constxiong.cxproxy.chapter6;

import org.springframework.aop.framework.ProxyFactory;

import constxiong.cxproxy.chapter6.proxy.ServiceAroundAdvice;
import constxiong.cxproxy.chapter6.service.Service;
import constxiong.cxproxy.chapter6.service.ServiceImpl;

/**
 * 测试类
 * @author ConstXiong
 * @date 2019-06-06 14:08:01
 */
public class Test {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new ServiceImpl());
		proxyFactory.addAdvice(new ServiceAroundAdvice());
		Service service = (Service) proxyFactory.getProxy();
		service.login("ConstXiong", "123456");
		service.getUserInfo("ConstXiong");
	}
	
}
