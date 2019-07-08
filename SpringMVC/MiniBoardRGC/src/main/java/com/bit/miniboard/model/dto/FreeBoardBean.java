package com.bit.miniboard.model.dto;

import java.sql.Date;

public class FreeBoardBean {
	private int boardNo;
	private String nickName;
	private String title;
	private Date time;
	private String content;
	private int viewCount;
	private int likes;
	private int dislikes;
	private int comments;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public String getNickName() {
		return nickName;
	}
	public String getTitle() {
		return title;
	}
	public Date getTime() {
		return time;
	}
	public String getContent() {
		return content;
	}
	public int getViewCount() {
		return viewCount;
	}
	
	public int getComments() {
		return comments;
	}
	public int getLikes() {
		return likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public void setComments(int comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "FreeBoardBean [boardNo=" + boardNo + ", nickName=" + nickName + ", title=" + title + ", time=" + time
				+ ", content=" + content + ", viewCount=" + viewCount + ", likes=" + likes + ", dislikes=" + dislikes
				+ ", comments=" + comments + "]";
	}
	
	
	
}
