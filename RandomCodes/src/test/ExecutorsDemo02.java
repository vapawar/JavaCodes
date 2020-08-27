package test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo02 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callables[] tasks = { new Callables("vpz"), new Callables("test"), new Callables("data"), new Callables("code"),
                new Callables("str"), new Callables("math"), new Callables("xs12"), new Callables("halt") };
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (Callables callables : tasks) {
            service.submit(callables);
        }
        service.shutdown();

    }
}

class Callables implements Callable<String> {
    String data;

    public Callables(String str) {
        this.data = str;
    }

    @Override
    public String call() throws Exception {
        System.out.println("at tasks::" + this.data + "::123");
        Thread.sleep(new Random().nextInt(8000));
        return this.data;
    }
}
