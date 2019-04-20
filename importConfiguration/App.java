package importConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ImportConfigurationAnnotation.class)
public class App {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		HelloWorldClient hwc = acac.getBean(HelloWorldClient.class);
		hwc.sayHi();
		acac.close();
	}

}

class HelloWorldClient {

	@Autowired
	private HelloWorld hello;

	public void sayHi() {
		hello.sayHello("hurray!!! Import example");
	}
}
