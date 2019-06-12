package p40;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Baz2 {
	Logger logger = LoggerFactory.getLogger(Baz2.class);
	
	public Baz2() {
		logger.info("Baz");
	}
}
