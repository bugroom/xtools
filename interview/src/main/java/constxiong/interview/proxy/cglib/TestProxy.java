package constxiong.interview.proxy.cglib;

import constxiong.interview.proxy.staticproxy.Hello;
import constxiong.interview.proxy.staticproxy.HelloImpl;

public class TestProxy {

	public static void main(String[] args) {
//		CglibProxy proxy = new CglibProxy();
//		HelloImpl helloProxy = proxy.getProxy(HelloImpl.class);
		
		//改成单例模式后
		Hello helloProxy = CglibProxy.getInstance().getProxy(HelloImpl.class);
		helloProxy.say("constxiong");
	}
	
}
