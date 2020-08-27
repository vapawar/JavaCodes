package test;

class Threads01 implements Runnable {
    public void run() {
        System.out.println("Inside runnable implementor.");
    }
}

class Threads02 extends Thread {
    public void run() {
        System.out.println("Inside threads exrtender.");
    }
}

public class Threads {
    public static void main(String[] args) {
        Thread t = new Thread(new Threads01());
        t.start();
        t = new Threads02();
        t.start();
        System.gc();
    }
}