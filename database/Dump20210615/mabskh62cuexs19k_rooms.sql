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
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `idrooms` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `free_rooms` int DEFAULT NULL,
  `hotel_idhotel` int NOT NULL,
  PRIMARY KEY (`idrooms`),
  KEY `fk_rooms_hotel_idx` (`hotel_idhotel`),
  CONSTRAINT `fk_rooms_hotel` FOREIGN KEY (`hotel_idhotel`) REFERENCES `hotel` (`idhotel`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'2021-07-01',104,1),(2,'2021-07-02',10,1),(3,'2021-07-03',5,1),(4,'2021-07-04',3,1),(5,'2021-07-05',70,1),(6,'2021-07-06',105,1),(7,'2021-07-07',80,1),(8,'2021-07-01',180,2),(9,'2021-07-02',100,2),(10,'2021-07-03',5,2),(11,'2021-07-04',3,2),(12,'2021-07-05',70,2),(13,'2021-07-06',105,2),(14,'2021-07-07',80,2),(15,'2021-07-01',180,3),(16,'2021-07-02',100,3),(17,'2021-07-03',5,3),(18,'2021-07-04',3,3),(19,'2021-07-05',70,3),(20,'2021-07-06',105,3),(21,'2021-07-07',80,3),(22,'2021-07-01',104,4),(23,'2021-07-02',10,4),(24,'2021-07-03',2,4),(25,'2021-07-04',0,4),(26,'2021-07-05',70,4),(27,'2021-07-06',105,4),(28,'2021-07-07',80,4),(29,'2021-07-01',180,5),(30,'2021-07-02',100,5),(31,'2021-07-03',5,5),(32,'2021-07-04',3,5),(33,'2021-07-05',70,5),(34,'2021-07-06',105,5),(35,'2021-07-07',80,2),(36,'2021-07-01',180,6),(37,'2021-07-02',100,6),(38,'2021-07-03',5,6),(39,'2021-07-04',3,6),(40,'2021-07-05',70,6),(41,'2021-07-06',105,6),(42,'2021-07-07',80,6),(43,'2021-07-01',104,7),(44,'2021-07-02',10,7),(45,'2021-07-03',2,7),(46,'2021-07-04',0,7),(47,'2021-07-05',70,7),(48,'2021-07-06',105,7),(49,'2021-07-07',80,7),(50,'2021-07-01',180,8),(51,'2021-07-02',100,8),(52,'2021-07-03',5,8),(53,'2021-07-04',3,8),(54,'2021-07-05',70,8),(55,'2021-07-06',105,8),(56,'2021-07-07',80,8),(57,'2021-07-01',180,9),(58,'2021-07-02',100,9),(59,'2021-07-03',5,9),(60,'2021-07-04',3,9),(61,'2021-07-05',70,9),(62,'2021-07-06',105,9),(63,'2021-07-07',80,9),(64,'2021-07-01',104,10),(65,'2021-07-02',10,10),(66,'2021-07-03',2,10),(67,'2021-07-04',0,10),(68,'2021-07-05',70,10),(69,'2021-07-06',105,10),(70,'2021-07-07',80,10),(71,'2021-07-01',180,11),(72,'2021-07-02',100,11),(73,'2021-07-03',5,11),(74,'2021-07-04',3,11),(75,'2021-07-05',70,11),(76,'2021-07-06',105,11),(77,'2021-07-07',80,11),(78,'2021-07-01',180,12),(79,'2021-07-02',100,12),(80,'2021-07-03',5,12),(81,'2021-07-04',3,12),(82,'2021-07-05',70,12),(83,'2021-07-06',105,12),(84,'2021-07-07',80,12),(85,'2021-07-01',104,13),(86,'2021-07-02',10,13),(87,'2021-07-03',2,13),(88,'2021-07-04',0,13),(89,'2021-07-05',70,13),(90,'2021-07-06',105,13),(91,'2021-07-07',80,13),(92,'2021-07-01',180,14),(93,'2021-07-02',100,14),(94,'2021-07-03',5,14),(95,'2021-07-04',3,14),(96,'2021-07-05',70,14),(97,'2021-07-06',105,14),(98,'2021-07-07',80,14),(99,'2021-07-01',180,15),(100,'2021-07-02',100,15),(101,'2021-07-03',5,15),(102,'2021-07-04',3,15),(103,'2021-07-05',70,15),(104,'2021-07-06',105,15),(105,'2021-07-07',80,15),(106,'2021-07-01',104,16),(107,'2021-07-02',10,16),(108,'2021-07-03',2,16),(109,'2021-07-04',0,16),(110,'2021-07-05',70,16),(111,'2021-07-06',105,16),(112,'2021-07-07',80,16),(113,'2021-07-01',180,17),(114,'2021-07-02',100,17),(115,'2021-07-03',5,17),(116,'2021-07-04',3,17),(117,'2021-07-05',70,17),(118,'2021-07-06',105,17),(119,'2021-07-07',80,17),(120,'2021-07-01',180,18),(121,'2021-07-02',100,18),(122,'2021-07-03',5,18),(123,'2021-07-04',3,18),(124,'2021-07-05',70,18),(125,'2021-07-06',105,18),(126,'2021-07-07',80,18),(127,'2021-07-01',104,19),(128,'2021-07-02',10,19),(129,'2021-07-03',2,19),(130,'2021-07-04',0,19),(131,'2021-07-05',70,19),(132,'2021-07-06',105,19),(133,'2021-07-07',80,19),(134,'2021-07-01',180,20),(135,'2021-07-02',100,20),(136,'2021-07-03',5,20),(137,'2021-07-04',3,20),(138,'2021-07-05',70,20),(139,'2021-07-06',105,20),(140,'2021-07-07',80,20),(141,'2021-07-01',180,21),(142,'2021-07-02',100,21),(143,'2021-07-03',5,21),(144,'2021-07-04',3,21),(145,'2021-07-05',70,21),(146,'2021-07-06',105,21),(147,'2021-07-07',80,21),(148,'2021-07-01',104,22),(149,'2021-07-02',10,22),(150,'2021-07-03',2,22),(151,'2021-07-04',0,22),(152,'2021-07-05',70,22),(153,'2021-07-06',105,22),(154,'2021-07-07',80,22),(155,'2021-07-01',180,23),(156,'2021-07-02',100,23),(157,'2021-07-03',5,23),(158,'2021-07-04',3,23),(159,'2021-07-05',70,23),(160,'2021-07-06',105,23),(161,'2021-07-07',80,23),(162,'2021-07-01',180,24),(163,'2021-07-02',100,24),(164,'2021-07-03',5,24),(165,'2021-07-04',3,24),(166,'2021-07-05',70,24),(167,'2021-07-06',105,24),(168,'2021-07-07',80,24),(169,'2021-07-01',104,25),(170,'2021-07-02',10,25),(171,'2021-07-03',2,25),(172,'2021-07-04',0,25),(173,'2021-07-05',70,25),(174,'2021-07-06',105,25),(175,'2021-07-07',80,25),(176,'2021-07-01',180,26),(177,'2021-07-02',100,26),(178,'2021-07-03',5,26),(179,'2021-07-04',3,26),(180,'2021-07-05',70,26),(181,'2021-07-06',105,26),(182,'2021-07-07',80,26),(183,'2021-07-01',180,27),(184,'2021-07-02',100,27),(185,'2021-07-03',5,27),(186,'2021-07-04',3,27),(187,'2021-07-05',70,27),(188,'2021-07-06',105,27),(189,'2021-07-07',80,27),(190,'2021-07-01',179,28),(191,'2021-07-02',100,28),(192,'2021-07-03',5,28),(193,'2021-07-04',3,28),(194,'2021-07-05',70,28),(195,'2021-07-06',105,28),(196,'2021-07-07',80,28),(197,'2021-07-01',180,29),(198,'2021-07-02',100,29),(199,'2021-07-03',5,29),(200,'2021-07-04',3,29),(201,'2021-07-05',70,29),(202,'2021-07-06',105,29),(203,'2021-07-07',80,29),(204,'2021-07-01',180,30),(205,'2021-07-02',100,30),(206,'2021-07-03',5,30),(207,'2021-07-04',3,30),(208,'2021-07-05',70,30),(209,'2021-07-06',105,30),(210,'2021-07-07',80,30);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
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

-- Dump completed on 2021-06-15 18:10:45
