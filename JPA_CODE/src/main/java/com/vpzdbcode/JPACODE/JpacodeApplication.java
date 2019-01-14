package com.vpzdbcode.JPACODE;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.vpzdbcode.JPACODE")
@SpringBootApplication
public class JpacodeApplication implements CommandLineRunner
{

	@Autowired
	ConsumerService cs;

	public static void main(String[] args)
	{
		SpringApplication.run(JpacodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Consumer c1 = new Consumer();
		c1.setId(12);
		c1.setFname("vinod");
		c1.setLname("pawar");
		c1.setDate(new Date(2018, 12, 27));
		Consumer c2 = new Consumer();
		c2.setId(124);
		c2.setFname("aryan");
		c2.setLname("pawar");
		c2.setDate(new Date(2018, 12, 14));
		Consumer c3 = new Consumer();
		c3.setId(122);
		c3.setFname("vinod");
		c3.setLname("pawar");
		c3.setDate(new Date(2018, 12, 18));
		Consumer c4 = new Consumer();
		c4.setId(1241);
		c4.setFname("aryan");
		c4.setLname("pawar");
		c4.setDate(new Date(2018, 12, 30));
		cs.addConsumer(c1);
		cs.addConsumer(c2);
		cs.addConsumer(c3);
		cs.addConsumer(c4);
		cs.deleteConsumer(c3);
		List<Consumer> dt = (List<Consumer>) cs.getAllConsumers();
		dt.forEach(t -> System.out.println(t.getFname() + "" + t.getLname()));

		List<Integer> t = new ArrayList<>();
		t.add(12);
		t.add(1241);
		System.out.println("Get details");
		cs.getConsumers(t).forEach(x -> System.out.println(x.toString()));

		System.out.println("-----------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------");
//		List x = cs.getDetails();
//		x.forEach(kx -> System.out.println(kx.toString()));
	}
}
