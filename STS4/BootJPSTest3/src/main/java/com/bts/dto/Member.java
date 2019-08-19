package com.bts.dto;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
@NamedQuery(name="Member.findByPassword", query="select m from Member m where m.password = :password")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bit_sq1")
	@SequenceGenerator(sequenceName = "bit_sq1", allocationSize = 1, name = "bit_sq1")
	private int id;
	private String email;
	private String password;

	@CreationTimestamp
	private Timestamp cdate;
	@UpdateTimestamp
	private Timestamp udate;
}
