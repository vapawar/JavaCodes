package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsDemo {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Customer u1 = new Customer(145, "vasu");
        Customer u2 = new Customer(156, "Aryan");
        Customer u3 = new Customer(138, "ganesh");
        Customer u4 = new Customer(432, "test");
        Customer u5 = new Customer(325, "pune");
        Customer u6 = new Customer(422, "gao");
        Customer u7 = new Customer(642, "oracle");
        Customer u8 = new Customer(875, "Java");
        customers.add(u1);
        customers.add(u4);
        customers.add(u7);
        customers.add(u5);
        customers.add(u8);
        customers.add(u3);
        customers.add(u2);
        customers.add(u6);
        System.out.println("Before sort:-");
        customers.forEach(t -> System.out.println(t.orderCode + " : " + t.name));
        Collections.sort(customers, new CustomerComparator());
        System.out.println("After sort:-");
        customers.forEach(t -> System.out.println(t.orderCode + " : " + t.name));
    }
}

class Customer {
    int orderCode;
    String name;

    public Customer(int code, String name) {
        this.orderCode = code;
        this.name = name;
    }
}

class CustomerComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Customer c1 = (Customer) o1;
        Customer c2 = (Customer) o2;
        return c1.name.compareTo(c2.name);
    }
}