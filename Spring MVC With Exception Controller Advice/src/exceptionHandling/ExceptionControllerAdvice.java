package exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionControllerAdvice {
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<String> error(UnauthorizedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
