package test;

public class MethodOverrideCheck {

    public static void main(String[] args) {
        foo(null);
    }

    private static void foo(Object object) {
        System.out.println("root");
    }

    private static void foo(String str) {
        System.out.println("str");
    }

    public static void foo(int a) {
        System.out.println("primitive");
    }
}
