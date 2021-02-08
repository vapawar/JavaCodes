package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class WeightedSort {

    public static void main(String[] args) {

        Integer[] data = { 12, 3, 43, 3, 8, 3, 43, 4, 3, 423, 56, 23, 242, 3, 23, 2, 3, 6576, 567, 65, 67, 7, 67, 567,
                6, 765, 7, 94, 64, 43, 5, 344, 28, 43, 42, 3434, 24, 3234, 345, 34545, 455, 56, 23, 242, 3, 23, 2, 3,
                6576, 567, 65, 67, 7, 67, 6, 765, 7, 94, 64, 43, 5, 5, 344, 28, 43, 42, 34234, 24, 3234, 345, 8, 12, 56,
                23, 56, 78, 345, 98 };
        sort(data);
    }

    public static void sort(Integer[] data) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        Arrays.asList(data).forEach(x -> hmap.put(x, Collections.frequency(Arrays.asList(data), x)));
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (hmap.get(data[j]) < hmap.get(data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        LinkedHashSet<Integer> dt = new LinkedHashSet<>(Arrays.asList(data));
        dt.forEach(x -> System.out.print(x + ":" + map.get(x) + "  "));
    }
}
