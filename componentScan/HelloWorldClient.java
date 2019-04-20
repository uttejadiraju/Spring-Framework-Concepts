package componentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldClient {

	@Autowired
	private HelloWorld helloImpl;

	public void sayHi() {
		helloImpl.sayHello("hero");
	}
}
