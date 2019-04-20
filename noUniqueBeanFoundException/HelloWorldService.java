package noUniqueBeanFoundException;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldService {

	@Autowired
	private HelloWorld hwsByName;

	public void sayHi(String msg) {
		hwsByName.sayHello(msg);
	}
}
