package autowiringTypeNO;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldService {

	@Autowired
	private HelloWorld hello;

	public void sayHi(String msg) {
		hello.sayHello(msg);
	}
}
