package cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Users {
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String display(@CookieValue(value = "JSESSIONID", defaultValue="not found") String c, Model m) {
		m.addAttribute("msg", "Hey the cookie value is =" + c);
		return "hello-world";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public @ResponseBody String json(HttpServletResponse res) {
//		Cookie my = new Cookie("Uttej", "82");
//		my.setMaxAge(31536000);
//		my.setSecure(true);
//		res.addCookie(my);
		res.addHeader("Set-Cookie", "SID=ererer; Path=/; Secure; HttpOnly");
		
		return "The cookie is set successfully!!!";
	}
}
