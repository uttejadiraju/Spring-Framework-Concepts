package controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> genericException(Exception e) {
		return new ResponseEntity<String>("Triggered exception class" + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UnauthorizedException.class)
	public @ResponseBody ResponseEntity<String> unauthorizedException(UnauthorizedException e) {
		return new ResponseEntity<String>("Triggered unauthorized exception class" + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	
}
