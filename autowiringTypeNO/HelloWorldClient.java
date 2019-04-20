package autowiringTypeNO;

public class HelloWorldClient implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println(msg);

	}

}
