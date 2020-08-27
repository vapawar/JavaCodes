package test;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "ca";
        System.out.println(check(str1, str2));
    }

    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++)
            if (c1[i] != c2[i])
                return false;
        return true;
    }
}
