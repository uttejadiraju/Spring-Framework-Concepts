package CircularDependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		acac.close();
	}

	@Bean
	public BeanB b() {
		return new BeanB(a());
	}

	@Bean
	public BeanA a() {
		return new BeanA(b());
	}

}

class BeanA {
	private final BeanB beanB;

	public BeanA(BeanB b) {
		this.beanB = b;
	}
}

class BeanB {
	private final BeanA beanA;

	public BeanB(BeanA beanA) {
		this.beanA = beanA;
	}
}