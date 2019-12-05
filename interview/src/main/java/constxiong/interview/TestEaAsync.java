package constxiong.interview;
import static com.ea.async.Async.await;
import static java.util.concurrent.CompletableFuture.completedFuture;

import java.util.concurrent.CompletableFuture;

public class TestEaAsync {

	public static void main(String[] args) {

		String result = test().join();
		System.out.println(result);
		
		System.out.println(testAsync());
		
	}
	
	public static CompletableFuture<String> test() {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "ConstXiong";
		}), (s1, s2) -> {
			return s1 + " " + s2;
		});
	}
	
	public static String testAsync() {
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		});
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "ConstXiong";
		});
		return await(cf1) + " " +await(cf2);
	}

}