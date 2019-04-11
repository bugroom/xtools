package constxiong.interview.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import constxiong.interview.proxy.staticproxy.Hello;
import constxiong.interview.proxy.staticproxy.HelloImpl;

public class TestProxy {

	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		DynamicProxy dynamicProxy = new DynamicProxy(hello);
		Hello helloProxy = (Hello) Proxy.newProxyInstance(
				hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
		helloProxy.say("constxiong");
	}
}
