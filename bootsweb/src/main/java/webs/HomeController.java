package webs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	@Qualifier("test")
	ParamsBean test;

	@Autowired
	MessageBean bean;

	@RequestMapping("/t1")
	public String getBean() {
		return "Hello MVC" + bean.toString() + ":: autowired bean ";
	}

	@RequestMapping("/t2")
	public String getMessage() {
		return "Hello MVC" + test.toString() + ":: bean from @config";
	}

	@RequestMapping("/t3")
	public String show() {
		throw new RuntimeException("Random Exception");
	}

	@RequestMapping("/t4")
	public String errorMessage() throws Exception {
		throw new Exception("Fatal exception");
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String error(RuntimeException ex) {
		return ex.getClass() + "::" + ex.getMessage() + "::::" + "Local handler";
	}
}
