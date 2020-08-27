package test;

public interface BaseData {

    int abc = 120;

    default void say() {
        System.out.println("Hello default...");
    }

    static void sayNow() {
        System.out.println("Hello static method...");
    }
}
