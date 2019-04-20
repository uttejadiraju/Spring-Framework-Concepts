package componentScan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("componentScan")
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		HelloWorldClient hwc = context.getBean(HelloWorldClient.class);
		hwc.sayHi();
		System.out.println(hwc.hashCode());
		context.close();
	}
}
