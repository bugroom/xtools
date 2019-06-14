package constxiong.interview;

/**
 * 测试 Class 类相关
 * @author ConstXiong
 * @date 2019-06-14 10:13:05
 */
public class TestClass {
	
	private int i = 0;
	public int j = 1;

	private void t() {
		System.out.println("调用 TestClass 对象的 t() 方法");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		testGetClass();
		testClassMethod();
	}
	
	/**
	 * 测试获取 Class 对象,获取 Class 名称
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static void testGetClass() throws ClassNotFoundException {
		TestClass t = new TestClass();
		Class class1 = t.getClass();
		System.out.println(class1.getName());
		
		Class class2 = TestClass.class;
		System.out.println(class2.getName());
		
		Class class3 = Class.forName("constxiong.interview.TestClass");
		System.out.println(class3.getName());
		
		//一个 jvm 中一种 Class 只会被实例化一次，对上面的 Class 实例进行判断发现都是相等的
		System.out.println(class1 == class2);
		System.out.println(class1 == class3);
	}
	
	/**
	 * 测试 Class 对象的方法
	 */
	public static void testClassMethod() {
		Class<TestClass> clazz = TestClass.class;
		System.out.println("clazz.getName() --> " + clazz.getName());//获取类全名(包含路径)
		System.out.println();
		System.out.println("clazz.getSimpleName() --> " + clazz.getSimpleName());//获取类简称
		System.out.println();
		System.out.println("clazz.getSuperclass() --> " + clazz.getSuperclass());//获取父类
		System.out.println();
		System.out.println("clazz.isInterface() --> " + clazz.isInterface());//判断是否为接口
		System.out.println();
		System.out.println("clazz.getFields() --> " + join(clazz.getFields(), "\r\n"));//获取 public 字段,包含父类 public 字段
		System.out.println();
		System.out.println("clazz.getDeclaredFields() --> " + join(clazz.getDeclaredFields(), "\r\n"));//获取所有字段
		System.out.println();
		System.out.println("clazz.getMethods() --> " + join(clazz.getMethods(), "\r\n"));//获取 public 方法，包含父类 public 方法
		System.out.println();
		System.out.println("clazz.getDeclaredMethods() --> " + join(clazz.getDeclaredMethods(), "\r\n"));//获取所有字段
		System.out.println();
		System.out.println("clazz.getConstructors() --> " + join(clazz.getConstructors(), "\r\n"));//获取构造方法
		System.out.println();
		try {
			clazz.newInstance().t();//实例化 TestClass 对象，调用对象中的 t() 方法
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 拼接数组成字符串
	 * @param objs
	 * @param s
	 * @return
	 */
	private static String join(Object[] objs, String s) {
		StringBuilder r = new StringBuilder();
		for (Object obj : objs) {
			r.append(obj).append(s);
		}
		return r.toString();
	}
}
