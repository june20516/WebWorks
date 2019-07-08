package com.bit.juniver.model.dto;

public class ArticleBean {
	
	private int id;
	private int menu_id;
	private int character_id;
	private String title;
	private int viewCount;
	private String video_path;
	private String thumbnail_path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getCharacter_id() {
		return character_id;
	}
	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getVideo_path() {
		return video_path;
	}
	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}
	public String getThumbnail_path() {
		return thumbnail_path;
	}
	public void setThumbnail_path(String thumbnail_path) {
		this.thumbnail_path = thumbnail_path;
	}
	
	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", menu_id=" + menu_id + ", character_id=" + character_id + ", title=" + title
				+ ", viewCount=" + viewCount + ", video_path=" + video_path + ", thumbnail_path=" + thumbnail_path
				+ "]";
	}
	
	
	
}
