package test;

import java.util.ArrayList;

@SuppressWarnings("all")
public class CatchTheThief {

    public static void main(String[] args) {

        char[] data = { 'P', 'T', 'T', 'P', 'T', 'P', 'T', 'T', 'P' };
        CatchTheThief x = new CatchTheThief();
        x.catchThief(data, 1);
    }

    private void catchThief(char[] data, int k) {
        int catches = 0;
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            char ch = data[i];
            if (ch == 'P')
                p.add(i);
            else
                t.add(i);
        }
        int pc = 0;
        int tc = 0;
        while (tc < t.size() && pc < p.size()) {
            if (Math.abs(t.get(tc) - p.get(pc)) <= k) {
                catches++;
                pc++;
                tc++;

            } else if (t.get(tc) < p.get(pc)) {
                tc++;
            } else
                pc++;
        }
        System.out.println("Cathed thives no: " + catches);
    }
}
