package com.bts.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Table(name = "member") //이름이 동일하다면 생략가능
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bit_sq1")
	@SequenceGenerator(sequenceName="bit_sq1", allocationSize=1, name ="bit_sq1")
	private int id;
	private String email;
	private String password;
	@CreationTimestamp
	private Timestamp cdate;
	@UpdateTimestamp
	private Timestamp udate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCdate() {
		return cdate;
	}
	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}
	public Timestamp getUdate() {
		return udate;
	}
	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", cdate=" + cdate + ", udate="
				+ udate + "]";
	}
	
}
