package valueanootation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@Value("${app.title}")
	private String title;

	@RequestMapping("/hello")
	@ResponseBody
	public String helloHandler() {
		return "Hello World!!!" + "retrieved title from application properties" + title;
	}
}