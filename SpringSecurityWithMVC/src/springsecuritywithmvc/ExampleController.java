package springsecuritywithmvc;

import org.springframework.security.core.context.SecurityContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	private static Log log = LogFactory.getLog(ExampleController.class);
	@RequestMapping("/app")
	@ResponseBody
	public String handleRequest() {
		return "welcome to the app";
	}

	@RequestMapping("/page")
	public String handleRequest2(ModelMap map) {
		log.info("doing something");
		map.addAttribute("time", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return "my-page";
	}
}