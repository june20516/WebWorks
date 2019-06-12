package x.y;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Baz {
	Logger logger = LoggerFactory.getLogger(Baz.class);
	
	public Baz() {
		logger.info("Baz");
	}
}
