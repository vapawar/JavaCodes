package webs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("webs")
@SpringBootApplication
public class BootsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootsApplication.class, args);
	}
}
