package test;

import java.util.Locale;

public class LocalesDemo {

	public static void main(String[] args) {

		try {
			System.out.println("D: " + Locale.getDefault());
			Locale.setDefault(Locale.GERMAN);
			throw new Exception("message here......");
		} catch (Exception e) {
			System.out.println("E: " + e);
			System.out.println("L: " + e.getLocalizedMessage() + Locale.getDefault());
			Locale.setDefault(Locale.ENGLISH);
			System.out.println("M: " + e.getMessage() + Locale.getDefault());
		}
	}
}