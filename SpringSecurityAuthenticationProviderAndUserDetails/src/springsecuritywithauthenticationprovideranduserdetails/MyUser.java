package springsecuritywithauthenticationprovideranduserdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {

	private static final long serialVersionUID = -3172169723476925345L;

	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

}
