package sessionBeans;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebConfig {
	@Bean
	@Scope(WebApplicationContext.SCOPE_SESSION)
	public Users1 get() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		return new Users1(formatter.format(date));
	}
	
	@Bean
	public Users5 get4() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		return new Users5(formatter.format(date));
	}

	@Bean
	@Scope(WebApplicationContext.SCOPE_REQUEST)
	public Users2 get1() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		return new Users2(formatter.format(date));
	}
	
	@Bean
	@Scope(WebApplicationContext.SCOPE_APPLICATION)
	public Users3 get2() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		return new Users3(formatter.format(date));
	}
	
	@Bean
	@Scope(WebApplicationContext.SCOPE_GLOBAL_SESSION)
	public Users4 get3() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		return new Users4(formatter.format(date));
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/VIEWS/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
