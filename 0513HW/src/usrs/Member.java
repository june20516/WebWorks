package usrs;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Member {
	String id;
    String name;
    GregorianCalendar birth;
    int age;
    
    public Member(String id, String name, String birth) {
    	this.id = id;
    	this.name = name;
    	
    	//생년월일 입력
    	System.out.println(birth);
    	String[] yMD = birth.split("-");
    	this.birth = new GregorianCalendar(Integer.parseInt(yMD[0]),Integer.parseInt(yMD[1])-1,Integer.parseInt(yMD[2]));

    	//나이 계산, 입력
    	GregorianCalendar today = new GregorianCalendar();
    	this.age = today.get(GregorianCalendar.YEAR)-this.birth.get(GregorianCalendar.YEAR);
    }

	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public GregorianCalendar getBirth() {
		return birth;
	}
	
	public String getBirthByFormat() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		return df.format(birth.getTime());
	}

	public int getAge() {
		return age;
	}
    
}
