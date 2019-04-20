package importConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportConfigurationAnnotation {
	@Bean
	public HelloWorld helloWorldImpl() {
		return new HelloWorldService();
	}

	@Bean
	public HelloWorldClient helloWorldClient() {
		return new HelloWorldClient();
	}
}
