package CombinationsWithConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class WithoutConfigurationAndWithBean {

	@Bean()
	public void something() {
		System.out.println(System.nanoTime());
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				WithoutConfigurationAndWithBean.class);
		System.out.println("Spring container started and is ready");
		WithoutConfigurationAndWithBean bean = context.getBean(WithoutConfigurationAndWithBean.class);
		bean.something();
		bean.something();
		context.close();
	}
}