package primaryAnnotation;

public class HelloWorldClientB implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println("Impl B " +msg);

	}

}
