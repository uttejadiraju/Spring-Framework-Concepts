package CombinationsWithConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class WithoutConfiguration {

	public void something() {
		System.out.println(System.nanoTime());
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WithoutConfiguration.class);
		System.out.println("Spring container started and is ready");
		WithoutConfiguration bean = context.getBean(WithoutConfiguration.class);
		bean.something();
		bean.something();
	}
}