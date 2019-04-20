package orderOfBeansInitialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	@Bean
	public A a() {
		System.out.println("A initialized");
		return new A();
	}

	@Bean
	public B b() {
		System.out.println("B initialized");
		return new B();
	}
	
	@Bean
	public C c() {
		System.out.println("C initialized");
		return new C();
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		acac.close();
	}
}

class A {

}

class B {

}

class C {
	
}
