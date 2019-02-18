package restControllerExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping(value = "/users")
public class Users {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String display(Model m) {
		m.addAttribute("msg", "Hey java config");
		return "hello-world";
	}
}
