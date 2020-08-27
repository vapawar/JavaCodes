package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsTest {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        FileOutputStream out = new FileOutputStream("test.properties");
        properties.setProperty("ip", "10.247.100.120");
        properties.setProperty("db", "oracle");
        properties.store(out, null);
        out.close();

        FileInputStream in = new FileInputStream("test.properties");
        properties.load(in);

        System.out.println(properties.getProperty("db"));
        System.out.println(properties.getProperty("ip"));
        in.close();
    }
}
