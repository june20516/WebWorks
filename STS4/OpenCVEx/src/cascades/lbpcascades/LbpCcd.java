package cascades.lbpcascades;

public enum LbpCcd {
	frontalcatface("lbpcascade_frontalcatface.xml"),
	frontalfaceImproved("lbpcascade_frontalface_improved.xml"),
	frontalface("lbpcascade_frontalface.xm"),
	profileface("lbpcascade_profileface.xm"),
	silverware("lbpcascade_silverware.xml");
	
	public String cascade;
	
	public static String getCascadeByIndex(int index) {
		return LbpCcd.values()[index].cascade;
	}
	
	private LbpCcd(String cascade) {
		this.cascade = cascade;
	}	
}