package webs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController2 {
	@RequestMapping("/tx")
	@ResponseBody
	public String show() {
		return "user" + "vpawar";
	}
}
