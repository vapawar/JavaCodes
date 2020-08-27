package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryResource {

    public static void main(String[] args) throws IOException {
        System.out.println("going in");
        try (Scanner sc = new Scanner(new FileInputStream(
                "C:\\\\Users\\\\vp\\\\eclipse-workspace\\\\RandomCodes\\\\src\\\\test\\\\TryResourceh.java"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Files.readAllLines(
                Paths.get("C:\\Users\\vp\\eclipse-workspace\\RandomCodes\\src\\test\\TryResourceh.java")));
        System.out.println("out after");
    }
}
