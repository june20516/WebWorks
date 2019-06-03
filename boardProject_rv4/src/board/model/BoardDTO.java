package board.model;

public class BoardDTO {
	private int num;
	private String id;
	private String title;
	private String content;
	private String name;
	private String writeday;
	int bGroup;
	int bStep;
	int bIndent;
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getbGroup() {
		return bGroup;
	}


	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}


	public int getbStep() {
		return bStep;
	}


	public void setbStep(int bStep) {
		this.bStep = bStep;
	}


	public int getbIndent() {
		return bIndent;
	}


	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}


	public BoardDTO() {}
	
	
	public BoardDTO(int num, String title) {
		this.num = num;
		this.title = title;
	}
	
	
	public BoardDTO(int num, String id, String title, String content, String writeday) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
	}
	public BoardDTO(int num, String id, String title, String content, String writeday, int bGroup, int bStep,
			int bIndent) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}


	@Override
	public String toString() {
		return "DTO [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + ", name=" + name
				+ ", writeday=" + writeday + ", bGroup=" + bGroup + ", bStep=" + bStep + ", bIndent=" + bIndent + "]";
	}

	
	
	
	
}
