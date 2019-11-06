package constxiong.interview;

import constxiong.interview.SingleLinkedList.Node;

/**
 * 链表两个有序列表
 * @author ConstXiong
 * @date 2019-11-06 09:37:14
 */
public class TestMergeLinkedList {

	public static void main(String[] args) {
		SingleLinkedList<Integer> ll1 = new SingleLinkedList<Integer>();
		ll1.add(3);
		ll1.add(8);
		ll1.add(19);
		
		SingleLinkedList<Integer> ll2 = new SingleLinkedList<Integer>();
		ll2.add(3);
		ll2.add(10);
		ll2.add(17);
		
		mergeeSingleLinkedList(ll1, ll2).print();
	}
	
	/**
	 * 合并两个有序列表
	 * @param ll1
	 * @param ll2
	 * @return
	 */
	private static SingleLinkedList<Integer> mergeeSingleLinkedList(SingleLinkedList<Integer> ll1, SingleLinkedList<Integer> ll2) {
		if (isEmpty(ll1) || isEmpty(ll2)) {
			return isEmpty(ll1) ? ll2 : ll1;
		}
		SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
		Node<Integer> ll1Node = ll1.first;
		Node<Integer> ll2Node = ll2.first;
		Node<Integer> small = ll1Node.get() <= ll2Node.get() ? ll1Node : ll2Node;
		Node<Integer> large = ll1Node.get() > ll2Node.get() ? ll1Node : ll2Node;
		do {
			ll.add(small.get());
			Node<Integer> smallNext = small.next;
			if (smallNext == null || large == null) {
				small = smallNext == null ? large : smallNext;
				large = null;
			} else {
				small = smallNext.get() <= large.get() ? smallNext : large;
				large = smallNext.get() > large.get() ? smallNext : large;
			}
		}
		while (small.next != null || large != null);
		return ll;
	}
	
	/**
	 * 测试链表存储是否OK
	 */
	public static void testSingleLinkedListIsOk() {
		SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
		ll.add(3);
		ll.add(8);
		ll.add(19);
		ll.print();
	}
	
	
	private static boolean isEmpty(SingleLinkedList<Integer> ll) {
		if (ll == null || ll.size == 0) {
			return true;
		}
		return false;
	}
	
}

