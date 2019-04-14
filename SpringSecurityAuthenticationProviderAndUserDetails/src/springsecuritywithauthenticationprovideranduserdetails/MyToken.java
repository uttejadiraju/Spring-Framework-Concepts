package springsecuritywithauthenticationprovideranduserdetails;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MyToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 922163018222520516L;
	private String pass;

	public MyToken(String pass, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.pass = pass;
	}

	@Override
	public Object getCredentials() {
		return pass;
	}

	@Override
	public Object getPrincipal() {
		return getDetails();
	}

}
