package constxiong.interview;

/**
 * 测试 instanceof
 * @author ConstXiong
 * @date 2019-10-23 11:05:21
 */
public class TestInstanceof {

	public static void main(String[] args) {
		A a = new A();
		AA aa = new AA();
		AAA aaa = new AAA();
		System.out.println(a instanceof A);//true
		System.out.println(a instanceof AA);//false
		System.out.println(aa instanceof AAA);//false
		System.out.println(aaa instanceof A);//true
	}
	
}

class A {
}

class AA extends A {
}

class AAA extends AA {
}