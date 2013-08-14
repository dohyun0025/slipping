DROP TABLE IF EXISTS REPLYS;
	
CREATE TABLE REPLYS (
	id				INTEGER 		NOT NULL 	IDENTITY 	PRIMARY KEY,
	index			INTEGER	,
	reply			VARCHAR(500),
	time		VARCHAR(30)	NOT NULL,
	owner			VARCHAR(30)		NOT NULL
);
INSERT INTO REPLYS VALUES(1,1,'1번내용내용 ',now(),'admin');
INSERT INTO REPLYS VALUES(2,2,'2번내용내용 ',now(),'dohyun0025');
INSERT INTO REPLYS VALUES(3,3,'3번내용내용 ',now(),'admin');

INSERT INTO REPLYS VALUES(4,1,'1번내용내용 ',now(),'admin');
INSERT INTO REPLYS VALUES(5,1,'2번내용내용 ',now(),'admin');
INSERT INTO REPLYS VALUES(6,1,'3번내용내용 ',now(),'admin');

INSERT INTO REPLYS VALUES(7,1,'1번내용내용 ',now(),'dohyun0025');
INSERT INTO REPLYS VALUES(8,2,'2번내용내용 ',now(),'dohyun0025');
INSERT INTO REPLYS VALUES(9,3,'3번내용내용 ',now(),'dohyun0025');

INSERT INTO REPLYS VALUES(10,3,'1번내용내용 ',now(),'dohyun0025');
INSERT INTO REPLYS VALUES(11,3,'2번내용내용 ',now(),'dohyun0025');
INSERT INTO REPLYS VALUES(12,3,'3번내용내용 ',now(),'dohyun0025');