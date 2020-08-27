package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutputs {

    public static void main(String[] args) throws IOException {
        /*
         * Scanner sc=new Scanner(System.in); System.out.println("Enter number: "); int
         * temp=sc.nextInt(); System.out.println("Data "+temp); //scanner from file
         * sc=new Scanner(Paths.get("D:test.txt")); StringBuffer t0=new
         * StringBuffer(sc.nextLine()); System.out.println("t0: "+t0);
         */

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:test.txt", true));
        bw.write(Integer.toString(12));
        bw.write(" test" + "\r\n");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("D:test.txt"));
        String temp2 = new String();
        while ((temp2 = br.readLine()) != null) {
            System.out.println("Data : " + temp2);
        }
        br.close();

        /*
         * FileReader f2=new FileReader("D:\\test.txt"); int str=0; while((str=f2.read()
         * )!= -1) { System.out.println((char)str); }
         */
    }
}
