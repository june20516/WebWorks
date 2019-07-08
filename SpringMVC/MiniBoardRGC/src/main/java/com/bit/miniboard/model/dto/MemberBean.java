package com.bit.miniboard.model.dto;

public class MemberBean {
	private String nickName;
	private String password;
	public String getNickName() {
		return nickName;
	}
	@Override
	public String toString() {
		return "MemberBean [nickName=" + nickName + ", password=" + password + "]";
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
