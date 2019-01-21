package com.vpz.hbm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHbmApplication implements CommandLineRunner
{

	@Autowired
	PlayerService service;

	public static void main(String[] args)
	{
		SpringApplication.run(JpaHbmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Player p1 = new Player();
		p1.setId(123222222);
		p1.setName("vinod1111111111111");
		p1.setSurname("pawar");
		p1.setScore(98);

		Player p2 = new Player();
		p2.setId(23411111);
		p2.setName("aryan11111111111111");
		p2.setSurname("pawar");
		p2.setScore(102);

		Player p3 = new Player();
		p3.setId(234);
		p3.setName("jay");
		p3.setSurname("pawar");
		p3.setScore(158);

		service.createPlayer(p1);
		service.createPlayer(p2);
		service.createPlayer(p3);
		service.deleteOne(123);
		service.getPlayers();
	}
}
