package responseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ResponseEntity<Employee> display() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return ResponseEntity.ok(emp);
	}
	
	@RequestMapping(value = "/bad", method = RequestMethod.GET)
	public ResponseEntity<Employee> display2() {
		Employee emp = new Employee();
		emp.setId(55);
		emp.setName("hero");
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
