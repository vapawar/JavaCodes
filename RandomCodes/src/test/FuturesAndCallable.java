package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesAndCallable {
    public static void main(String[] args) throws InterruptedException {

        List<Messager> tasks = new ArrayList<>();
        tasks.add(new Messager("Vinod"));
        tasks.add(new Messager("Veronica"));
        tasks.add(new Messager("Jashua"));
        tasks.add(new Messager("Sams"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = futures = executorService.invokeAll(tasks);
        futures.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}

class Messager implements Callable<String> {
    static Integer counter = 0;
    private String name;

    public Messager(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return "Hello" + (counter++) + this.name;
    }
}
