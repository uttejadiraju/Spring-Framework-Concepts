package restController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonValue;

public class JSonWrapper {
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private Object data;
	private String message = "";

	public enum Status {
		SUCCESS, FAIL, ERROR;

		@JsonValue
		public String toJson() {
			return name().toLowerCase();
		}
	}

	private Status status;

	public JSonWrapper(Object data) {
		this.data = data;
		status = Status.SUCCESS;
	}

	public JSonWrapper(String message, int code) {
		this.message = message;
		status = code < 500 ? Status.FAIL : Status.ERROR;
	}

	public JSonWrapper(String message, int code, Object data) {
		this.message = message;
		status = code < 500 ? Status.FAIL : Status.ERROR;
		this.data = data;
	}

	public static ResponseEntity<JSonWrapper> ok(Object data) {
		return ok(data, (HttpHeaders) null);
	}

	public static ResponseEntity<JSonWrapper> ok(Object data, HttpHeaders headers) {
		return ok(data, headers, data != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
	}

	public static ResponseEntity<JSonWrapper> ok(Object data, HttpStatus statusCode) {
		return ok(data, null, statusCode);
	}

	public static ResponseEntity<JSonWrapper> ok(Object data, HttpHeaders headers, HttpStatus statusCode) {
		return new ResponseEntity<JSonWrapper>(new JSonWrapper(data), headers, statusCode);
	}

	public static ResponseEntity<JSonWrapper> error(String message, HttpStatus statusCode) {
		return new ResponseEntity<JSonWrapper>(new JSonWrapper(message, statusCode.value()), statusCode);
	}

	public static ResponseEntity<JSonWrapper> error(String message, HttpStatus statusCode, Object data) {
		return new ResponseEntity<JSonWrapper>(new JSonWrapper(message, statusCode.value(), data), statusCode);
	}
}
