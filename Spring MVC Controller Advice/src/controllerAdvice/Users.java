package controllerAdvice;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public String display1() throws UnauthorizedException {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		throw new UnauthorizedException("You are unauthorized!!!");
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ResponseEntity<Employee> display() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return ResponseEntity.ok(emp);
	}

	@RequestMapping(value = "/throw", method = RequestMethod.GET)
	public ResponseEntity<Employee> excep() throws Exception {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		System.out.println(10/0);
		throw new Exception("divide by zero!!!");
	}

}
