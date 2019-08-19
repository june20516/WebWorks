package com.bts.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

//@Data
@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_seq")
	@SequenceGenerator(sequenceName="phone_seq", allocationSize=1, name ="phone_seq")
	@Column(name="seq")
	private int seq;
	@Column(name = "member_id")
	private int memberId;
	private String no;
	
	public Phone() { }
	public Phone(String no) {
		this.no = no;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Phone [seq=" + seq + ", memberId=" + memberId + ", no=" + no + "]";
	}
}
