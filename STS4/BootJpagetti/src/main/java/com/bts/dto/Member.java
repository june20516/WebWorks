package com.bts.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MEMBER")
	private int id;
	
	private @Column String email;
	private @Column String password;

	@CreationTimestamp
	private @Column Timestamp cdate;
	@UpdateTimestamp
	private @Column Timestamp udate;
}
