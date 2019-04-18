package constxiong.interview;

/**
 * 抽象类不一定有抽象方法
 * @author ConstXiong
 * @date 2019-04-18 10:47:30
 */
public abstract class TestAbstractClass {

	public static void notAbstractMethod() {
		System.out.println("I am not a abstract method.");
	}
	
	abstract void say();
}
