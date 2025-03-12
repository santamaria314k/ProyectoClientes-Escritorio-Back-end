


drop database GestionClientes;

 -- Crear la base de datos GestionClientes
CREATE DATABASE IF NOT EXISTS GestionClientes;

-- Usar la base de datos GestionClientes
USE GestionClientes;

-- Tabla Administradores
CREATE TABLE Administradores (
    idAdministrador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    usuario VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    telefono VARCHAR(20)
);

-- Tabla Clientes
CREATE TABLE Clientes (
    idcli INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidoscli VARCHAR(255) NOT NULL,
    celular VARCHAR(20),
    ocupacion VARCHAR(255),
    edad INT
);

-- Tabla ClientesPotenciales
CREATE TABLE ClientesPotenciales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    celular VARCHAR(20),
    edad INT,
    ocupacion VARCHAR(255),
    intereses TEXT
);

-- Tabla Empresas
CREATE TABLE Empresas (
    nit int(20) PRIMARY KEY,
    razonSocial VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    actividad VARCHAR(255)
);




-- Usar la base de datos GestionClientes
USE GestionClientes;

-- Insertar registros en la tabla Administrador
INSERT INTO Administradores (nombre, apellido, usuario, contraseña, email, telefono) VALUES
('Juan', 'Pérez', 'juanperez', 'contraseña123', 'juan.perez@example.com', '1234567890'),
('María', 'Gómez', 'mariagomez', 'secreto456', 'maria.gomez@example.com', '9876543210');

-- Insertar registros en la tabla Cliente
INSERT INTO Clientes (nombres, apellidoscli, celular, ocupacion, edad) VALUES
('Carlos', 'Rodríguez', '5551234567', 'Ingeniero', 35),
('Laura', 'Martínez', '5559876543', 'Abogada', 28),
('Pedro', 'Sánchez', '1112223333', 'Estudiante', 22);

-- Insertar registros en la tabla ClientePotencial
INSERT INTO ClientesPotenciales (nombres, apellidos, celular, edad, ocupacion, intereses) VALUES
('Ana', 'López', '4445556666', 30, 'Diseñadora', 'Marketing digital, diseño web'),
('Luis', 'González', '7778889999', 40, 'Consultor', 'Finanzas, inversiones'),
('Sofía', 'Fernández', '9990001111', 25, 'Desarrolladora', 'Programación, tecnología');

-- Insertar registros en la tabla Empresa
INSERT INTO Empresas (nit, razonSocial, telefono, actividad) VALUES
(12345678, 'Empresa A S.A.', '2223334444', 'Desarrollo de software'),
(987654321, 'Empresa B Ltda.', '5556667777', 'Consultoría financiera'),
(112233445, 'Empresa C SAS', '8889990000', 'Marketing digital');




