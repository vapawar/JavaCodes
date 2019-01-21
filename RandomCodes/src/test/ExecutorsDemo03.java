package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo03 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Set<CallablesFuture> tasks = new HashSet<>();

		tasks.add(new CallablesFuture(":12t2x:"));
		tasks.add(new CallablesFuture(":numbers:"));
		tasks.add(new CallablesFuture(":num12:"));
		tasks.add(new CallablesFuture(":vpz:"));
		tasks.add(new CallablesFuture(":24xt:"));
		tasks.add(new CallablesFuture(":randoms:"));
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<String>> futures = service.invokeAll(tasks);
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		service.shutdown();
	}
}

class CallablesFuture implements Callable<String> {
	String data;

	public CallablesFuture(String str) {
		this.data = str;
	}

	@Override
	public String call() throws Exception {
		return this.data + "::1234";
	}
}
