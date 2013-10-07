create table Adherent 
(
	identifiant varchar(255) NOT NULL,
	motDePasse varchar(255) NOT NULL, 
	nomDeFamille varchar(255) NOT NULL,
	prenom varchar(255) NOT NULL, 
	rue varchar(255),
	codePostal varchar(255),
	ville varchar(255),
	pays varchar(255),
	PRIMARY KEY (identifiant)
);

create table Article
(
	code varchar(2) NOT NULL,
	nom varchar(12) NOT NULL, 
	prix float NOT NULL,
	stock int NOT NULL, 
	PRIMARY KEY (code)
);

INSERT INTO ARTICLE (code,nom,prix,stock) VALUES ('T1','Tee Shirt',55.6,12);
INSERT INTO ARTICLE (code,nom,prix,stock) VALUES ('C2','Cle USB',9.5,45);
INSERT INTO ARTICLE (code,nom,prix,stock) VALUES ('S3','Stylo',3.7,34);
INSERT INTO ARTICLE (code,nom,prix,stock) VALUES ('C4','Calculatrice',20.0,4);



