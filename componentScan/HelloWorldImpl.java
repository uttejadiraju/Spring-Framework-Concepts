package componentScan;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello(String name) {
		System.out.println(name);

	}

}
