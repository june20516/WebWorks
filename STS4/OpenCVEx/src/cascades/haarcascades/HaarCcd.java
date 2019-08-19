package cascades.haarcascades;

public enum HaarCcd {
	eyeglasses("haarcascade_eye_tree_eyeglasses.xml"),
	eye("haarcascade_eye.xml"),
	frontalCatFaceExtended("haarcascade_frontalcatface_extended.xml"),
	frontalCatFace("haarcascade_frontalcatface.xml"),
	frontalFace("haarcascade_frontalface_alt.xml"),
	frontalFace2("haarcascade_frontalface_alt2.xml"),
	frontalFaceDefault("haarcascade_frontalface_default.xml"),
	fullBody("haarcascade_fullbody.xml"),
	lefteye2Splits("haarcascade_lefteye_2splits.xml"),
	licencePlate("haarcascade_licence_plate_rus_16stages.xml"),
	lowerBody("haarcascade_lowerbody.xml"),
	profileFace("haarcascade_profileface.xml"),
	righteye2Splits("haarcascade_righteye_2splits.xml"),
	russianPlate("haarcascade_russian_plate_number.xml"),
	smile("haarcascade_smile.xml"),
	upperBody("haarcascade_upperbody.xml");
	
	public String cascade;
	
	public static String getCascadeByIndex(int index) {
		return HaarCcd.values()[index].cascade;
	}
	
	private HaarCcd(String cascade) {
		this.cascade = cascade;
	}	
}