package test;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		try {
			Date d = Date.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		System.out.println(date.getMonth());
		System.out.println("¸Â³ª?");
		
	}

}
