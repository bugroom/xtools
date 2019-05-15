package constxiong.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestRunnableAndCallable {

	public static void main(String[] args) {
		testImplementsRunable();
		testImplementsCallable();
		testImplementsCallableWithException();
	}
	
	//测试实现Runnable接口的方式创建、启动线程
	public static void testImplementsRunable() {
		Thread t1 = new Thread(new CustomRunnable());
		t1.setName("CustomRunnable");
		t1.start();
	}
	
	//测试实现Callable接口的方式创建、启动线程
	public static void testImplementsCallable() {
		Callable<String> callable = new CustomCallable();
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		Thread t2 = new Thread(futureTask);
		t2.setName("CustomCallable");
		t2.start();
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	//测试实现Callable接口的方式创建、启动线程，抛出异常
	public static void testImplementsCallableWithException() {
		Callable<String> callable = new CustomCallable2();
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		Thread t3 = new Thread(futureTask);
		t3.setName("CustomCallableWithException");
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

//实现Runnable接口，重写run方法
class CustomRunnable implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName());
//		throw new RuntimeException("aaa");
	}
	
}

//实现Callable接口，重写call方法
class CustomCallable implements Callable<String> {

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return "Callable Result";
	}
	
}

//实现Callable接口，重写call方法无法计算抛出异常
class CustomCallable2 implements Callable<String> {

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		throw new Exception("I can compute a result");
	}
	
}
