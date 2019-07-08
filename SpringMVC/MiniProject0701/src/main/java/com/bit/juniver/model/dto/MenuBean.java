package com.bit.juniver.model.dto;

public class MenuBean {
	private int id = 1;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "MenuBean [id=" + id + ", title=" + title + "]";
	}
	
	
}
