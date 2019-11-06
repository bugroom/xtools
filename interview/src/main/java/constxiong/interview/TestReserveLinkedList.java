package constxiong.interview;

import constxiong.interview.SingleLinkedList.Node;

/**
 * 反转单向列表
 * 
 * @author ConstXiong
 * @date 2019-11-06 11:04:12
 */
public class TestReserveLinkedList {

	public static void main(String[] args) {
		SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.print();
		reverseLinkedList(ll);
		System.out.println();
		ll.print();
	}
	
	public static void reverseLinkedList(SingleLinkedList<Integer> ll) {
		Node<Integer> first = ll.first;
		reverseNode(first);
//		reverseNodeByRecursion(first);
		ll.first = ll.last;
		ll.last = first;
	}

	/**
	 * 循环逆转节点指针
	 * @param first
	 */
	public static void reverseNode(Node<Integer> first) {
		Node<Integer> pre = null;
		Node<Integer> next = null;
		while (first != null) {
			next = first.next;
			first.next = pre;
			pre = first;
			first = next;
		}
		
	}

	/**
	 * 递归逆转节点指针
	 * @param head
	 * @return
	 */
	public static Node<Integer> reverseNodeByRecursion(Node<Integer> first) {
		if (first == null || first.next == null) {
			return first;
		}
		Node<Integer> prev = reverseNodeByRecursion(first.next);
		first.next.next = first;
		first.next = null;
		return prev;
	}
}
