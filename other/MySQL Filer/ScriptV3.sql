-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: tog
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargotype`
--

DROP TABLE IF EXISTS `cargotype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cargotype` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargotype`
--

LOCK TABLES `cargotype` WRITE;
/*!40000 ALTER TABLE `cargotype` DISABLE KEYS */;
INSERT INTO `cargotype` VALUES (1,'WOOD'),(2,'STEEL'),(3,'OIL'),(4,'GASOLINE'),(5,'FOOD'),(6,'CARS'),(7,'GENERAL_GOODS');
/*!40000 ALTER TABLE `cargotype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `log` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Timestamp` timestamp NOT NULL,
  `WagonsId` int(10) NOT NULL,
  `WagonStatusId` int(10) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `routes` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `StationsId` int(10) NOT NULL,
  `RouteId` int(10) NOT NULL,
  `StopId` int(10) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKRoutes726138` (`StationsId`),
  CONSTRAINT `FKRoutes726138` FOREIGN KEY (`StationsId`) REFERENCES `stations` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (1,1,1,1),(2,2,2,1),(3,3,3,1),(4,4,3,2),(5,5,3,3),(6,6,4,1),(7,7,4,2),(8,8,4,3),(9,9,5,1),(10,10,5,2),(11,11,5,3),(12,12,5,4);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stations` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES (1,'HAMBURG_HARBOUR'),(2,'SCANDINAVIA'),(3,'DUISBURG'),(4,'KÖLN'),(5,'STUTTGART'),(6,'HANNOVER'),(7,'KASSEL'),(8,'FRANKFURT'),(9,'BERLIN'),(10,'LEIPZIG'),(11,'NÜRNBERG'),(12,'MUNICH');
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wagons`
--

DROP TABLE IF EXISTS `wagons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wagons` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `StationsId` int(10) NOT NULL,
  `WeightTypeId` int(10) NOT NULL,
  `CargoTypeId` int(10) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKWagons521129` (`StationsId`),
  KEY `FKWagons882808` (`WeightTypeId`),
  KEY `FKWagons262096` (`CargoTypeId`),
  CONSTRAINT `FKWagons262096` FOREIGN KEY (`CargoTypeId`) REFERENCES `cargotype` (`Id`),
  CONSTRAINT `FKWagons521129` FOREIGN KEY (`StationsId`) REFERENCES `stations` (`Id`),
  CONSTRAINT `FKWagons882808` FOREIGN KEY (`WeightTypeId`) REFERENCES `weighttype` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wagons`
--

LOCK TABLES `wagons` WRITE;
/*!40000 ALTER TABLE `wagons` DISABLE KEYS */;
/*!40000 ALTER TABLE `wagons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wagonstatus`
--

DROP TABLE IF EXISTS `wagonstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wagonstatus` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wagonstatus`
--

LOCK TABLES `wagonstatus` WRITE;
/*!40000 ALTER TABLE `wagonstatus` DISABLE KEYS */;
INSERT INTO `wagonstatus` VALUES (1,'TO_BE_SORTED'),(2,'SORTED'),(3,'DEPLOYED'),(4,'ARRIVED');
/*!40000 ALTER TABLE `wagonstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weighttype`
--

DROP TABLE IF EXISTS `weighttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `weighttype` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weighttype`
--

LOCK TABLES `weighttype` WRITE;
/*!40000 ALTER TABLE `weighttype` DISABLE KEYS */;
INSERT INTO `weighttype` VALUES (1,'HEAVY'),(2,'MEDIUM'),(3,'LIGHT');
/*!40000 ALTER TABLE `weighttype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-21  8:41:59
