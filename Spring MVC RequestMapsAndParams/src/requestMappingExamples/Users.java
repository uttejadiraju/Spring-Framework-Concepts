package requestMappingExamples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class Users {
	@RequestMapping(value = "/users/hello", method = RequestMethod.GET)
	public String display(Model m) {
		m.addAttribute("msg", "Hey java config");
		return "hello-world";
	}
	
	@RequestMapping(value = "/users/employee", method = RequestMethod.GET)
	public String display(@RequestParam(required = true, value = "dept") String dept, Model m) {
		m.addAttribute("msg", new String("Hey employee " + dept));
		return "hello-world";
	}
	
	@RequestMapping(value = "/users/employee/{id}", method = RequestMethod.GET)
	public String pathVariable(@PathVariable("id") String dept, Model m) {
		m.addAttribute("msg", new String("Hey employee " + dept));
		return "hello-world";
	}
	
	@RequestMapping(value = "/users/employees", method = RequestMethod.GET)
	public @ResponseBody String json() {
		return "{ \"username\" : \"joe\" }";
	}
}
