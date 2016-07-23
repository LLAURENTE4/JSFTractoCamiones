-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employees
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `salessystem`
--

DROP TABLE IF EXISTS `salessystem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salessystem` (
  `salesystem` int(11) NOT NULL,
  `description` char(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salessystem`
--

LOCK TABLES `salessystem` WRITE;
/*!40000 ALTER TABLE `salessystem` DISABLE KEYS */;
INSERT INTO `salessystem` VALUES (0,'Sin Sistema'),(1,'Factura 15 dias'),(2,'Factura, Letra 30-60 dias'),(3,'Factura 30 Dias'),(4,'Factura c/Letra 30 dias+ gastos'),(5,'Presentación de Factura'),(6,'Fact. 30 dias Ch.Dif.'),(7,'Fact.10 dias Ch.Dif.'),(8,'Fact.15 Dias Ch.Dif.'),(9,'Factura C/Letra 45 dias'),(10,'Factura C/L 90 dias + gastos'),(11,'Factura 60 dias'),(12,'Factura c/Letra 180 d'),(13,'Fact. 6 L/180 dias'),(14,'Compensacion Facturas'),(15,'Fact 45 dias cheque Dif'),(86,'Factura Cont.C.Entrega'),(104,'Contado Efectivo'),(105,'Consignación'),(106,'Fact. 45 dias'),(107,'FACTURA 30 DIAS'),(108,'Fact. 7 dias'),(111,'Factura 90 dias'),(114,'Letra 30, 60, 90 dias + gastos'),(117,'Letra a 360 Dias');
/*!40000 ALTER TABLE `salessystem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-22 21:53:41
