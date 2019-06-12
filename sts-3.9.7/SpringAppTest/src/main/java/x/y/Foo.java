package x.y;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
	private Bar bar;
	private Baz baz;

	
	public Foo (Bar bar, Baz baz) {
		Logger logger = LoggerFactory.getLogger(Foo.class);
		this.bar = bar;
		this.baz = baz;
		logger.info("foo");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
	
	
	@Override
	public String toString() {
		return "Foo [bar=" + bar + ", baz=" + baz + "]";
	}
}
