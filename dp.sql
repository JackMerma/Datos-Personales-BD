create table DATOS_PERSONALES (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	datosGeneralCod INT,
	datosImportCod INT,
	estaRegis char(1)
);

create table DATOS_GENERALES (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	primerNombre varchar(255),
	segundoNombre varchar(255),
	primerApellido varchar(255),
	segundoApellido varchar(255),
	fechaNacimiento date,
	estaRegis char(1)
);

create table DATOS_IMPORTANTES (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	dni INT,
	estadoCivil INT,
	procedenciaCod INT,
	estaRegis char(1)
);

create table PROCEDENCIA (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	pais varchar(255),
	departamento varchar(255),
	provincia varchar(255),
	distrito varchar(255),
	estaRegis char(1)
);

create table DATOS_PERSONALES_CONTACTO (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	contactoCod int,
	estaRegis char(1)
);

create table CONTACTO (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	contElectronico int,
	numero int,
	direccion varchar(255),
	estaRegis char(1)
);

create table DATOS_ELECTRONICOS (
	cod INT AUTO_INCREMENT PRIMARY KEY,
	correo varchar(255),
	paginaWeb varchar(255),
	estaRegis char(1)
);

create table ESTADO_REGISTRO (
	ide char(1) primary key,
	ideDesc char(20)
);
