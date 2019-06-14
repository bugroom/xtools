package constxiong.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestHashCode {
	
	private static final Random R = new Random();
	
	private int value;
	
	public TestHashCode(int value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Map<TestHashCode, String> map = new HashMap<TestHashCode, String>();
		TestHashCode t1 = new TestHashCode(1);;
		map.put(t1, "1");
		
		System.out.println(map.get(t1));
	}

	@Override
	public int hashCode() {
		return R.nextInt(100);
	}
}
