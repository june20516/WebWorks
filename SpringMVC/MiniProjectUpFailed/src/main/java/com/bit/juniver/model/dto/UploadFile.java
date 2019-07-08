package com.bit.juniver.model.dto;

import java.util.Date;


public class UploadFile {

    int id;
    String fileName;
    String saveFileName;
    String filePath;
    String contentType;
    long size;
    Date regDate;
	public int getId() {
		return id;
	}
	public String getFileName() {
		return fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public String getContentType() {
		return contentType;
	}
	public long getSize() {
		return size;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "UploadFile [id=" + id + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", filePath="
				+ filePath + ", contentType=" + contentType + ", size=" + size + ", regDate=" + regDate + "]";
	}
    
    
}