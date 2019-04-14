package springsecuritywithauthenticationprovider;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	@RequestMapping("/app")
	@ResponseBody
	public String handleRequest() {
		return "welcome to the app";
	}

	@RequestMapping("/page")
	public String handleRequest2(ModelMap map) {
		map.addAttribute("time", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return "my-page";
	}
}