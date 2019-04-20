package springCoreBasicExample;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldClient {

	@Autowired
	private HelloWorld hello;

	public void sayHi() {
		hello.sayHello("hurray!!! First example");
	}
}
