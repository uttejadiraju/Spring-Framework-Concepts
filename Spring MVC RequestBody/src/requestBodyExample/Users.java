package requestBodyExample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public ResponseEntity<Employee> display1(@RequestBody Employee e) {
		Employee emp = new Employee();
		emp.setId(e.getId());
		emp.setName(e.getName());
		return new ResponseEntity<Employee>(HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ResponseEntity<Employee> display(@RequestBody Employee e) {
		Employee emp = new Employee();
		emp.setId(e.getId());
		emp.setName("hero");
		return ResponseEntity.ok(emp);
	}

	@RequestMapping(value = "/bad", method = RequestMethod.GET)
	public ResponseEntity<Employee> display2(@RequestBody Employee e) {
		Employee emp = new Employee();
		emp.setId(e.getId());
		emp.setName(e.getName());
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
}
