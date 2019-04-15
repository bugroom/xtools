package constxiong.interview;

import java.util.Random;

/**
 * final 和 static 变量的初始化与可改变性问题
 * @author ConstXiong
 * @date 2019-04-15 09:35:01
 */
public class TestStaticFinal {

	public static void main(String[] args) {
		StaticFinal sf1 = new StaticFinal();
		StaticFinal sf2 = new StaticFinal();
		
		System.out.println(sf1.fValue == sf2.fValue);//打印false
		System.out.println(sf1.sValue == sf2.sValue);//打印true
	}
}

class StaticFinal {
	
	final int fValue = new Random().nextInt();
	static int sValue = new Random().nextInt();
	
}
