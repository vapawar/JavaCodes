package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRunnerCode {

	@RequestMapping("/test")
	@GetMapping("/test")
	public String getData() {
		return "from code..........";
	}
}

@Component
class RequestChecker implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		System.out.println("Request filter: char encoding: " + request.getCharacterEncoding()+"  method :"+req.getMethod());
		chain.doFilter(request, response);
	}
}

@Component
class Demos implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("one time runner code...............");
	}
}
