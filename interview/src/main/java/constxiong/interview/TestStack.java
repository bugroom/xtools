package constxiong.interview;

import java.util.LinkedList;

/**
 * 测试 LinkedList 实现 Stack 数据结构，存在问题
 * @author ConstXiong
 * @date 2019-11-06 16:08:18
 */
public class TestStack {
	
	LinkedList list = new LinkedList();

	public synchronized void push(Object x) {
		synchronized (list) {
			list.addLast(x);
			notify();
		}
	}

	public synchronized Object pop() throws Exception {
		synchronized (list) {
			//容易出问题，改成 if -> while；notify() -> notifyAll() 
			if (list.size() <= 0) {
				wait();
			}
			return list.removeLast();
		}
	}
}
