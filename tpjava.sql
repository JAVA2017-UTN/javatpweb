-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tpjava
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookable_items`
--

DROP TABLE IF EXISTS `bookable_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookable_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `id_tipo_elemento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_bookable_items_types_idx` (`id_tipo_elemento`),
  CONSTRAINT `fk_bookable_items_types` FOREIGN KEY (`id_tipo_elemento`) REFERENCES `bookable_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookable_items`
--

LOCK TABLES `bookable_items` WRITE;
/*!40000 ALTER TABLE `bookable_items` DISABLE KEYS */;
INSERT INTO `bookable_items` VALUES (6,'Chevrolet',2),(7,'Yamaha',1),(8,'Iveco',3),(9,'Audi',2),(10,'BMW',1),(11,'Mercedes Benz',2),(12,'Scania',3);
/*!40000 ALTER TABLE `bookable_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookable_types`
--

DROP TABLE IF EXISTS `bookable_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookable_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantReservasPendientes` int(11) NOT NULL,
  `limite_horas` int(11) NOT NULL,
  `dias_antic` int(11) NOT NULL,
  `req_encargado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookable_types`
--

LOCK TABLES `bookable_types` WRITE;
/*!40000 ALTER TABLE `bookable_types` DISABLE KEYS */;
INSERT INTO `bookable_types` VALUES (1,'Motos',7,24,1,0),(2,'Automóviles',3,72,3,1),(3,'Camiones',1,96,7,1);
/*!40000 ALTER TABLE `bookable_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  `id_elemento` int(11) NOT NULL,
  `id_tipo_elemento` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `anulada` tinyint(4) NOT NULL,
  `cant_horas` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_booking_UNIQUE` (`id`),
  KEY `fk_booking_people_idx` (`id_persona`),
  KEY `fk_booking_bookable_items_idx` (`id_elemento`),
  KEY `fk_booking_bookable_types_idx` (`id_tipo_elemento`),
  CONSTRAINT `fk_booking_bookable_items` FOREIGN KEY (`id_elemento`) REFERENCES `bookable_items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_booking_bookable_types` FOREIGN KEY (`id_tipo_elemento`) REFERENCES `bookable_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_booking_people` FOREIGN KEY (`id_persona`) REFERENCES `people` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES ('2017-11-25','12:45:00',' Probando alta camiones',8,3,55,17,1,96),('2017-11-25','00:00:00',' Probando alert',8,3,56,17,1,12),('2017-11-23','01:41:00','Reserva moto Yamaha',7,1,59,21,0,24);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `tipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (17,'Mauricio','Miño','39606313','mauri','mauri',1,1),(21,'Usuario','Probando','35625321','usuario','usuario',1,2),(22,'Admin','Admin','Admin','admin','admin',1,0);
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-23  2:07:08
