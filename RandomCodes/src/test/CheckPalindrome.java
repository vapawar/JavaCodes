package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckPalindrome {
    public static void main(String[] args) {
        // System.out.println(checkPalindrome("nin"));
        int[] age = { 22, 36, 8, 47, 28, 56, 38, 74 };
        String[] name = { "vinod", "ganes", "samual", "test" };
        Arrays.sort(age);
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }
        List<String> sortedName = Arrays.asList(name);
        Collections.sort(sortedName);
        sortedName.forEach(x -> System.out.println(x));
        check_pdrome("pawar");
    }

    public static boolean check_pdrome(String str) {
        // char[] s1 = str.toCharArray();
        // char[] s2 = str.toCharArray();
        // int count = 0;
        // for (int i = s1.length - 1; i >= 0; i--) {
        // s2[count] = s1[i];
        // count++;
        // }
        // for (int i = 0; i < s1.length - 1; i++)
        // if (s1[i] != s2[i])
        // return false;
        // return true;
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);

    }
}