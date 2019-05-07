package constxiong.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class TestIterator {
	
	static List<String> list = new ArrayList<String>();
	
	static {
		list.add("111");
		list.add("222");
		list.add("333");
	}
	

	public static void main(String[] args) {
//		testIteratorNext();
//		System.out.println();
//		
//		testForEachRemaining();
//		System.out.println();
//		
//		testIteratorRemove();
		
//		testListRevome();
		testForEachRemainingIteRemove();
	}
	
	//使用 hasNext 和 next遍历 
	public static void testIteratorNext() {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
	}
	
	//使用 Iterator 删除元素 
	public static void testIteratorRemove() {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if ("222".equals(str)) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}
	
	//使用 forEachRemaining 遍历
	public static void testForEachRemaining() {
		final Iterator<String> iterator = list.iterator();
		iterator.forEachRemaining(new Consumer<String>() {

			public void accept(String t) {
				System.out.println(t);
			}
			
		});
	}
	
	//使用迭代器遍历元素过程中，调用集合的 remove(Object obj) 方法可能会报 java.util.ConcurrentModificationException 异常
	public static void testListRevome() {
		 ArrayList<String> aList = new ArrayList<String>();
         aList.add("111");
         aList.add("333");
         aList.add("222");
         System.out.println("移除前："+aList);
         
         Iterator<String> iterator = aList.iterator();
         while(iterator.hasNext())
         {
             if("222".equals(iterator.next()))
             {
                aList.remove("222");          
             }
         }
         System.out.println("移除后："+aList);
	}
	
	//JDK 1.8 Iterator forEachRemaining 方法中 调用Iterator 的 remove 方法会报 java.lang.IllegalStateException 异常
	public static void testForEachRemainingIteRemove () {
		final Iterator<String> iterator = list.iterator();
		iterator.forEachRemaining(new Consumer<String>() {

			public void accept(String t) {
				if ("222".equals(t)) {
					iterator.remove();
				}
			}
		});
	}
}
