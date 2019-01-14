package test;

public class HashcodeEquals {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("vpz");
		s1.setSurname("code");
		Student s2 = new Student();
		s2.setName("vpz");
		s2.setSurname("code");
		System.out.println(s1.equals(s2));
		System.out.println(s1+"::"+Integer.toHexString( s1.hashCode()));
		System.out.println("testtest".hashCode());
		System.out.println("testtest0".hashCode());
	}
}
