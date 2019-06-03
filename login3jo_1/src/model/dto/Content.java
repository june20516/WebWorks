package model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Content implements Serializable{

	private static final long serialVersionUID = 1L;

	private int no;
	private int parantNo;
	private String title;
	private String text;
	private Date date;
	private String id;
	private String name;
	
	public Content(int no, int parantNo, String title, String content, Date date, String id, String name) {
		this.no = no;
		this.parantNo = parantNo;
		this.title = title;
		this.text = content;
		this.date = date;
		this.id = id;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	private void setNo(int no) {
		this.no = no;
	}
	public int getParantNo() {
		return parantNo;
	}
	private void setParantNo(int parantNo) {
		this.parantNo = parantNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String content) {
		this.text = content;
	}
	public Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Content [no=" + no + ", parantNo=" + parantNo + ", title=" + title + ", content=" + text + ", date="
				+ date + ", id=" + id + ", name=" + name + "]";
	}
	
}
