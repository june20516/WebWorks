package model.dto;

import java.util.ArrayList;
import java.util.List;

public class ContentsDto {
	
	static List<String> header = new ArrayList<String>();
	static List<Object[]> contents = new ArrayList<Object[]>();
	
	private ContentsDto() {
		
	}
	
//	private ContentsDto(ArrayList<String> header) {
//		ContentsDto.header = header;
//	}

//	private ContentsDto(ArrayList<String> header, ArrayList<Object[]> contents) {		
//	}

	public static void setHeader(ArrayList<String> headData) {
		if (headData != null) {
			header = headData;			
		}		
	}
	
	public static void setContents(ArrayList<Object[]> contData) {
		if (contData != null) {
			contents = contData;			
		}
	}

	public static List<String> getHeader() {
		return header;
	}

	public static List<Object[]> getContents() {
		return contents;
	}

	
	


}
