package com.bts.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "member2")
public class Member2 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member2_seq")
	@SequenceGenerator(sequenceName="member2_seq", allocationSize = 1, name ="member2_seq")
	private int seq;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	private Collection<Phone> phone;

	public Member2() { }

	public Member2(String name) {
		this.name = name;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Phone> getPhone() {
		return phone;
	}
	public void setPhone(Collection<Phone> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member2 [seq=" + seq + ", name=" + name + ", phone=" + phone + "]";
	}

	public void addPhone(Phone no) {
		if(phone == null) {
			phone = new ArrayList<Phone>();
		}
		phone.add(no);
	}
	
	
}
