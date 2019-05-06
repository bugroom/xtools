package constxiong.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestArrayListLinkedList {

	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		int size = 10000 * 1000;
		int index = 5000 * 1000;
		
		System.out.println("arrayList add " + size);
		addData(arrayList, size);
		System.out.println("linkedList add " +  + size);
		addData(linkedList, size);
		System.out.println();
		
		System.out.println("arrayList get " + index + " th");
		getIndex(arrayList, index);
		System.out.println("linkedList get " + index + " th");
		getIndex(linkedList, index);
		System.out.println();
		
		System.out.println("arrayList set " + index + " th");
		setIndex(arrayList, index);
		System.out.println("linkedList set " + index + " th");
		setIndex(linkedList, index);
		System.out.println();
		
		System.out.println("arrayList add " + index + " th");
		addIndex(arrayList, index);
		System.out.println("linkedList add " + index + " th");
		addIndex(linkedList, index);
		System.out.println();
		
		System.out.println("arrayList remove " + index + " th");
		removeIndex(arrayList, index);
		System.out.println("linkedList remove " + index + " th");
		removeIndex(linkedList, index);
		System.out.println();
		
		System.out.println("arrayList remove Object " + index);
		removeObject(arrayList, (Object)index);
		System.out.println("linkedList remove Object " + index);
		removeObject(linkedList, (Object)index);
		System.out.println();
		
		System.out.println("arrayList add");
		add(arrayList);
		System.out.println("linkedList add");
		add(linkedList);
		System.out.println();
		
		System.out.println("arrayList foreach");
		foreach(arrayList);
		System.out.println("linkedList foreach");
		foreach(linkedList);
		System.out.println();
		
		System.out.println("arrayList forSize");
		forSize(arrayList);
		System.out.println("linkedList forSize");
//		forSize(linkedList);
		System.out.println("cost time: ...");
		System.out.println();
		
		System.out.println("arrayList iterator");
		ite(arrayList);
		System.out.println("linkedList iterator");
		ite(linkedList);
	}
	
	private static void addData(List<String> list, int size) {
		long s1 = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(String.valueOf(i));
		}
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void getIndex(List<String> list, int index) {
		long s1 = System.currentTimeMillis();
		list.get(index);
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void setIndex(List<String> list, int index) {
		long s1 = System.currentTimeMillis();
		list.set(index, "1024");
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void addIndex(List<String> list, int index) {
		long s1 = System.currentTimeMillis();
		list.add(index, "1024");
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void removeIndex(List<String> list, int index) {
		long s1 = System.currentTimeMillis();
		list.remove(index);
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void removeObject(List<String> list, Object obj) {
		long s1 = System.currentTimeMillis();
		list.remove(obj);
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void add(List<String> list) {
		long s1 = System.currentTimeMillis();
		list.add("1024");
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void foreach(List<String> list) {
		long s1 = System.currentTimeMillis();
		for (String i : list) {
			//do nothing
		}
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void forSize(List<String> list) {
		long s1 = System.currentTimeMillis();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i);
		}
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
	private static void ite(List<String> list) {
		long s1 = System.currentTimeMillis();
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			ite.next();
		}
		long s2 = System.currentTimeMillis();
		System.out.println("cost time: " + (s2-s1));
	}
	
}
