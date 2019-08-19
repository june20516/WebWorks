package firstest;

import java.io.File;

import cascades.haarcascades.HaarCcd;

public class Test {
	static File f = new File("./resource/styles");
	static File fw = new File("./resource/widevision");

	public static void main(String[] args) {
		//사람이 크게 나온 인물 사진
		File[] images = f.listFiles();
		//사람이 작게나온 넓은 공간 사진
		File[] wideImages = fw.listFiles();
		
		//한 사진에 모든 캐스캐이드 적용해보기
		for(int ccdCount = 0; ccdCount < HaarCcd.values().length; ccdCount++) {
		PhotoScanner.findElement(HaarCcd.getCascadeByIndex(ccdCount),images[0].getPath());
		}
		
		//여러 사진에 사람찾는 캐스캐이드 적용해보기
		for (File image:images) {
			PhotoScanner.findElement(HaarCcd.fullBody.cascade, image.getPath());
			PhotoScanner.findElement(HaarCcd.lowerBody.cascade, image.getPath());
			PhotoScanner.findElement(HaarCcd.upperBody.cascade, image.getPath());
		}
		for (File image:wideImages) {
			
			PhotoScanner.findElement(HaarCcd.fullBody.cascade, image.getPath());
			PhotoScanner.findElement(HaarCcd.lowerBody.cascade, image.getPath());
			PhotoScanner.findElement(HaarCcd.upperBody.cascade, image.getPath());
		}
		
	}
}
