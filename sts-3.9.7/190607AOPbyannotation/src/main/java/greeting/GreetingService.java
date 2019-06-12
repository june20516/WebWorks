package greeting;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public interface GreetingService {
	
	void setOutputter(OutputService outputter);
	
	void sayHello(String name);

}
