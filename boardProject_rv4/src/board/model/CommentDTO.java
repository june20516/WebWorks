package board.model;

public class CommentDTO {
	 private int  num; 
	 private String id ; 
	 private String cContent;  
	 private int cGroup ;
	 private int cStep ;
	 private int cIndent;
	 private int boardNo ;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public int getcStep() {
		return cStep;
	}
	public void setcStep(int cStep) {
		this.cStep = cStep;
	}
	public int getcIndent() {
		return cIndent;
	}
	public void setcIndent(int cIndent) {
		this.cIndent = cIndent;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "CommentDTO [num=" + num + ", id=" + id + ", cContent=" + cContent + ", cGroup=" + cGroup + ", cStep="
				+ cStep + ", cIndent=" + cIndent + ", boardNo=" + boardNo + "]";
	}
	public CommentDTO() {
	
	}
	public CommentDTO(int num, String id, String cContent, int cGroup, int cStep, int cIndent, int boardNo) {
		super();
		this.num = num;
		this.id = id;
		this.cContent = cContent;
		this.cGroup = cGroup;
		this.cStep = cStep;
		this.cIndent = cIndent;
		this.boardNo = boardNo;
	}
	public CommentDTO(int num, String id, String cContent, int boardNo) {
		super();
		this.num = num;
		this.id = id;
		this.cContent = cContent;
		this.boardNo = boardNo;
	}
	public CommentDTO(int num, String id, String cContent) {
		super();
		this.num = num;
		this.id = id;
		this.cContent = cContent;
	
	}
	 
}
