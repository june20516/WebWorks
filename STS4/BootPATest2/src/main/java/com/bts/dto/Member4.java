package com.bts.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "member2")
public class Member4 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member2_seq")
	@SequenceGenerator(sequenceName = "member2_seq", allocationSize = 1, name = "member2_seq")
	
	@Column(name="seq")
	private int seq;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
	@JoinColumn(name="member_id")
	private Collection<Phone> phone = new ArrayList<Phone>();

	public Member4() {
		// TODO Auto-generated constructor stub
	}

	public Member4(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
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
		return "Member4 [seq=" + seq + ", name=" + name + ", phone=" + phone + "]";
	}

	public void addPhone(Phone no) {
		// TODO Auto-generated method stub
		phone.add(no);
		
	}
	
	
}
