package importConfiguration;

public class HelloWorldService implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println("Hello---" + msg);

	}

}
