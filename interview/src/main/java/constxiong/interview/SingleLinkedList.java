package constxiong.interview;

/**
 * 单向链表
 * @author ConstXiong
 * @param <E>
 */
class SingleLinkedList<E> {
	
	int size = 0;
	
	Node<E> first;
	Node<E> last;
	
	public SingleLinkedList() {
		
	}
	
	public void add(E e) {
		Node<E> l = last;
		Node<E> item = new Node<E>(e, null);
		last = item;
		if (l == null) {
			this.first = item;
		} else {
			l.next = item;
		}
		size++;
	}
	/**
	 * 打印链表
	 * @param ll
	 */
	public void print() {
		for (Node<E> item = first; item != null; item = item.next) {
			System.out.print(item + " ");
		}
	}

	/**
	 * 单向链表中的节点
	 * @author ConstXiong
	 * @param <E>
	 */
	public static class Node<E> {
		E item;
		Node<E> next;
		
		Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
		

		public E get() {
			return item;
		}

		@Override
		public String toString() {
			return item.toString();
		}
		
	}
}
