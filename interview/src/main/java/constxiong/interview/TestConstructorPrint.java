package constxiong.interview;

/**
 * 测试父类、子类构造函数打印
 * 
 * @author ConstXiong
 * @date 2019-11-01 09:30:26
 */
public class TestConstructorPrint {

	public static void main(String[] args) {
		Parent parent = new Child();
		parent = new Child();
	}

}

class Parent {
	static {
		System.out.print("1");
	}

	public Parent() {
		System.out.print("2");
	}
}

class Child extends Parent {
	static {
		System.out.print("3");
	}

	public Child() {
		System.out.print("4");
	}
}
