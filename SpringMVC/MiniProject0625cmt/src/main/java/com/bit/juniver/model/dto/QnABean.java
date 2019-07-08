package com.bit.juniver.model.dto;

public class QnABean {
	
	private int qNo;
	private String email;
	private String qTitle;
	private String qContents;
	private String qAttachments;
	public int getQNo() {
		return qNo;
	}
	public String getEmail() {
		return email;
	}
	public String getqTitle() {
		return qTitle;
	}
	public String getqContents() {
		return qContents;
	}
	public String getqAttachments() {
		return qAttachments;
	}
	public void setQNo(int qNo) {
		this.qNo = qNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public void setqContents(String qContents) {
		this.qContents = qContents;
	}
	public void setqAttachments(String qAttachments) {
		this.qAttachments = qAttachments;
	}
	@Override
	public String toString() {
		return "QnABean [qNo=" + qNo + ", email=" + email + ", qTitle=" + qTitle + ", qContents=" + qContents
				+ ", qAttachments=" + qAttachments + "]";
	}
	
	
	
	
}
