package exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public ResponseEntity<Employee> display1() {
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

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<String> error(UnauthorizedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
