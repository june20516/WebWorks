package com.bit.juniornaver.model.vo;

public class FileListBean {
	private int qNo;
	private String filepath;
	private String filedate;
	
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFiledate() {
		return filedate;
	}
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	@Override
	public String toString() {
		return "FileListBean [qNo=" + qNo + ", filepath=" + filepath + ", filedate=" + filedate + "]";
	}
	
	
}
