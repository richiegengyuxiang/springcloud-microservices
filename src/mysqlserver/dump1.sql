-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 172.17.0.1    Database: datamart
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
  `postId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Datasets_1_idx` (`postId`),
  CONSTRAINT `fk_Datasets_1` FOREIGN KEY (`postId`) REFERENCES `Posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Datasets`
--

LOCK TABLES `Datasets` WRITE;
/*!40000 ALTER TABLE `Datasets` DISABLE KEYS */;
INSERT INTO `Datasets` VALUES ('6618e348-817f-4382-bd30-421d4d62d1fd','hourly_total_amount.csv','','csv','0418dba2-efbd-48d2-9a89-c0e965b6538f'),('6a9e6edb-b4bc-41aa-b2bc-69414b194296','sd this is a readlly long nameedf df sdfsdfs dsf.jpeg','','jpeg','0418dba2-efbd-48d2-9a89-c0e965b6538f'),('a7edf2f9-d10e-4160-81a5-516797bc4721','taxi_17.csv','','csv','0418dba2-efbd-48d2-9a89-c0e965b6538f'),('b4b7797f-1298-455d-82a9-864fc651937f','hourly_weather_2 .csv','','csv','0418dba2-efbd-48d2-9a89-c0e965b6538f');
/*!40000 ALTER TABLE `Datasets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Posts`
--

DROP TABLE IF EXISTS `Posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Posts` (
  `id` varchar(225) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Posts`
--

LOCK TABLES `Posts` WRITE;
/*!40000 ALTER TABLE `Posts` DISABLE KEYS */;
INSERT INTO `Posts` VALUES ('0418dba2-efbd-48d2-9a89-c0e965b6538f','THis is my success','THis is my successTHis is my successTHis is my successTHis is my success'),('0637ba3e-2f65-4236-bcda-e667dc8a296c','adfaf','adfadf'),('0a0e81f2-8654-43f7-9a0f-a44bed7f729a','aaaa','aa'),('353ed825-1b69-4a33-94ed-6fe0b75cfc2a','111','111'),('6d658369-d5e7-4bbc-9553-53139b967d89','as','as'),('900d6808-9975-4460-a892-41d20cac47fd','ffff','dfdf'),('9d26569c-a5f8-4054-a2a6-34470c246e36','tourist speech ','speech'),('da5e4f61-a1ce-4fc7-8a5b-a9bd8dce4606','What do experienced data scientists know that beginner data scientists don\'t know?','What do experienced data scientists know that beginner data scientists don\'t know?What do experienced data scientists know that beginner data scientists don\'t know?What do experienced data scientists know that beginner data scientists don\'t know?');
/*!40000 ALTER TABLE `Posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `bio` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('043a0304-bb11-4dea-8334-feed7d5d29c3','e','e@gmail.com','$2a$10$Zl201o0XF0xpiGgos5SPVOef71K41BjezQtKJl5LpZwZszaZLKdNu',NULL),('1ade767c-2251-4b2f-bf5b-3877b9c310c6','w','w@gmail.com','$2a$10$wsQiKsvAAC5AoCVKJYjoqeRRJ4xUpd2dIL86QifrEubdqHmXUlHBK',NULL),('2dcca708-6982-4c35-b3d0-a293bb6730f7','q123','q@gmail.com','$2a$10$YD/RIQiSBtdL7.Abjk5xNuPIL7wi.bz.toZlFQCrMHrc5Rob2vix2',NULL),('405f99c5-2f80-4b5c-bffa-9a8b5e437978','a','a@gmail.com','$2a$10$K//JmWY4SBg6C3h3LY6vqumuoZJKOnYTRylf5S9wPngsTI0Wwuf9S',NULL),('442b26f9-66b6-47b2-a5da-7a7b66ec185a','rickygeng97','rickygeng97@gmail.com','$2a$10$Lnpbi.G/RSb/kpA9pDnM1OTNKkpssEqNUzsYFLaaxypM3SrHnUGtu',NULL),('9878ac94-b8bf-465e-8f40-6ed51aa92485','r','r@gmail.com','$2a$10$Je3SnxyKn1l0hhLnSO7oT.3qKDjry/z7neuSnBDMoUcFxEUzhbf4K',NULL),('b3cea98c-53d3-4321-bcfb-b10a89844ba5','t','t@gmail.com','$2a$10$r05eHSP8lEd13a/WxvtmAerNqDe3hNT4bo4c3vMRiMQNcN98SXSyK',NULL),('fda50809-8862-4b04-9371-ed990a771dcd','rickygeng97@gmail.com','rickygeng97@gmail.co','$2a$10$oIyvuDTit2/Rwrft77xyGextYXQqGt.9t9iRJCX5mtkWUShhalm1C',NULL);
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

-- Dump completed on 2020-03-03 16:25:59
