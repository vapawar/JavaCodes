package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo01 {
    public static void main(String[] args) {

        Runnables[] tasks = { new Runnables(12), new Runnables(24), new Runnables(28), new Runnables(48) };
        ExecutorService service = Executors.newCachedThreadPool();
        for (Runnables runnables : tasks) {
            service.execute(runnables);
        }
        System.out.println("Done");
        service.shutdown();
    }
}

class Runnables implements Runnable {

    int abc;

    public Runnables(int num) {
        this.abc = num;
    }

    @Override
    public void run() {
        System.out.println("at task" + this.abc);
    }
}
