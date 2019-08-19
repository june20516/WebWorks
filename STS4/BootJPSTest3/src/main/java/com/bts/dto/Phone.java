package com.bts.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "phone")
public class Phone {
	@Id
	@Column(name = "seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Phone_seq")
	private int seq;
	
	@Column(name="member_id")
	private int memberId;
	
	@Column(name="no")
	private String no;

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

	public Phone(String no) {
		this.no = no;
	}
	public Phone() {
		
	}
}
