package com.bit.samp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Hello {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "hello_seq" ,allocationSize=1,name="CUST_SEQ")
	private int id;
	private String name;
}
