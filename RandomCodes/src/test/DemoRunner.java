package test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("test")
@SpringBootApplication
public class DemoRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoRunner.class, args);
	}
}
