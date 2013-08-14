DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),	
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('admin', 'password', '자바지기', 'admin@javajigi.net');
INSERT INTO USERS VALUES('dohyun0025', '3470mi', '자바지기', 'admin@javajigi.net');

/*
 * *일단 안쓸거임..
 */
DROP TABLE IF EXISTS AUDIT;

CREATE TABLE AUDIT (
	id				INTEGER 		NOT NULL 	IDENTITY 	PRIMARY KEY,
	who				VARCHAR(12)		NOT NULL,
	whenn			DATE,
	resource		VARCHAR(255)	NOT NULL,
	action			VARCHAR(30)		NOT NULL
);
