package restController;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ResponseEntity<JSonWrapper> display3() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return JSonWrapper.ok(emp);
	}

	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public ResponseEntity<JSonWrapper> display1() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return JSonWrapper.error("Unauthorized!!!", HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/bad", method = RequestMethod.GET)
	public ResponseEntity<JSonWrapper> display2() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return JSonWrapper.error("Bad request!!!", HttpStatus.BAD_REQUEST);
	}
}
