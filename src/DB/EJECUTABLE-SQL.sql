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
    idcli INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidoscli VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE,
    direccion VARCHAR(255),
    celular VARCHAR(20),
    ocupacion VARCHAR(20),
    edad INT,
    profesion VARCHAR(255),
    fechaNacimiento DATE,
    idrol INT,
    user VARCHAR(255) UNIQUE NOT NULL,
    pass VARCHAR(255) NOT NULL,
    FOREIGN KEY (idrol) REFERENCES Roles(idrol)
);

-- Tabla Sectores
CREATE TABLE Sectores (
    idSector INT AUTO_INCREMENT PRIMARY KEY,
    descripcionSector VARCHAR(255) NOT NULL
);


-- Tabla ClientesComunes
CREATE TABLE ClientesComunes (
    idComun INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidoscli VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE,
    direccion VARCHAR(255),
    celular VARCHAR(20),
    ocupacion VARCHAR(20),
    edad INT,
    profesion VARCHAR(255),
    fechaNacimiento DATE,
    idrol INT,
    user VARCHAR(255) UNIQUE NOT NULL,
    pass VARCHAR(255) NOT NULL,
    metodosPago VARCHAR(255),
    idSector INT,
    FOREIGN KEY (idSector) REFERENCES Sectores(idSector),
    FOREIGN KEY (idrol) REFERENCES Roles(idrol)
);






-- Tabla Empresas
CREATE TABLE Empresas (
    nit BIGINT PRIMARY KEY,
    razonSocial VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    descripcionActividades VARCHAR(255),
    userempresa VARCHAR(255) UNIQUE NOT NULL,
    passempresa VARCHAR(255) NOT NULL
);

-- Tabla OfertasEmpresa
CREATE TABLE OfertasEmpresa (
    idoferta INT PRIMARY KEY,
    descripcionOferta TEXT,
    nit BIGINT,
    FOREIGN KEY (nit) REFERENCES Empresas(nit)
);

-- Tabla PQRS
CREATE TABLE PQRS (
    idPQRS INT AUTO_INCREMENT PRIMARY KEY,
    tipoComentario VARCHAR(255),
    descripcion TEXT,
    idComun INT,
    FOREIGN KEY (idComun) REFERENCES ClientesComunes(idComun) ON DELETE CASCADE
);

-- Tabla Administradores
CREATE TABLE Administradores (
    idAdmin INT AUTO_INCREMENT PRIMARY KEY,
    nombreAdmin VARCHAR(255) NOT NULL,
    userAdmin VARCHAR(255) UNIQUE NOT NULL,
    passAdmin VARCHAR(255) NOT NULL,
    idrol INT,
    FOREIGN KEY (idrol) REFERENCES Roles(idrol)
);

-- Tabla ClienteEmpresa
CREATE TABLE ClienteEmpresa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idEmpresa BIGINT,
    idClienteComun INT,
    FOREIGN KEY (idEmpresa) REFERENCES Empresas(nit),
    FOREIGN KEY (idClienteComun) REFERENCES ClientesComunes(idComun) ON DELETE CASCADE
);

-- Tabla EmpresasSectores
CREATE TABLE EmpresasSectores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idSector INT,
    idEmpresa BIGINT,
    FOREIGN KEY (idSector) REFERENCES Sectores(idSector),
    FOREIGN KEY (idEmpresa) REFERENCES Empresas(nit)
);


-- //////////////////////////////////// insercciones

-- Insertar datos en la tabla Roles
INSERT INTO Roles (nombrerol) VALUES
('Cliente'),
('Empresa'),
('Administrador');

-- Insertar datos en la tabla Clientes
INSERT INTO Clientes (nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', 'Calle 123, Ciudad', '1234567890', 'Empleado', 30, 'Ingeniero', '1993-05-15', 1, 'juanp', 'password123'),
('María', 'Gómez', 'maria.gomez@example.com', 'Avenida 456, Ciudad', '9876543210', 'Estudiante', 22, 'Estudiante', '2001-10-20', 1, 'mariag', 'securepass456'),
('Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', 'Carrera 789, Ciudad', '5551234567', 'Desempleado', 45, 'Contador', '1978-03-01', 1, 'carlosr', 'mysecret789');

-- Insertar datos en la tabla Sectores
INSERT INTO Sectores (descripcionSector) VALUES
('Tecnología'),
('Salud'),
('Educación'),
('Finanzas'),
('Comercio');

-- Insertar datos en la tabla ClientesComunes
-- Obtener el ID del Sector recién insertado

SET @idSector = LAST_INSERT_ID();

INSERT INTO ClientesComunes (nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass, metodosPago, idSector)
VALUES ('Juan', 'Pérez', 'juan@example.com', 'Calle 123', '1234567890', 'Ingeniero', 30, 'Ingeniero', '1993-05-15', 1, 'juanperez', 'pass123', 'Tarjeta de crédito', @idSector);


-- Insertar datos en la tabla Empresas
INSERT INTO Empresas (nit, razonSocial, telefono, descripcionActividades, userempresa, passempresa) VALUES
(123456789, 'Tech Solutions S.A.', '3101234567', 'Desarrollo de software', 'techsolutions', 'companypass1'),
(987654321, 'Health Care Inc.', '3209876543', 'Servicios médicos', 'healthcare', 'companypass2'),
(555123789, 'Educa Plus Ltda.', '3155551234', 'Cursos y capacitaciones', 'educaplus', 'companypass3');

-- Insertar datos en la tabla OfertasEmpresa
INSERT INTO OfertasEmpresa (descripcionOferta, nit) VALUES
('Descuento del 20% en software', 123456789),
('Consulta médica gratuita', 987654321),
('Curso de inglés con 50% de descuento', 555123789);

-- Insertar datos en la tabla PQRS
INSERT INTO PQRS (tipoComentario, descripcion, idComun) VALUES
('Queja', 'El producto llegó dañado', 1),
('Sugerencia', 'Me gustaría más variedad de libros', 2),
('Reclamo', 'No recibí el descuento prometido', 3);

-- Insertar datos en la tabla Administradores
INSERT INTO Administradores (nombreAdmin, userAdmin, passAdmin, idrol) VALUES
('Admin Uno', 'admin1', 'adminpass1', 3),
('Admin Dos', 'admin2', 'adminpass2', 3);

-- Insertar datos en la tabla ClienteEmpresa
INSERT INTO ClienteEmpresa (idEmpresa, idClienteComun) VALUES
(123456789, 1),
(987654321, 2),
(555123789, 3);

-- Insertar datos en la tabla EmpresasSectores
INSERT INTO EmpresasSectores (idSector, idEmpresa) VALUES
(1, 123456789),
(2, 987654321),
(3, 555123789);



