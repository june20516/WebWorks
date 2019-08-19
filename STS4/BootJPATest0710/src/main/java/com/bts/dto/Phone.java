package com.bts.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Phone_seq")
	@SequenceGenerator(sequenceName = "Phone_seq",
	allocationSize = 1, name = "Phone_seq")
	@Column(name="seq")
	private  int seq;
	@Column(name="member_id")
	private  int member_id;
	@Column(name="no")
	private String no;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public Phone() {
		
	}
	
	public Phone(String no) {
		super();
		this.no = no;
	}
	@Override
	public String toString() {
		return "Phone [seq=" + seq + ", member_id=" + member_id + ", no=" + no + "]";
	}
	
	

}