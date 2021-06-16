-- MySQL dump 10.13  Distrib 8.0.24, for macos11 (x86_64)
--
-- Host: bmlx3df4ma7r1yh4.cbetxkdyhwsb.us-east-1.rds.amazonaws.com    Database: mabskh62cuexs19k
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `idhotel` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `stars` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `price_per_day` int DEFAULT NULL,
  PRIMARY KEY (`idhotel`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Hampton','7360 South Manor St.','5','Los Angeles','CA',650),(2,'Weston','980 West Cobble St.','3','Los Angeles','CA',260),(3,'Residence Inn','85 Primrose Ave','3','Los Angeles','CA',110),(4,'Hampton','195 Hill Court ','5','Chicago','IL',600),(5,'Weston','1 Beech St.','3','Chicago','IL',320),(6,'Residence Inn','93 West Greenview Street','2','Chicago','IL',108),(7,'Hampton','9074 W. Clark Street','5','Huston','TX',520),(8,'Weston','78 Coffee St.','3','Huston','TX',345),(9,'Residence Inn','886 South Constitution Dr.','2','Huston','TX',98),(10,'Hampton','276 Corona Street','5','Phoenix','AZ',490),(11,'Weston','103 4th Dr.','3','Phoenix','AZ',200),(12,'Residence Inn','9408 Meadow Drive','2','Phoenix','AZ',95),(13,'Hampton','144 N. Blue Spring Lane','5','Philadelphia','PA',540),(14,'Weston','278 E. Bellevue Lane ','3','Philadelphia','PA',264),(15,'Residence Inn','8576 Front St.','2','Philadelphia','PA',118),(16,'Hampton','66 West Pulaski Rd.','5','San Antonio','TX',550),(17,'Weston','1 Lake Court','3','San Antonio','TX',250),(18,'Residence Inn','566 Carson Ave.','2','San Antonio','TX',150),(19,'Hampton','9320 Windfall Court','5','San Diego','CA',700),(20,'Weston','86 Central St.','3','San Diego','CA',340),(21,'Residence Inn','39 South Bay Avenue','2','San Diego','CA',180),(22,'Hampton','8301 Wilson Ave.','5','Dallas','TX',525),(23,'Weston','9213 South Pine Lane','3','Dallas','TX',225),(24,'Residence Inn','475 Mayfield Drive','2','Dallas','TX',113),(25,'Hampton','7197 Galvin Drive','5','San Jose','CA',508),(26,'Weston','7930 Depot St.','3','San Jose','CA',294),(27,'Residence Inn','7662 Fawn Avenue','2','San Jose','CA',143),(28,'Hampton','7360 North Manor St.','5','New York','NY',600),(29,'Weston','9540 North Cobblestone St.','5','New York','NY',290),(30,'Residence Inn','8095 Primrose Drive','5','New York','NY',110);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-15 18:10:37
