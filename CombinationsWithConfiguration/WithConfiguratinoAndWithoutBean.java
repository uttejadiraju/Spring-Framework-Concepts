package CombinationsWithConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WithConfiguratinoAndWithoutBean {

	public void something() {
		System.out.println(System.nanoTime());
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				WithConfiguratinoAndWithoutBean.class);
		System.out.println("Spring container started and is ready");
		WithConfiguratinoAndWithoutBean bean = context.getBean(WithConfiguratinoAndWithoutBean.class);
		bean.something();
		bean.something();
		context.close();
	}
}