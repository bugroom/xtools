package constxiong.interview;

/**
 * 使用指令 javap -c -v TestSynchronized 查看class文件反汇编信息
 * @author ConstXiong
 * @date 2019-05-27 10:34:19
 */
public class TestSynchronized {
	
	public void sync() {
		synchronized (this) {
			System.out.println("sync");
		}
	}
	
	public synchronized void syncdo() {
		System.out.println("syncdo");
	}
	
	public static synchronized void staticSyncdo() {
		System.out.println("staticSyncdo");
	}
}
