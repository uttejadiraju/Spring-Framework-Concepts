package helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class BeanInit {
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix("/WEB-INF/VIEWS/");
		v.setSuffix(".jsp");
		return v;
	}
}
