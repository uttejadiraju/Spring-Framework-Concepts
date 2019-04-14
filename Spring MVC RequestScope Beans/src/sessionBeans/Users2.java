package sessionBeans;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Users2 {
	String time;

	public Users2(String string) {
		this.time = string;
	}

	@RequestMapping(value = "/getRequestScope", method = RequestMethod.GET)
	public String display(Model m) {
		m.addAttribute("msg", time);
		return "hello-world";
	}
}
