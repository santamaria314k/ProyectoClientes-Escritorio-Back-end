-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS GestionClientes;

-- Crear la base de datos GestionClientes
CREATE DATABASE GestionClientes;

-- Usar la base de datos GestionClientes
USE GestionClientes;

-- Tabla Roles
CREATE TABLE Roles (
    idrol INT AUTO_INCREMENT PRIMARY KEY,
    nombrerol VARCHAR(255) NOT NULL
);

-- Tabla Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE,
    direccion VARCHAR(255),
    celular VARCHAR(20),
    edad INT,
    profesion VARCHAR(255),
    fechaNacimiento DATE,
    idrol INT,
    user VARCHAR(255) UNIQUE NOT NULL,
    pass VARCHAR(255) NOT NULL,
    FOREIGN KEY (idrol) REFERENCES Roles(idrol)
);

-- Tabla ClientesComunes
CREATE TABLE ClientesComunes (
    id INT PRIMARY KEY,
    metodosPago VARCHAR(255),
    FOREIGN KEY (id) REFERENCES Clientes(id)
);

-- Tabla ClientesPotenciales
CREATE TABLE ClientesPotenciales (
    id INT PRIMARY KEY,
    comoConocioEmpresa VARCHAR(255),
    intereses TEXT,
    FOREIGN KEY (id) REFERENCES Clientes(id)
);

-- Tabla Empresas
CREATE TABLE Empresas (
    nit INT(20) PRIMARY KEY,
    razonSocial VARCHAR(255) NOT NULL,
    industria VARCHAR(255),
    descripcionActividades TEXT,
    userempresa VARCHAR(255) UNIQUE NOT NULL,
    passempresa VARCHAR(255) NOT NULL
);

-- Tabla Clientela
CREATE TABLE Clientela (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idEmpresa INT(20),
    idClienteComun INT,
    FOREIGN KEY (idEmpresa) REFERENCES Empresas(nit),
    FOREIGN KEY (idClienteComun) REFERENCES ClientesComunes(id)
);

-- Tabla OfertasEmpresa
CREATE TABLE OfertasEmpresa (
    idoferta INT AUTO_INCREMENT PRIMARY KEY,
    descripcionOferta TEXT,
    nit INT(20),
    FOREIGN KEY (nit) REFERENCES Empresas(nit)
);

-- Tabla PQRS
CREATE TABLE PQRS (
    idPQRS INT AUTO_INCREMENT PRIMARY KEY,
    tipoComentario VARCHAR(255),
    descripcion TEXT,
    idClienteComun INT,
    FOREIGN KEY (idClienteComun) REFERENCES ClientesComunes(id)
);

-- Insertar datos de ejemplo
INSERT INTO Roles (nombrerol) VALUES ('Cliente'), ('Administrador'), ('Empresa');

INSERT INTO Clientes (nombres, apellidos, correo, direccion, celular, edad, profesion, fechaNacimiento, idrol, user, pass) VALUES
('Juan', 'Pérez', 'juan@example.com', 'Calle 123', '1234567890', 30, 'Ingeniero', '1993-05-15', 1, 'juanperez', 'pass123');

INSERT INTO ClientesComunes (id, metodosPago) VALUES (1, 'Tarjeta de crédito');

INSERT INTO Empresas (nit, razonSocial, industria, descripcionActividades, userempresa, passempresa) VALUES
(123456789, 'Empresa A', 'Tecnología', 'Desarrollo de software', 'empresaA', 'passA');

INSERT INTO Clientela (idEmpresa, idClienteComun) VALUES (123456789, 1);

INSERT INTO OfertasEmpresa (descripcionOferta, nit) VALUES ('Oferta de empleo', 123456789);

INSERT INTO PQRS (tipoComentario, descripcion, idClienteComun) VALUES ('Queja', 'Problema con el servicio', 1);