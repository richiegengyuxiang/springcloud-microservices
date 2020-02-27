-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: datamart
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `Datasets`
--

DROP TABLE IF EXISTS `Datasets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Datasets` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `repoId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Datasets_1_idx` (`repoId`),
  CONSTRAINT `fk_Datasets_1` FOREIGN KEY (`repoId`) REFERENCES `Repos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Datasets`
--

LOCK TABLES `Datasets` WRITE;
/*!40000 ALTER TABLE `Datasets` DISABLE KEYS */;
INSERT INTO `Datasets` VALUES ('6618e348-817f-4382-bd30-421d4d62d1fd','hourly_total_amount.csv','','csv','0418dba2-efbd-48d2-9a89-c0e965b6538f'),('6a9e6edb-b4bc-41aa-b2bc-69414b194296','sd this is a readlly long nameedf df sdfsdfs dsf.jpeg','','jpeg','0418dba2-efbd-48d2-9a89-c0e965b6538f'),('b4b7797f-1298-455d-82a9-864fc651937f','hourly_weather_2 .csv','','csv','0418dba2-efbd-48d2-9a89-c0e965b6538f');
/*!40000 ALTER TABLE `Datasets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Repos`
--

DROP TABLE IF EXISTS `Repos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Repos` (
  `id` varchar(225) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Repos`
--

LOCK TABLES `Repos` WRITE;
/*!40000 ALTER TABLE `Repos` DISABLE KEYS */;
INSERT INTO `Repos` VALUES ('0418dba2-efbd-48d2-9a89-c0e965b6538f','THis is my success','THis is my successTHis is my successTHis is my successTHis is my success'),('0637ba3e-2f65-4236-bcda-e667dc8a296c','adfaf','adfadf'),('0a0e81f2-8654-43f7-9a0f-a44bed7f729a','aaaa','aa'),('353ed825-1b69-4a33-94ed-6fe0b75cfc2a','111','111'),('6d658369-d5e7-4bbc-9553-53139b967d89','as','as'),('900d6808-9975-4460-a892-41d20cac47fd','ffff','dfdf'),('9d26569c-a5f8-4054-a2a6-34470c246e36','tourist speech ','speech'),('da5e4f61-a1ce-4fc7-8a5b-a9bd8dce4606','What do experienced data scientists know that beginner data scientists don\'t know?','What do experienced data scientists know that beginner data scientists don\'t know?What do experienced data scientists know that beginner data scientists don\'t know?What do experienced data scientists know that beginner data scientists don\'t know?');
/*!40000 ALTER TABLE `Repos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Requests`
--

DROP TABLE IF EXISTS `Requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Requests` (
  `id` varchar(255) NOT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Requests`
--

LOCK TABLES `Requests` WRITE;
/*!40000 ALTER TABLE `Requests` DISABLE KEYS */;
INSERT INTO `Requests` VALUES ('a3d7b4c9-bd02-453b-9f6b-5d74cf69d558','ddd','dddddd'),('dfda42df-ee4b-46e5-a196-0d7a28e3b405','444','444');
/*!40000 ALTER TABLE `Requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'ricky','ricky@gmail.com','123456'),(2,'tom','tom@gmail.com','123456');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-20 21:01:06
