package AsyncSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class App {
	
	@Bean 
	public MyBean mPP() {
		return new MyBean();
	}
	
	@Bean 
	public MyBean1 mP1P() {
		return new MyBean1();
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(App.class);
		MyBean b = acac.getBean(MyBean.class);
		b.runTask();
		
		MyBean1 b1 = acac.getBean(MyBean1.class);
		b1.runTask();
	}
}

class MyBean {

	@Async
	public void runTask() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello!!!");
	}
}

class MyBean1 {

	public void runTask() {
		System.out.println("Hello!!! non async");
	}
}