create table MEMBER (
	ID number primary key,
	EMAIL varchar(255) unique,
	PASSWORD varchar(100),
	NAME varchar(100),
	REGDATE date
);
	
	
/*****************************************
시퀀스 생성 
******************************************/

CREATE SEQUENCE MEMBER_ID_SEQ
	START WITH 1
	INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRI_MEMBER_ID_SEQ
BEFORE INSERT ON member
FOR EACH ROW 
BEGIN 
	IF Inserting AND :NEW.id IS NULL THEN 
		SELECT MEMBER_ID_SEQ.NEXTVAL INTO :NEW.id FROM DUAL;
	END IF;
END; 

