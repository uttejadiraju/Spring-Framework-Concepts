package orderOfBeansInitialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppDependsOn {

	@Bean(name = "a")
	@DependsOn("b")
	public AA a() {
		System.out.println("A initialized");
		return new AA();
	}

	@Bean(name = "b")
	@DependsOn("c")
	public BB b() {
		System.out.println("B initialized");
		return new BB();
	}

	@Bean(name = "c")
	// Avoid this -- @DependsOn("a") (circular dependency!!!)
	public CC c() {
		System.out.println("C initialized");
		return new CC();
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppDependsOn.class);
		acac.close();
	}
}

class AA {

}

class BB {

}

class CC {

}
