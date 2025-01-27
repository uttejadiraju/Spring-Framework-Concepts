package springsecuritywithauthenticationprovideranduserdetails;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
			throws IOException, ServletException {
		arg1.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		arg1.getOutputStream().println("{ \\\"status\\\": \\\"\" + \"fail\" + \"\\\" ,  \"message\": \"Unauthorized\" ,}");

	}

}
