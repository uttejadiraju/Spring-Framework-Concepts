package springsecuritywithauthenticationprovideranduserdetails;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/VIEWS/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/page").permitAll().anyRequest().authenticated().and().formLogin().and()
				.httpBasic().authenticationEntryPoint(customEntryPoint());
	}

	@Bean
	public AuthenticationEntryPoint customEntryPoint() {
		return new CustomEntryPoint();
	}

	public void configure(AuthenticationManagerBuilder builder) {
		builder.authenticationProvider(customAuthenticationProvider());
	}

	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider();
	}
}
