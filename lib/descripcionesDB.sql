/*
SQLyog Community v13.0.0 (64 bit)
MySQL - 10.1.30-MariaDB : Database - descripciones
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`descripciones` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `descripciones`;

/*Table structure for table `competencia_puesto` */

DROP TABLE IF EXISTS `competencia_puesto`;

CREATE TABLE `competencia_puesto` (
  `id_dp` int(10) unsigned NOT NULL,
  `id_competencia` tinyint(1) unsigned NOT NULL,
  KEY `id_dp` (`id_dp`),
  KEY `id_competencia` (`id_competencia`),
  CONSTRAINT `competencia_puesto_ibfk_1` FOREIGN KEY (`id_dp`) REFERENCES `dps` (`id`),
  CONSTRAINT `competencia_puesto_ibfk_2` FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `competencia_puesto` */

/*Table structure for table `competencias` */

DROP TABLE IF EXISTS `competencias`;

CREATE TABLE `competencias` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(65) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*Data for the table `competencias` */

insert  into `competencias`(`id`,`descripcion`) values 
(1,'Adaptabilidad'),
(2,'Anal. Problema'),
(3,'Anal. Numerico'),
(4,'<html><body>Asuncion <br>Riesgos</body></html>'),
(5,'Automotivacion'),
(6,'<html><body>Atención<br>Cliente</body></html>'),
(7,'Control'),
(8,'<html><body>Capacidad<br>Critica</body></html>'),
(9,'Creatividad'),
(10,'<html><body>Comunicación<br>No verbal</body></html>'),
(12,'Compromiso'),
(13,'Delegacion'),
(16,'<html><body>Tolerancia<br>al  Estres</body></html>'),
(18,'Escucha'),
(19,'Energia'),
(20,'Flexibilidad'),
(21,'Independencia'),
(22,'Integridad'),
(23,'Impacto'),
(24,'Iniciativa'),
(25,'Liderazgo'),
(26,'Meticulosidad'),
(28,'<html><body>Planificacion<br>Organizacion</body></html>'),
(29,'Resistencia'),
(30,'<html><body>Sensibilidad<br>Organizacion</body></html>'),
(31,'Sociabilidad'),
(32,'Tenacidad'),
(33,'Equipo'),
(35,'Decision'),
(36,'<html><body>Sensibilidad<br>Interpersonal</body></html>'),
(37,'Comunicacion Verbal');

/*Table structure for table `departamento` */

DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `departamento` */

insert  into `departamento`(`id`,`descripcion`) values 
(1,'IT'),
(2,'RR.HH'),
(3,'Mantenimiento'),
(4,'Soluciones'),
(5,'Enterales'),
(6,'Seguridad');

/*Table structure for table `dps` */

DROP TABLE IF EXISTS `dps`;

CREATE TABLE `dps` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Solicitante` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Departamento` tinyint(1) unsigned NOT NULL,
  `Puesto` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `dps` */

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Puesto` tinyint(1) unsigned NOT NULL,
  `edad` tinyint(2) unsigned NOT NULL,
  `altura` tinyint(2) unsigned NOT NULL,
  `peso` smallint(5) unsigned NOT NULL,
  `id_departamento` tinyint(1) unsigned NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido_Paterno` varchar(30) NOT NULL,
  `apellido_Materno` varchar(30) NOT NULL,
  `FechaInicio` date NOT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Puesto` (`id_Puesto`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_Puesto`) REFERENCES `puesto` (`id`) ON DELETE CASCADE,
  CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `empleados` */

insert  into `empleados`(`id`,`id_Puesto`,`edad`,`altura`,`peso`,`id_departamento`,`nombre`,`apellido_Paterno`,`apellido_Materno`,`FechaInicio`,`Correo`,`Contraseña`) values 
(1,8,21,168,68,2,'JUAN CARLOS','FUENTES','MAGDALENO','2018-04-23','fred@gmail.com','123'),
(14,6,29,180,76,1,'gustavo','ibarra','maciel','1932-06-12','a@gmail.com','a');

/*Table structure for table `habilidades` */

DROP TABLE IF EXISTS `habilidades`;

CREATE TABLE `habilidades` (
  `id_Empleado` int(10) unsigned NOT NULL,
  `id_Competencia` tinyint(1) unsigned NOT NULL,
  KEY `id_Empleado` (`id_Empleado`),
  KEY `id_Competencia` (`id_Competencia`),
  CONSTRAINT `habilidades_ibfk_1` FOREIGN KEY (`id_Empleado`) REFERENCES `empleados` (`id`),
  CONSTRAINT `habilidades_ibfk_2` FOREIGN KEY (`id_Competencia`) REFERENCES `competencias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `habilidades` */

insert  into `habilidades`(`id_Empleado`,`id_Competencia`) values 
(1,1),
(1,4),
(1,5),
(1,6),
(1,9),
(1,12),
(1,19),
(1,20),
(1,24),
(14,12),
(14,22);

/*Table structure for table `puesto` */

DROP TABLE IF EXISTS `puesto`;

CREATE TABLE `puesto` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `puesto` */

insert  into `puesto`(`id`,`descripcion`) values 
(1,'Director General'),
(2,'Gerente'),
(3,'Jefe'),
(4,'Coordinador'),
(5,'Supervisor'),
(6,'Ingeniero'),
(7,'Lider'),
(8,'Empleados');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
