package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDupWords {
    public static void main(String[] args) {
        String str = "ac ab ad ad ab bcd";
        List<String> str2 = new ArrayList<>();
        str2.addAll(Arrays.asList(str.split(" ")));
        while (checkDups(str2)) {
            for (int i = 0; i < str2.size() - 1; i++) {
                if (str2.get(i).equals(str2.get(i + 1))) {
                    str2.remove(i);
                    str2.remove(i);
                }
            }
        }
        str2.forEach(x -> System.out.println(x));
    }

    public static boolean checkDups(List<String> str) {
        boolean flag = false;
        for (int i = 0; i < str.size() - 1; i++) {
            if (str.get(i).equals(str.get(i + 1)))
                flag = true;
        }
        return flag;
    }
}