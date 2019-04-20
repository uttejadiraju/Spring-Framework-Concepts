package primaryAnnotation;

public class HelloWorldClientA implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println("Impl A " +msg);

	}

}
