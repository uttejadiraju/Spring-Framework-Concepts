package controllerAdvice;

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String s) {
		super(s);
	}
}
