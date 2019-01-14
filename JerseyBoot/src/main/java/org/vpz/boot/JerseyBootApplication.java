package org.vpz.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "org.vpz.boot" })
@SpringBootApplication
public class JerseyBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(JerseyBootApplication.class, args);
	}
}
