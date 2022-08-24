# SQL script para generar la base de datos intelligen_realestate.

DROP DATABASE intelligent_realestate;
CREATE DATABASE intelligent_realestate;

USE intelligent_realestate;

CREATE TABLE arrendador(
id_arrendador INTEGER NOT NULL AUTO_INCREMENT,
nombre1 VARCHAR(100) NOT NULL,
nombre2 VARCHAR(100) NOT NULL,
apellidoPaterno VARCHAR(100) NOT NULL,
apellidoMaterno VARCHAR(100) NOT NULL,
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

CREATE TABLE arrendatario(
id_arrendatario INTEGER NOT NULL AUTO_INCREMENT,
nombre1 VARCHAR(100) NOT NULL,
nombre2 VARCHAR(100),
apellidoPaterno VARCHAR(100) NOT NULL,
apellidoMaterno VARCHAR(100) NOT NULL,
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
