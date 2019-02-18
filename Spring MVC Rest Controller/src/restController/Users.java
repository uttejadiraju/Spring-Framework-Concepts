package restController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public @ResponseBody Employee display(Model m) {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return emp;
	}
}
