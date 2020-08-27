package test;

import java.io.IOException;
import java.util.LinkedList;

public class Stack2 {
    private LinkedList<Object> stk = new LinkedList<>();

    public void push(Object data) {
        stk.addFirst(data);
    }

    public Object top() {
        return stk.getFirst();
    }

    public Object pop() {
        return stk.removeFirst();
    }

    public static void main(String[] args) throws IOException {
        /*
         * Stack2 st=new Stack2(); st.push(new Integer(85045454));
         * st.push("YWEfgdjlkdnlghfjd0Ue5y45I"); System.out.println(st.top());
         * System.out.println(st.pop()); System.out.println(st.top()); new
         * Stack2().push(121231);
         */

        /*
         * BufferedWriter br=new BufferedWriter(new FileWriter("D:\\test.txt", true));
         * String ch=System.lineSeparator(); br.write(ch); br.write("test data");
         * br.write(ch); br.close(); System.out.println("line separator: "+ ch);
         * System.out.println(System.getProperty("sun.jnu.encoding"));
         * 
         * BufferedReader br2=new BufferedReader(new InputStreamReader(System.in)); char
         * ch2=br2.readLine().charAt(0); br2.close();
         * 
         * String str2=String.format("Name: %s %ncheck01 %nAge: %d %ncheck02 %nHalt"
         * ,"Aryan",12121); System.out.println(str2);
         */
        String str = "Hello";
        System.out.println(new StringBuffer(str).reverse());

    }
}