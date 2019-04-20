package primaryAnnotation;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class App {

	@Bean
	public HelloWorld helloWorldImpl1() {
		return new HelloWorldClientA();
	}

	@Bean
	@Primary
	public HelloWorld helloWorldImpl2() {
		return new HelloWorldClientB();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HelloWorldService hws() {
		return new HelloWorldService();
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		HelloWorldService hWS = acac.getBean(HelloWorldService.class);
		hWS.sayHi("hero!!! hurray");
		acac.close();
	}
}
