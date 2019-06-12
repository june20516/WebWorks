package p40;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bar2 {
	Logger logger = LoggerFactory.getLogger(Bar2.class);
	
	public Bar2() {
		logger.info("bar");
	}
}
