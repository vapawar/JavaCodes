package DBMS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) throws Exception {
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader("test.csv"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] b = line.split(splitBy);
            System.out.println(b[0]);
        }
        br.close();
    }
}

class ReadCSV2 {
    public void readCsvData(String fname) throws IOException {
        BufferedReader br = null;
        String line = "";
        String cvsSeperator = ",";
        try {
            br = new BufferedReader(new FileReader(fname));
            while ((line = br.readLine()) != null) {
                String[] cvsData = line.split(cvsSeperator);
                System.out.println(cvsData[0] + "   " + cvsData[1] + "   " + cvsData[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
    }
}