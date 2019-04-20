package primaryAnnotation;

public class HelloWorldService {
	private HelloWorld hellos;

	public void sayHi(String msg) {
		hellos.sayHello(msg);
	}

	public HelloWorld getHello() {
		return hellos;
	}

	public void setHello(HelloWorld hello) {
		this.hellos = hello;
	}
}
