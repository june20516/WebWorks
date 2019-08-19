package firstest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import cascades.haarcascades.HaarCcd;
import cascades.lbpcascades.LbpCcd;

public class PhotoScanner {
	

	public static void findElement(String ccd, String imgPath) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("\nRunning FaceDetector");
		
		CascadeClassifier faceDetector = new CascadeClassifier(
				HaarCcd.class.getResource(ccd).getPath());
//				FaceDetector.class.getResource("../cascades/haarcascades/haarcascade_frontalface_alt.xml").getPath());
		System.out.println("\nFaceDetector Loaded");
		
		Mat image = Imgcodecs.imread(imgPath);
		
//		Mat image = Imgcodecs.imread(FaceDetector.class.getResource("sungtae.jpeg").getPath());
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);
		System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0),3);
		}
		String filename = imgPath.substring(imgPath.lastIndexOf("/")+1,imgPath.lastIndexOf("."))+"_ouput.png";
		boolean result = Imgcodecs.imwrite("./"+ccd.substring(0,ccd.lastIndexOf("."))+"/"+filename, image);
		System.out.println(String.format("Writing %s : %b", filename, result));
	}

}
