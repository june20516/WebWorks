DROP TABLE MEMBER2 IF EXISTS
DROP TABLE PHONE IF EXISTS
DROP SEQUENCE member2_seq IF EXISTS
DROP SEQUENCE phone_seq IF EXISTS

CREATE TABLE MEMBER2(
	SEQ NUMBER(10),
	NAME VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY(SEQ)
);

CREATE TABLE PHONE(
	SEQ NUMBER(10),
	MEMBER_ID NUMBER(10) NULL DEFAULT NULL,
	NO VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY(SEQ)
);

CREATE SEQUENCE member2_seq
	MINVALUE 1
	MAXVALUE 99999999
	START WITH 1
	INCREMENT BY 1

CREATE SEQUENCE phone_seq
	MINVALUE 1
	MAXVALUE 99999999
	START WITH 1
	INCREMENT BY 1