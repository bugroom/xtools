package constxiong.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestStratThread {
	
	public static void main(String[] args) {
		testStrartSubThread();
		testImplementsRunable();
		testImplementsCallable();
	}
	
	//测试继承Thread类的方式创建、启动线程
	public static void testStrartSubThread() {
		Thread t1 = new CustomThread();
		t1.setName("CustomThread");
		t1.start();
	}
	
	//测试实现Runnable接口的方式创建、启动线程
	public static void testImplementsRunable() {
		Thread t2 = new Thread(new CustomRunnable());
		t2.setName("CustomRunnable");
		t2.start();
	}
	
	//测试实现Callable接口的方式创建、启动线程
	public static void testImplementsCallable() {
		Callable<String> callable = new CustomCallable();
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		Thread t3 = new Thread(futureTask);
		t3.setName("CustomCallable");
		t3.start();
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}

//继承自Thread，重写run方法
class CustomThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}

////实现Runnable接口，重写run方法
//class CustomRunnable implements Runnable {
//
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//	}
//	
//}
//
////实现Callable接口，重写call方法
//class CustomCallable implements Callable<String> {
//
//	public String call() throws Exception {
//		System.out.println(Thread.currentThread().getName());
//		return "Callable Result";
//	}
//	
//}