package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class WaightedSort {
    public static void main(String[] args) {
        Integer[] data1 = { 12, 3, 4, 3, 2, 23, 7, 12, 3, 3, 4, 42, 2, 2, 4, 3, 4, 57, 9, 7, 12 };
        Integer[] data2 = { 12, 3, 4, 3, 2, 23, 7, 12, 3, 3, 4, 42, 2, 2, 4, 3, 4, 57, 9, 7, 12 };
        Integer[] data3 = { 12, 3, 4, 3, 2, 23, 7, 12, 3, 3, 4, 42, 2, 2, 4, 3, 4, 57, 9, 7, 12 };
        xsort2(data1); // performance optimized
        xsort(data2); // non optimized
        sort(data3); // not using inbuilt method to get frequency
    }

    public static void xsort2(Integer[] data) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // calculate frequency of number and put it into map
        Arrays.asList(data).forEach(x -> hmap.put(x, Collections.frequency(Arrays.asList(data), x)));
        Arrays.sort(data);
        System.out.print("\nNatural sorting: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (hmap.get(data[j]) < hmap.get(data[j + 1])) {
                    int temp = (int) data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.print("\nWeighted sotring: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        System.out.print("\nExpected output:::::::: ");
        Arrays.asList(data).stream().distinct().forEach(x -> System.out.print(x + " "));
    }

    public static void xsort(Integer[] data) {
        Arrays.sort(data);
        System.out.print("\nNatural sorting: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (Collections.frequency(Arrays.asList(data), data[j]) < Collections.frequency(Arrays.asList(data),
                        data[j + 1])) {
                    int temp = (int) data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.print("\nWeighted sotring: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        System.out.print("\nExpected output: ");
        Arrays.asList(data).stream().distinct().forEach(x -> System.out.print(x + " "));
    }

    public static void sort(Integer[] data) {
        Arrays.sort(data);
        System.out.print("\nNatural sorting: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (weight(data, data[j]) < weight(data, data[j + 1])) {
                    int temp = (int) data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.print("\nWeighted sotring: ");
        Arrays.asList(data).forEach(x -> System.out.print(x + " "));
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int a : data)
            set.add(a);
        System.out.print("\nPrimitive way output:");
        set.forEach(x -> System.out.print(x + " "));
    }

    public static int weight(Integer[] data, int num) {
        int weight = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == num)
                weight++;
        }
        return weight;
    }
}