package qualifierNotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	@Bean(name = "Impl1")
	public HelloWorld helloWorldImpl1() {
		return new HelloWorldClient();
	}

	@Bean(name = "Impl2")
	public HelloWorld helloWorldImpl2() {
		return new HelloWorldClientAnother();
	}

	@Bean
	public HelloWorldService hwsByName() {
		return new HelloWorldService();
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		HelloWorldService hWS = acac.getBean(HelloWorldService.class);
		hWS.sayHi("hero!!! hurray");
		acac.close();
	}
}
