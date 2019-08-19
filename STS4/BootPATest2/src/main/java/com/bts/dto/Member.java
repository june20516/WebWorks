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
@Data
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bit_sq1")
	@SequenceGenerator(sequenceName = "bit_sq1", allocationSize = 1, name = "bit_sq1")
	private int id;
	private String email;
	private String password;

	@CreationTimestamp // 데이터를 insert해줄때 자동으로 시간을 입력
	private Timestamp cdate;

	@UpdateTimestamp // update해줄때 자동으로 시간을 입력
	private Timestamp udate;
}
