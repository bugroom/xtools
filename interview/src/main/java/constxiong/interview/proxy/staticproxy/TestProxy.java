package constxiong.interview.proxy.staticproxy;

public class TestProxy {

	public static void main(String[] args) {
		Hello hello = new HelloProxy();
		hello.say("constxiong");
	}
}
