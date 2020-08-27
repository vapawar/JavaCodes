package test;

public class MinimumArraySum {

    public static void main(String[] args) {

        int[] b = { 83, 43, 3, 345, 324, 3, 5, 223, 723, 956 };
        int[] a = { 7, 2, 3, 4, 5, 6 };

        int test1 = a[0];

        for (int i = 1; i < a.length; i++) {
            if (test1 > a[i])
                test1 = a[i];

        }

        int test2 = b[0];
        for (int i = 1; i < b.length; i++) {
            if (test2 > b[i])
                test2 = b[i];

        }
        System.out.println("Smallest value from array1 is  : " + test1);
        System.out.println("Greedy algos output for array2 :" + (test2 * (b.length - 1)));
    }
}
