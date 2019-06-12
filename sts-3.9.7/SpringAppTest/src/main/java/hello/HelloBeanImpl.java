package hello;

public class HelloBeanImpl implements HelloBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name + " !");
	}

}
