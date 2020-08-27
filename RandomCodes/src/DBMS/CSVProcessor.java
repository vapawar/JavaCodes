package DBMS;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVProcessor {

    public void ReadCSV(String fname) throws Exception {
        String separator = ",";
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fname));

        while ((line = br.readLine()) != null) {
            String[] strs = line.split(separator);
            System.out.println(strs[0] + strs[1] + strs[2]);
        }
        br.close();
    }
}
