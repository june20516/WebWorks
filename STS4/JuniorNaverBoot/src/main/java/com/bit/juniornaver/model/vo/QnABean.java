package com.bit.juniornaver.model.vo;

import java.sql.Date;

public class QnABean {
	private int qNo;
	private String member_id;
	private String qTitle;
	private String qContents;
	private String qAttachments;
	private String email;
	private Date qDate;
	
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContents() {
		return qContents;
	}
	public void setqContents(String qContents) {
		this.qContents = qContents;
	}
	public String getqAttachments() {
		return qAttachments;
	}
	public void setqAttachments(String qAttachments) {
		this.qAttachments = qAttachments;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getqDate() {
		return qDate;
	}
	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}
	@Override
	public String toString() {
		return "QnABean [qNo=" + qNo + ", writer=" + member_id + ", qTitle=" + qTitle + ", qContents=" + qContents
				+ ", qAttachments=" + qAttachments + ", email=" + email + ", qDate=" + qDate + "]";
	}
	
	
}
