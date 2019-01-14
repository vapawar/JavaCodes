package test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo04 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(4);
		Set<Callablez> set = new HashSet<>();
		Callablez c1 = new Callablez();
		Callablez c2 = new Callablez();
		Callablez c6 = new Callablez();
		Callablez c8 = new Callablez();
		set.add(c1);
		set.add(c2);
		set.add(c6);
		set.add(c8);
		List<Future<String>> futures = service.invokeAll(set);
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		service.shutdown();
	}
}

class Callablez implements Callable<String> {
	String data = "Runner";

	@Override
	public String call() throws Exception {
		return data + " :: " + (new Random().nextInt());
	}
}
