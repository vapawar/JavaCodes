package test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Sorter {

    public static void main(String[] args) {
        Integer[] data = { 12, 43, 34, 32, 212, 32, 5, 46, 56, 45, 6, 7, 7, 68, 76, 8, 6, 54, 4, 323, 2, 23, 13, 4, 5,
                656, 76, 876, 87, 8, 8, 6564, 6, 4, 23, 4, 6, 6, 67, 7, 75, 67, 56, 67, 56 };
        Set<Integer> s = sort(data);
        s.forEach(x -> System.out.print(x + " "));
    }

    private static Set<Integer> sort(Integer[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (count(data, data[j]) < count(data, data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        Set<Integer> dt = new LinkedHashSet<>();
        Arrays.asList(data).forEach(x -> dt.add(x));
        return dt;
    }

    public static int count(Integer[] data, int num) {
        int count = 0;
        for (int i = 0; i < data.length; i++)
            if (data[i] == num)
                count++;
        return count;
    }
}
