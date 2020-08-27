package test;

public class NormalSearch {

    public static void main(String[] args) {

        int[] a = { 45, 12, 3, 42, 32, 3, 5, 3, 5, 34, 53, 67, 534, 43, 3, 4 };

        NormalSearch ns = new NormalSearch();
        ns.search(a, 34);
    }

    private void search(int[] a, int k) {
        int loc = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                loc = i;
                break;
            }
        }
        if (loc == (-1))
            System.out.println("Number is not found in array");
        else
            System.out.println("The number " + k + " is found at location: " + (loc + 1));
    }
}
