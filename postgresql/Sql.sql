/* TABLES*/

CREATE TABLE public.student (
	id numeric NOT null ,
	personalid numeric NOT NULL,
	lastname varchar(100) NOT NULL,
	firstname varchar(100) NOT NULL,
	secondname varchar(100),
	carreer varchar(100) NOT NULL,
	borndate date NOT NULL,
	userid varchar(100) NOT NULL,
	"password" varchar(100) NOT NULL,
	mail varchar(100) NOT NULL,
	createdat date,

           
	CONSTRAINT student_pk PRIMARY KEY (id),
	CONSTRAINT "mail_UK" UNIQUE (mail),
	CONSTRAINT "personalId_UK" UNIQUE (personalid)
);



