package test;

public class PrimesDemo {
    public static void main(String[] args) {

        Long num = Long.MAX_VALUE;

        PrimesDemo p = new PrimesDemo();

        for (long i = 0; i < num; i++) {
            if (p.checkPrime(i))
                System.out.println(i + " is prime number");
        }
    }

    public boolean checkPrime(long number) {
        boolean flag = false;
        for (long i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            } else
                flag = true;
        }
        return flag;
    }
}
