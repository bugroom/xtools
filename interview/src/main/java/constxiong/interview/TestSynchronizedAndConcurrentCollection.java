package constxiong.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试 同步容器与并发容器
 * @author ConstXiong
 * @date 2019-12-26 20:56:32
 */
public class TestSynchronizedAndConcurrentCollection {
	
	static List<Integer> list = new ArrayList<Integer>();
	
	static Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

	public static void main(String[] args) throws InterruptedException {
//		testSynchronizedCollection();
		testConcurrentCollection();
	}

	
	/**
	 * 测试同步容器
	 * @throws InterruptedException 
	 */
	private static void testSynchronizedCollection() throws InterruptedException {
//		list = Collections.synchronizedList(list);
		for (int i = 0; i < 300; i++) {
			final int index = i;
			Thread t = new Thread(() -> {
				list.add(index);
			});
			t.start();
		}
		System.out.println(list);
	}
	
	/**
	 * 测试并发容器
	 */
	private static void testConcurrentCollection() {
		for (int i = 0; i < 300; i++) {
			final int index = i;
			new Thread(() -> {
				map.put(index, index);
			}).start();
		}
		System.out.println(map);
	}
	
}
