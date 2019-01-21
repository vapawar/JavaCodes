package webs;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionService implements ErrorController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception ex) {
		return ex.getClass() + "::" + ex.getMessage() + "::global handler::controller advice";
	}

	@Override
	@RequestMapping("/error")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String getErrorPath() {
		return "URL not allowed";
	}
}
