package test;

public class EnumChecker {
    public static void main(String[] args) {
        for (Environment env : Environment.values()) {
            System.out.println(env.name() + " :::::::::::: " + env.getURL());
        }
        System.out.println("PROD: " + Environment.PROD.getURL());
        System.out.println("ARTS: " + StudentMapper.ARTS.getCode());
    }
}
