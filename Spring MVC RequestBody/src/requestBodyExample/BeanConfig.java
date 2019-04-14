package requestBodyExample;

import org.springframework.context.annotation.Bean;

public class BeanConfig {
	@Bean
	public Users users() {
		return new Users();
	}
}
