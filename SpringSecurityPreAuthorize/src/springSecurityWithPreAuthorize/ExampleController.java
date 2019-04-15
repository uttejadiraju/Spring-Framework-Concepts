package springSecurityWithPreAuthorize;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String handleRequest2(ModelMap map) {
		map.addAttribute("time", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return "my-page";
	}

	@RequestMapping("/noAccess")
	public String noAccess(Model model) {
		return "no-access";
	}
}