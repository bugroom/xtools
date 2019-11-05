package constxiong.interview;

import constxiong.interview.LinedList.Node;

public class MergeLinedList {

	public static void main(String[] args) {
		LinedList<Integer> ll = new LinedList<Integer>();
		ll.add(11);
		ll.add(12);
		ll.add(3);
		for (Node<Integer> n = ll.first; n != null ; n = n.next) {
			System.out.println(n);
		}
	}
	
}

/**
 * 链表
 * @author ConstXiong
 * @param <E>
 */
class LinedList<E> {
	
	int size = 0;
	
	Node<E> first;
	Node<E> last;
	
	public LinedList() {
		
	}
	
	public void add(E e) {
		Node<E> l = last;
		Node<E> item = new Node<E>(l, e, null);
		last = item;
		if (l == null) {
			this.first = item;
		} else {
			l.next = item;
		}
		size++;
	}

	/**
	 * 链表中的节点
	 * @author ConstXiong
	 * @param <E>
	 */
	public static class Node<E> {
		E item;
		Node<E> pre;
		Node<E> next;
		
		Node(Node<E> pre, E item, Node<E> next) {
			this.pre = pre;
			this.item = item;
			this.next = next;
		}

		@Override
		public String toString() {
			return item.toString();
		}
		
	}
}
