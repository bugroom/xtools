package constxiong.interview;

/**
 * replace 和 replaceAll 方法的区别
 * @author ConstXiong
 * @date 2019-04-15 09:31:04
 */
public class TestReplace {

	public static void main (String[] args ) {
		String str = "Hello Java. Java is a language.";
		System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language.
		System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.
	}
	
}
