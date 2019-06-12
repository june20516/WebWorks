package p40;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo2 {
	private Bar2 bar2;
	private Baz2 baz2;
	private List valueList;
	
	public void setValueList(List valueList) {
		this.valueList = valueList;
	}

	
	public Foo2 (Bar2 bar2, Baz2 baz2) {
		Logger logger = LoggerFactory.getLogger(Foo2.class);
		this.bar2 = bar2;
		this.baz2 = baz2;
		logger.info("foo");
	}
	
	public Foo2 (Bar2 bar2) {
		Logger logger = LoggerFactory.getLogger(Foo2.class);
		this.bar2 = bar2;
		logger.info("foo");
	}
	
	public void setBar2(Bar2 bar2) {
		this.bar2 = bar2;
	}
	public void setBaz2(Baz2 baz2) {
		this.baz2 = baz2;
	}
	
	
	
	@Override
	public String toString() {
		return "Foo [bar2=" + bar2 + ", baz2=" + baz2 + "]";
	}
}
