-- MySQL dump 10.13  Distrib 5.6.31, for osx10.11 (x86_64)
--
-- Host: localhost    Database: duml
-- ------------------------------------------------------
-- Server version	5.6.31

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso` (
  `id_tipo` int(10) NOT NULL AUTO_INCREMENT,
  `nb_tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_tipo`),
  UNIQUE KEY `nb_tipo` (`nb_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alcance`
--

DROP TABLE IF EXISTS `alcance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alcance` (
  `id_alcance` int(10) NOT NULL AUTO_INCREMENT,
  `nb_alcance` int(10) NOT NULL,
  PRIMARY KEY (`id_alcance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alcance`
--

LOCK TABLES `alcance` WRITE;
/*!40000 ALTER TABLE `alcance` DISABLE KEYS */;
/*!40000 ALTER TABLE `alcance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atributo`
--

DROP TABLE IF EXISTS `atributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atributo` (
  `id_clase` int(10) NOT NULL,
  `id_atributo` int(10) NOT NULL,
  `id_acceso` int(10) NOT NULL,
  `id_alcance` int(10) DEFAULT NULL,
  `id_tipo_dato` int(10) NOT NULL,
  `nb_atributo` int(10) NOT NULL,
  `tx_valor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_clase`,`id_atributo`),
  KEY `FKatributo567857` (`id_acceso`),
  KEY `FKatributo712716` (`id_alcance`),
  KEY `FKatributo943914` (`id_tipo_dato`),
  KEY `FKatributo288902` (`id_clase`),
  CONSTRAINT `FKatributo288902` FOREIGN KEY (`id_clase`) REFERENCES `clase` (`id_clase`),
  CONSTRAINT `FKatributo567857` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_tipo`),
  CONSTRAINT `FKatributo712716` FOREIGN KEY (`id_alcance`) REFERENCES `alcance` (`id_alcance`),
  CONSTRAINT `FKatributo943914` FOREIGN KEY (`id_tipo_dato`) REFERENCES `tipo_dato` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo`
--

LOCK TABLES `atributo` WRITE;
/*!40000 ALTER TABLE `atributo` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `id_clase` int(10) NOT NULL,
  `id_diagrama` int(10) NOT NULL,
  PRIMARY KEY (`id_clase`),
  KEY `FKclase9966` (`id_diagrama`),
  KEY `FKclase632098` (`id_clase`),
  CONSTRAINT `FKclase632098` FOREIGN KEY (`id_clase`) REFERENCES `tipo_dato` (`id_tipo`),
  CONSTRAINT `FKclase9966` FOREIGN KEY (`id_diagrama`) REFERENCES `diagrama` (`id_diagrama`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagrama`
--

