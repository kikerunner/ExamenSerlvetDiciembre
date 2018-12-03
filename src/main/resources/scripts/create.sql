/*DROP TABLE PERSONAS;*/

create table IF NOT EXISTS PERSONAS(
	codPersona INT IDENTITY,
	nombre varchar(25) NOT NULL,
	apellido varchar(25) NOT NULL,
	nomMascota varchar(25), 
);

create table IF NOT EXISTS MASCOTAS(
	nomMascota varchar(25) PRIMARY KEY,
	codPersona int,
);

ALTER TABLE MASCOTAS
	ADD FOREIGN KEY (codPersona)
	REFERENCES PERSONAS(codPersona)
