package beanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {
	{
		System.out.println("Inside the non static block");
	}

	@Bean
	public Person person() {
		return new Person();
	}
}
