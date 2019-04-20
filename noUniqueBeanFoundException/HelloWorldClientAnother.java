package noUniqueBeanFoundException;

public class HelloWorldClientAnother implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println(msg);

	}

}
