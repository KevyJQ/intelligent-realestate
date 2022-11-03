DROP DATABASE intelligent_realestate;
CREATE DATABASE intelligent_realestate;

USE intelligent_realestate;

CREATE TABLE arrendador(
id_arrendador INTEGER NOT NULL AUTO_INCREMENT,
nombre1 VARCHAR(100) NOT NULL,
nombre2 VARCHAR(100) NOT NULL,
apellido_paterno VARCHAR(100) NOT NULL,
apellido_materno VARCHAR(100) NOT NULL,
edad INTEGER NOT NULL,
correo VARCHAR(50) NOT NULL,
celular VARCHAR(50) NOT NULL,
direccion1 VARCHAR(100) NOT NULL,
direccion2 VARCHAR(100) NOT NULL,
pais VARCHAR(100) NOT NULL,
ciudad VARCHAR(100) NOT NULL,
estado VARCHAR(100) NOT NULL,
cp VARCHAR(100) NOT NULL,
PRIMARY KEY (id_arrendador)
);
INSERT INTO arrendador VALUE(NULL,'K','B','J','Q',23,'KB','cel','D1','D2','P','C','E','CP');
INSERT INTO arrendador VALUE(NULL,'D','M','AP','AM',21,'KB','cel','D1','D2','P','C','E','CP');
INSERT INTO arrendador VALUE(NULL,'D1','M1','AP1','AM1',24,'KB1','cel1','D11','D21','P1','C1','E1','CP1');
INSERT INTO arrendador VALUE(NULL,'D2','M2','AP2','AM2',25,'KB2','cel2','D12','D22','P2','C2','E2','CP2');
INSERT INTO arrendador VALUE(NULL,'D3','M3','AP3','AM3',26,'KB3','cel3','D13','D23','P3','C3','E3','CP3');

CREATE TABLE arrendatario(
id_arrendatario INTEGER NOT NULL AUTO_INCREMENT,
nombre1 VARCHAR(100) NOT NULL,
nombre2 VARCHAR(100),
apellido_paterno VARCHAR(100) NOT NULL,
apellido_materno VARCHAR(100) NOT NULL,
edad INTEGER NOT NULL,
correo VARCHAR(50) NOT NULL,
celular VARCHAR(20) NOT NULL,
direccion1 VARCHAR(100) NOT NULL DEFAULT '-',
direccion2 VARCHAR(100) NOT NULL DEFAULT '-',
pais VARCHAR(100) NOT NULL DEFAULT '-',
ciudad VARCHAR(100) NOT NULL DEFAULT '-',
estado VARCHAR(100) NOT NULL DEFAULT '-',
cp VARCHAR(100) NOT NULL,
PRIMARY KEY (id_arrendatario)
);
INSERT INTO arrendatario VALUE(NULL,'K','B','J','Q',23,'KB','cel','D1','D2','P','C','E','CP');
INSERT INTO arrendatario VALUE(NULL,'D','M','AP','AM',23,'KB','cel','D1','D2','P','C','E','CP');
INSERT INTO arrendatario VALUE(NULL,'D1','M1','AP1','AM1',24,'KB1','cel1','D11','D21','P1','C1','E1','CP1');
INSERT INTO arrendatario VALUE(NULL,'D2','M2','AP2','AM2',25,'KB2','cel2','D12','D22','P2','C2','E2','CP2');
INSERT INTO arrendatario VALUE(NULL,'D3','M3','AP3','AM3',26,'KB3','cel3','D13','D23','P3','C3','E3','CP3');

CREATE TABLE type_realestate(
id_type_real_estate INTEGER,
TYPE VARCHAR(50),
PRIMARY KEY (id_type_real_estate)
);

INSERT INTO type_realestate VALUE (0,'Casa');
INSERT INTO type_realestate VALUE (1,'Departamento');
INSERT INTO type_realestate VALUE (2,'Terreno');
INSERT INTO type_realestate VALUE (3,'Oficina');

CREATE TABLE real_estate(
id_realestate INTEGER NOT NULL AUTO_INCREMENT,
id_arrendador INTEGER NOT NULL,
id_type_realestate INTEGER NOT NULL,
estatus VARCHAR(20) NOT NULL,
direccion1 VARCHAR(100) NOT NULL,
direccion2 VARCHAR(100) NOT NULL,
pais VARCHAR(100) NOT NULL,
ciudad VARCHAR(100) NOT NULL,
estado VARCHAR(100) NOT NULL,
cp VARCHAR(100) NOT NULL,
costo_min DOUBLE NOT NULL,
costo_max DOUBLE NOT NULL,
PRIMARY KEY (id_realestate),
FOREIGN KEY (id_arrendador) REFERENCES arrendador(id_arrendador),
FOREIGN KEY (id_type_realestate) REFERENCES type_realestate(id_type_real_estate)
);

CREATE TABLE contrato(
id_contrato INTEGER NOT NULL AUTO_INCREMENT,
id_arrendador INTEGER NOT NULL,
id_arrendatario INTEGER NOT NULL,
id_realestate INTEGER NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_corte DATE NOT NULL,
costo INTEGER,
PRIMARY KEY(id_contrato,id_arrendador,id_arrendatario,id_realestate),
FOREIGN KEY(id_arrendador) REFERENCES arrendador(id_arrendador),
FOREIGN KEY(id_arrendatario) REFERENCES arrendatario(id_arrendatario),
FOREIGN KEY(id_realestate) REFERENCES real_estate(id_realestate)
);
