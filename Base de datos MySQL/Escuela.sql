-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: academia
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB
create database escuela;

use escuela;

CREATE TABLE `instructores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `contactos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `codigo_postal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_instructor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKeul64s9jkged9jvu46ie3aif8` FOREIGN KEY (`id_instructor`) REFERENCES `instructores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `estudiantes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `id_contacto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_74businhk8p9s68gwqk26mfdv` (`id_contacto`),
  CONSTRAINT `FKdo84jxurkqtvreyfbuitir4ag` FOREIGN KEY (`id_contacto`) REFERENCES `contactos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `estudiante_curso` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `estudiante_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  CONSTRAINT `fk_estudiante` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiantes` (`id`),
  CONSTRAINT `fk_curso` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;







-- Instructor 1
INSERT INTO instructores (nombre, apellido) VALUES ('María', 'González');
-- Instructor 2
INSERT INTO instructores (nombre, apellido) VALUES ('Ricardo', 'Sánchez');
-- Instructor 3
INSERT INTO instructores (nombre, apellido) VALUES ('Luisa', 'Martínez');
-- Instructor 4
INSERT INTO instructores (nombre, apellido) VALUES ('Pablo', 'López');
-- Instructor 5
INSERT INTO instructores (nombre, apellido) VALUES ('Ana', 'Rodríguez');


-- Contacto 1
INSERT INTO contactos (email, telefono, direccion, ciudad, provincia, codigo_postal) 
VALUES ('maria.g@email.com', '987654321', '456 Avenida Principal', 'Ciudad A', 'Provincia X', '54321');

-- Contacto 2
INSERT INTO contactos (email, telefono, direccion, ciudad, provincia, codigo_postal) 
VALUES ('ricardo.s@email.com', '123456789', '789 Calle Secundaria', 'Ciudad B', 'Provincia Y', '67890');

-- Contacto 3
INSERT INTO contactos (email, telefono, direccion, ciudad, provincia, codigo_postal) 
VALUES ('luisa.m@email.com', '111222333', '012 Calle Céntrica', 'Ciudad C', 'Provincia Z', '13579');

-- Contacto 4
INSERT INTO contactos (email, telefono, direccion, ciudad, provincia, codigo_postal) 
VALUES ('pablo.l@email.com', '555666777', '345 Carretera Principal', 'Ciudad D', 'Provincia W', '24680');

-- Contacto 5
INSERT INTO contactos (email, telefono, direccion, ciudad, provincia, codigo_postal) 
VALUES ('ana.r@email.com', '999000111', '678 Camino Principal', 'Ciudad E', 'Provincia V', '98765');


-- Curso 1
INSERT INTO cursos (nombre, id_instructor) VALUES ('Matemáticas Avanzadas', 1);

-- Curso 2
INSERT INTO cursos (nombre, id_instructor) VALUES ('Programación en Java', 2);

-- Curso 3
INSERT INTO cursos (nombre, id_instructor) VALUES ('Diseño Gráfico', 3);

-- Curso 4
INSERT INTO cursos (nombre, id_instructor) VALUES ('Historia del Arte', 4);

-- Curso 5
INSERT INTO cursos (nombre, id_instructor) VALUES ('Biología Molecular', 5);


-- Estudiante 1
INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, id_contacto) 
VALUES ('Pedro', 'Gómez', '1998-03-20', 1);

-- Estudiante 2
INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, id_contacto) 
VALUES ('Laura', 'Pérez', '1997-08-15', 2);

-- Estudiante 3
INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, id_contacto) 
VALUES ('Carlos', 'Hernández', '1996-11-10', 3);

-- Estudiante 4
INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, id_contacto) 
VALUES ('Sofía', 'López', '1999-05-05', 4);

-- Estudiante 5
INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, id_contacto) 
VALUES ('Javier', 'Martínez', '1995-12-25', 5);


-- Asignar cursos al Estudiante 1
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 1), 1);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 1), 2);

-- Asignar cursos al Estudiante 2
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 2), 2);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 2), 3);

-- Asignar cursos al Estudiante 3
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 3), 3);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 3), 4);

-- Asignar cursos al Estudiante 4
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 4), 4);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 4), 5);

-- Asignar cursos al Estudiante 5
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 5), 1);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES ((SELECT id FROM estudiantes WHERE id = 5), 3);

-- Asignar cursos al Estudiante 5
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES (5, 1);
INSERT INTO Estudiante_Curso (estudiante_id, curso_id) VALUES (5, 3);


