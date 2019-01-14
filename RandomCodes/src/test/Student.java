package test;

public class Student {

	String name;
	String surname;
	int id;
	
	public Student()
	{
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public boolean equals(Object s1) {
		Student s = (Student) s1;
		return this.getName().equals(s.getName()) && this.getSurname().equals(s.getSurname());
	}

}
