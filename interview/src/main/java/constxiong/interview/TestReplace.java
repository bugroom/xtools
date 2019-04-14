package constxiong.interview;

public class TestReplace {

	public static void main (String[] args ) {
		String str = "Hello Java. Java is a language.";
		System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language
		System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.
	}
	
}