DROP TABLE IF EXISTS `diagrama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagrama` (
  `id_diagrama` int(10) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(10) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  `nb_diagrama` varchar(100) NOT NULL,
  `tx_path` varchar(100) NOT NULL,
  PRIMARY KEY (`id_diagrama`),
  UNIQUE KEY `tx_path` (`tx_path`),
  KEY `FKdiagrama496605` (`id_empresa`,`id_usuario`),
  CONSTRAINT `FKdiagrama496605` FOREIGN KEY (`id_empresa`, `id_usuario`) REFERENCES `empresa_usuario` (`id_empresa`, `id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagrama`
--

LOCK TABLES `diagrama` WRITE;
/*!40000 ALTER TABLE `diagrama` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagrama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id_empresa` int(10) NOT NULL AUTO_INCREMENT,
  `nb_nombre` varchar(255) NOT NULL,
  `tx_rfc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`),
  UNIQUE KEY `nb_nombre` (`nb_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Google','GGLE870615VGT'),(2,'Facebook','FCBK040627MZK'),(3,'WhatsApp','WTAP051112YRL'),(4,'Tweeter','TWTR070228HTL'),(5,'Appel','APEL780514SVJ'),(6,'Intel','ITEL730113MXT'),(7,'Microsoft','MSFT760624BGT'),(8,'IBM','IBBM750315JYL'),(9,'Dell','DELL870831ALP'),(10,'Paypal','PYPL970417ELM');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_usuario`
--

DROP TABLE IF EXISTS `empresa_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_usuario` (
  `id_empresa` int(10) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  PRIMARY KEY (`id_empresa`,`id_usuario`),
  KEY `FKempresa_us18985` (`id_empresa`),
  KEY `FKempresa_us820295` (`id_usuario`),
  CONSTRAINT `FKempresa_us18985` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`),
  CONSTRAINT `FKempresa_us820295` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_usuario`
--

LOCK TABLES `empresa_usuario` WRITE;
/*!40000 ALTER TABLE `empresa_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excepcion`
--

DROP TABLE IF EXISTS `excepcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excepcion` (
  `id_clase` int(10) NOT NULL,
  `id_metodo` int(10) NOT NULL,
  `id_excepcion` int(11) NOT NULL,
  `id_tipo` int(10) NOT NULL,
  PRIMARY KEY (`id_clase`,`id_metodo`,`id_excepcion`),
  KEY `FKexcepcion202527` (`id_tipo`),
  KEY `FKexcepcion935704` (`id_clase`,`id_metodo`),
  CONSTRAINT `FKexcepcion202527` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_dato` (`id_tipo`),
  CONSTRAINT `FKexcepcion935704` FOREIGN KEY (`id_clase`, `id_metodo`) REFERENCES `metodo` (`id_clase`, `id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excepcion`
--

LOCK TABLES `excepcion` WRITE;
/*!40000 ALTER TABLE `excepcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `excepcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodo`
--

DROP TABLE IF EXISTS `metodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metodo` (
  `id_clase` int(10) NOT NULL,
  `id_metodo` int(10) NOT NULL,
  `id_acceso` int(10) NOT NULL,
  `id_alcance` int(10) DEFAULT NULL,
  `id_tipo` int(10) NOT NULL,
  `nb_metodo` int(10) NOT NULL,
  PRIMARY KEY (`id_clase`,`id_metodo`),
  KEY `FKmetodo2461` (`id_acceso`),
  KEY `FKmetodo857601` (`id_alcance`),
  KEY `FKmetodo98695` (`id_tipo`),
  KEY `FKmetodo690174` (`id_clase`),
  CONSTRAINT `FKmetodo2461` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_tipo`),
  CONSTRAINT `FKmetodo690174` FOREIGN KEY (`id_clase`) REFERENCES `clase` (`id_clase`),
  CONSTRAINT `FKmetodo857601` FOREIGN KEY (`id_alcance`) REFERENCES `alcance` (`id_alcance`),
  CONSTRAINT `FKmetodo98695` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_dato` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo`
--

LOCK TABLES `metodo` WRITE;
/*!40000 ALTER TABLE `metodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `metodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `id_clase` int(10) NOT NULL,
  `id_metodo` int(10) NOT NULL,
  `id_parametro` int(10) NOT NULL,
  `id_tipo_dato` int(10) NOT NULL,
  `nb_parametro` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_clase`,`id_metodo`,`id_parametro`),
  KEY `FKparametro667407` (`id_tipo_dato`),
  KEY `FKparametro693659` (`id_clase`,`id_metodo`),
  CONSTRAINT `FKparametro667407` FOREIGN KEY (`id_tipo_dato`) REFERENCES `tipo_dato` (`id_tipo`),
  CONSTRAINT `FKparametro693659` FOREIGN KEY (`id_clase`, `id_metodo`) REFERENCES `metodo` (`id_clase`, `id_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacion`
--

DROP TABLE IF EXISTS `relacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacion` (
  `id_relacion` int(10) NOT NULL AUTO_INCREMENT,
  `id_diagrama` int(10) NOT NULL,
  `id_tipo` int(10) NOT NULL,
  `id_origen` int(10) NOT NULL,
  `id_destino` int(10) NOT NULL,
  PRIMARY KEY (`id_relacion`),
  KEY `FKrelacion182327` (`id_tipo`),
  KEY `FKrelacion696052` (`id_diagrama`),
  KEY `FKrelacion451050` (`id_diagrama`,`id_origen`),
  KEY `FKrelacion797910` (`id_diagrama`,`id_destino`),
  CONSTRAINT `FKrelacion182327` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_relacion` (`id_tipo`),
  CONSTRAINT `FKrelacion451050` FOREIGN KEY (`id_diagrama`, `id_origen`) REFERENCES `clase` (`id_diagrama`, `id_clase`),
  CONSTRAINT `FKrelacion696052` FOREIGN KEY (`id_diagrama`) REFERENCES `diagrama` (`id_diagrama`),
  CONSTRAINT `FKrelacion797910` FOREIGN KEY (`id_diagrama`, `id_destino`) REFERENCES `clase` (`id_diagrama`, `id_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacion`
--

LOCK TABLES `relacion` WRITE;
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_dato`
--

DROP TABLE IF EXISTS `tipo_dato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_dato` (
  `id_tipo` int(10) NOT NULL AUTO_INCREMENT,
  `nb_tipo` int(10) DEFAULT NULL,
  `st_primitivo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_dato`
--

LOCK TABLES `tipo_dato` WRITE;
/*!40000 ALTER TABLE `tipo_dato` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_dato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_relacion`
--

DROP TABLE IF EXISTS `tipo_relacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_relacion` (
  `id_tipo` int(10) NOT NULL AUTO_INCREMENT,
  `nb_tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo`),
  UNIQUE KEY `nb_tipo` (`nb_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_relacion`
--

LOCK TABLES `tipo_relacion` WRITE;
/*!40000 ALTER TABLE `tipo_relacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_relacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `tx_login` varchar(30) NOT NULL,
  `tx_password` varchar(256) NOT NULL,
  `tx_nombre` varchar(50) NOT NULL,
  `tx_primer_ap` varchar(50) NOT NULL,
  `tx_segundo_ap` varchar(50) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `tx_login` (`tx_login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-16 12:32:41
