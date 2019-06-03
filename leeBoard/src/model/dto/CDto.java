package model.dto;
import java.sql.Timestamp;
public class CDto {
	private int cId;
	private String cName;
	private String cContent;
	private Timestamp cDate;
	private int cSuperId;
	private int cGroup;
	private int cStep;
	private int cIndent;
	
	public CDto() {
	}
	
	public CDto(int cId, String cName, String cText, Timestamp cDate, int cSuperId, int cGroup, int cStep,
			int cIndent) {
		this.cId = cId;
		this.cName = cName;
		this.cContent = cText;
		this.cDate = cDate;
		this.cSuperId = cSuperId;
		this.cGroup = cGroup;
		this.cStep = cStep;
		this.cIndent = cIndent;
	}
	
	
	
}
