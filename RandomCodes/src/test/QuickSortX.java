package test;

import java.util.Arrays;

public class QuickSortX {

    public static void main(String[] args) {
        
        QuickSortX x = new QuickSortX();
        int[] x2 = { 23, 343, 4, 3, 54, 809, 4, 56, 43, 34, 54, 5, 434, 54 };
        x.sort(x2, 0, x2.length - 1);
        System.out.println(Arrays.toString(x2));
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = part(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int part(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
