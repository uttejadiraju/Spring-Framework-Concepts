package springsecuritywithhttpsecurity;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("uttej").password("123").roles("ADMIN").and().withUser("manoj")
				.password("456").roles("USER");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/VIEWS/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/page").permitAll().anyRequest().authenticated().and().formLogin();
	}
}
