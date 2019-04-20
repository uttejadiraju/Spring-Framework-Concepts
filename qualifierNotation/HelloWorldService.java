package qualifierNotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWorldService {

	@Autowired
	@Qualifier("Impl2")
	private HelloWorld hwsByName;

	public void sayHi(String msg) {
		hwsByName.sayHello(msg);
	}
}
