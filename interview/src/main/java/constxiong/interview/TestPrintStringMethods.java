package constxiong.interview;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestPrintStringMethods {

	public static void main(String[] args) {
		Set<String> mms = new HashSet<String>();
		for (Method t : String.class.getMethods()) {
			String mm = t.getName();
			if (!mms.contains(mm)) {
				System.out.println(mm);
				mms.add(mm);
			}
		}
	}
}
