package greeting;



public interface GreetingService {
	
	void setOutputter(OutputService outputter);
	
	void sayHello(String name);

}
