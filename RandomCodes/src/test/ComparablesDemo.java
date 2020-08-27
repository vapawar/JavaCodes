package test;

import java.util.ArrayList;
import java.util.Collections;

public class ComparablesDemo {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        User u1 = new User(145, "vasu");
        User u2 = new User(156, "Aryan");
        User u3 = new User(138, "ganesh");
        User u4 = new User(432, "test");
        User u5 = new User(325, "pune");
        User u6 = new User(422, "gao");
        User u7 = new User(642, "oracle");
        User u8 = new User(875, "Java");
        users.add(u1);
        users.add(u4);
        users.add(u7);
        users.add(u5);
        users.add(u8);
        users.add(u3);
        users.add(u2);
        users.add(u6);
        System.out.println("Before sort:-");
        users.forEach(t -> System.out.println(t.id + " : " + t.name));
        Collections.sort(users);
        System.out.println("After sort:-");
        users.forEach(t -> System.out.println(t.id + " : " + t.name));
    }
}

class User implements Comparable {
    int id;
    String name;

    public User(int num, String name) {
        this.id = num;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        User s = (User) o;
        return this.name.compareTo(s.name);
    }
}