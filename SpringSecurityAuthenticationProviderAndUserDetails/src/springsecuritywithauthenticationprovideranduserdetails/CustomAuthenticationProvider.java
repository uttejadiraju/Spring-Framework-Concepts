package springsecuritywithauthenticationprovideranduserdetails;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static List<User> users = new ArrayList<User>();

	public CustomAuthenticationProvider() {
		users.add(new User("erin", "123", "ROLE_ADMIN"));
		users.add(new User("mike", "234", "ROLE_ADMIN"));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		Object credentials = authentication.getCredentials();
		System.out.println("credentials class: " + credentials.getClass());
		if (!(credentials instanceof String)) {
			return null;
		}
		String password = credentials.toString();

		Optional<User> userOptional = users.stream().filter(u -> u.match(name, password)).findFirst();

		if (!userOptional.isPresent()) {
			throw new BadCredentialsException("Authentication failed for " + name);
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().role));
		MyToken token = new MyToken(password, grantedAuthorities);
		MyUser userDetails = new MyUser(name, password, grantedAuthorities);
		token.setDetails(userDetails);
		token.setAuthenticated(true);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	private static class User {
        private String name;
        private String password;
        private String role;

        public User(String name, String password, String role) {
            this.name = name;
            this.password = password;
            this.role = role;
        }

        public boolean match(String name, String password) {
            return this.name.equals(name) && this.password.equals(password);
        }

	}
	
}
