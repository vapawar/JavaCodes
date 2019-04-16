package test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ErrorTest {

	public static void main(String[] args) throws Exception {
		show2();

	}

	private static void show2() throws IOException {
		show1();
	}

	private static void show1() throws FileNotFoundException {
		throw new FileNotFoundException("error1");
	}
}
