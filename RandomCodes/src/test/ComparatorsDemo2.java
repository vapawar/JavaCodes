package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorsDemo2 {

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<>();

		Student u1 = new Student(145, "vasu");
		Student u2 = new Student(156, "Aryan");
		Student u3 = new Student(138, "ganesh");
		Student u4 = new Student(432, "test");
		Student u5 = new Student(325, "pune");
		Student u6 = new Student(422, "gao");
		Student u7 = new Student(642, "oracle");
		Student u8 = new Student(875, "Java");
		students.add(u1);
		students.add(u4);
		students.add(u7);
		students.add(u5);
		students.add(u8);
		students.add(u3);
		students.add(u2);
		students.add(u6);
		ArrayList<Student> a1 = (ArrayList<Student>) students.clone();
		ArrayList<Student> a2 = (ArrayList<Student>) students.clone();
		System.out.println("Before sort:-");
		students.forEach(t -> System.out.println(t.id + " : " + t.name));

		Collections.sort(a1, Comparator.comparingInt(Student::getId));
		System.out.println("Sort by ID:-");
		a1.forEach(t -> System.out.println(t.id + " : " + t.name));

		Collections.sort(a2, Comparator.comparing(Student::getName));
		System.out.println("Sort by name:-");
		a2.forEach(t -> System.out.println(t.id + " : " + t.name));
	}

}
