package constxiong.interview.proxy.dynamicproxy2;

import constxiong.interview.proxy.staticproxy.Hello;
import constxiong.interview.proxy.staticproxy.HelloImpl;

public class TestProxy {

	public static void main(String[] args) {
		DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
		Hello helloProxy = dynamicProxy.getProxy();
		helloProxy.say("constxiong");
	}
	
}
