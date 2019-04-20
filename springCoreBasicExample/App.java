package springCoreBasicExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	@Bean
	public HelloWorld helloWorldImpl() {
		return new HelloWorldService();
	}

	@Bean
	public HelloWorldClient helloWorldClient() {
		return new HelloWorldClient();
	}
	
	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		HelloWorldClient hwc = acac.getBean(HelloWorldClient.class);
		hwc.sayHi();
	}
}
