package model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentsDto {
	
	private static final List<String> header;
	private static HashMap<String,Content> contents;
	
	/* DB 구조
	NO NUMBER PRIMARY KEY,
    PARENT_NO NUMBER DEFAULT 0,
    TITLE VARCHAR2(400),
    CONTENT VARCHAR2(2000),
    REG_DATE DATE NOT NULL,
    ID VARCHAR2(20) ,
    CONSTRAINT BOARD_FK FOREIGN KEY (ID) REFERENCES LOGIN(ID)
    );
	 */
	static {
		contents = new HashMap<String,Content>();
		header = new ArrayList<String>();
		header.add("No");
		header.add("제 목");
		header.add("작성날짜");
		header.add("글쓴이");

	}
	
	
	public static void setContents(HashMap<String,Content> contData) {
		if (contData != null) {
			contents = contData;
		}
	}

	public static List<String> getHeader() {
		return header;
	}

	public static HashMap<String,Content> getContents() {
		return contents;
	}

	
	


}
