package constxiong.interview;

/**
 * 测试继承多接口，实现相同方法
 * 从 JDK1.8 开始，接口中允许有静态方法和方法默认实现
 * 当检测到实现类中实现的多个接口中有相同的默认已实现的方法，编译报错
 * @author ConstXiong
 * @date 2019-11-21 10:58:33
 */
public class TestImplementsMulitInterface implements InterfaceA, InterfaceB {

	public void hello() {
		System.out.println("hello");
	}

}

interface InterfaceA {
	
	void hello();

	static void sayHello() {
		System.out.println("InterfaceA static: say hello");
	}

	default void sayBye() {
		System.out.println("InterfaceA default: say bye");
	}
}

interface InterfaceB {
	
	void hello();
	
	static void sayHello() {
		System.out.println("InterfaceB static: say hello");
	}

//	default void sayBye() {
//		System.out.println("InterfaceB default: say bye");
//	}
}
