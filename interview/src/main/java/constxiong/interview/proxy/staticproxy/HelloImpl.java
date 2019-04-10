package constxiong.interview.proxy.staticproxy;

public class HelloImpl implements Hello {

	//如果需要在say前后加一些方法，需要使用代理，而非直接在say方法代码块前后直接加方法
	public void say(String who) {
		System.out.println("hello " + who);
	}

}
