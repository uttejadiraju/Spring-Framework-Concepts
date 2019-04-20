package beanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext apc = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Person p = apc.getBean(Person.class);
		
	}
}
