-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.32

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

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `file_path` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `parent_category_id` bigint DEFAULT NULL,
  `thumbnail` varchar(250) NOT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs2ride9gvilxy2tcuv7witnxc` (`parent_category_id`),
  CONSTRAINT `FKs2ride9gvilxy2tcuv7witnxc` FOREIGN KEY (`parent_category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'nam','dd',NULL,'https://savani.vn/images/menus/thoi-trang-nam-savani_1706273946.jpg',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(2,'nữ','dd',NULL,'https://savani.vn/images/menus/thoi-trang-nu-savani_1706273969.jpg',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(3,'trẻ em','dd',NULL,'https://savani.vn/images/menus/thoi-trang-tre-em_1706274031.jpg',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(4,'đồng phục','dd',NULL,'https://savani.vn/images/menus/thoi-trang-gia-dinh-savani_1706274051.jpg',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(5,'áo','dd',1,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(6,'quần','dd',1,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(7,'bộ đồ','dd',1,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(8,'phụ kiện','dd',1,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(9,'váy nữ','dd',2,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(10,'váy trẻ em','dd',3,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(11,'đồng phục gia đình','dd',4,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(12,'đồng phục nhóm','dd',4,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(13,'áo','dd',2,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(14,'áo','dd',3,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(15,'quần','dd',2,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(16,'quần','dd',3,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(17,'bộ đồ','dd',2,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(18,'bộ đồ','dd',3,'\'\'',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `featured` bit(1) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `promotion_id` bigint DEFAULT NULL,
  `sub_category_id` bigint DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcli9x921yidy04cx25k6m46fy` (`promotion_id`),
  KEY `FKd9gfnsjgfwjtaxl57udrbocsp` (`sub_category_id`),
  CONSTRAINT `FKcli9x921yidy04cx25k6m46fy` FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`id`),
  CONSTRAINT `FKd9gfnsjgfwjtaxl57udrbocsp` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'MS001','Áo T-shirt nam',NULL,'không',_binary '',1,3,5,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(2,'MS002','Áo T-shirt nữ',NULL,'không',_binary '\0',1,3,6,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(3,'MS003','Áo polo nam',NULL,'không',_binary '',1,5,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(4,'MS004','Áo polo nữ',NULL,'không',_binary '',1,4,2,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_asset`
--

DROP TABLE IF EXISTS `product_asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_asset` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asset_id` bigint DEFAULT NULL,
  `product_detail_id` bigint DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo1cp2n2covml4p4nbiqbemhsc` (`asset_id`),
  KEY `FKmbmt8hm9rqsbxvnqrf79pgbkh` (`product_detail_id`),
  CONSTRAINT `FKmbmt8hm9rqsbxvnqrf79pgbkh` FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`),
  CONSTRAINT `FKo1cp2n2covml4p4nbiqbemhsc` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_asset`
--

LOCK TABLES `product_asset` WRITE;
/*!40000 ALTER TABLE `product_asset` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_de_variant_op`
--

DROP TABLE IF EXISTS `product_de_variant_op`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_de_variant_op` (
  `product_detail_id` bigint NOT NULL,
  `variant_option_id` bigint NOT NULL,
  PRIMARY KEY (`product_detail_id`,`variant_option_id`),
  KEY `FKr177ssdy3y7h09v938d1ue94h` (`variant_option_id`),
  CONSTRAINT `FKe4n4peanqg6yn6415qors51kx` FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`),
  CONSTRAINT `FKr177ssdy3y7h09v938d1ue94h` FOREIGN KEY (`variant_option_id`) REFERENCES `variation_option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_de_variant_op`
--

LOCK TABLES `product_de_variant_op` WRITE;
/*!40000 ALTER TABLE `product_de_variant_op` DISABLE KEYS */;
INSERT INTO `product_de_variant_op` VALUES (1,1),(2,1),(3,1),(7,2),(8,2),(9,2),(10,6),(11,6),(12,6),(13,6),(20,6),(21,6),(22,6),(4,7),(5,7),(6,7),(14,7),(15,7),(16,7),(17,7),(18,7),(19,7),(1,8),(4,8),(7,8),(10,8),(14,8),(18,8),(20,8),(22,8),(2,9),(5,9),(8,9),(11,9),(15,9),(19,9),(21,9),(3,10),(6,10),(9,10),(12,10),(16,10),(13,11),(17,11);
/*!40000 ALTER TABLE `product_de_variant_op` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sku` varchar(30) NOT NULL,
  `price` float NOT NULL,
  `quantity` int NOT NULL DEFAULT '0',
  `sold` int DEFAULT NULL,
  `image` varchar(100) NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `featured` bit(1) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKilxoi77ctyin6jn9robktb16c` (`product_id`),
  CONSTRAINT `FKilxoi77ctyin6jn9robktb16c` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` VALUES (1,'TSM-001-R-S',120000,12,2,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','AA','AA'),(2,'TSM-002-R-M',123000,0,3,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','AA','AA'),(3,'TSM-003-R-L',123000,12,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','AA','AA'),(4,'TSM-004-BL-S',150000,66,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(5,'TSM-005-BL-M',103330,66,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(6,'TSM-006-BL-L',103330,0,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(7,'TSM-007-GR-S',103330,256,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(8,'TSM-008-GR-M',103330,0,34,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(9,'TSM-009-GR-L',103330,44,33,'\'\'',1,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(10,'TSFM-001-W-S',103330,23,2,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(11,'TSFM-002-W-M',103330,33,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(12,'TSFM-003-W-L',103330,12,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(13,'TSFM-004-W-XL',103330,22,67,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(14,'TSFM-005-BL-S',103330,33,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(15,'TSFM-006-BL-M',103330,0,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(16,'TSFM-007-BL-L',103330,33,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(17,'TSFM-008-BL-XL',103330,0,34,'\'\'',2,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(18,'PLM-001-BL-S',103330,12,34,'\'\'',3,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(19,'PLM-002-BL-M',103330,0,34,'\'\'',3,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(20,'PLM-003-W-S',103330,22,34,'\'\'',3,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(21,'PLM-004-W-M',103330,155,34,'\'\'',3,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung'),(22,'PLFM-001-W-S',103330,0,34,'\'\'',3,_binary '',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007','Hung','Hung');
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `type` bit(1) NOT NULL,
  `value` decimal(38,2) DEFAULT NULL,
  `max_spend` decimal(38,2) DEFAULT NULL,
  `min_spend` decimal(38,2) DEFAULT NULL,
  `quantity_used` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'MAGD093','Tet',_binary '',50000.00,500000.00,400000.00,2,1,NULL,NULL,NULL,NULL),(2,'GIAMGIA60','AA60',_binary '\0',60.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'GIAMGIA30','AA',_binary '\0',30.00,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),(4,'GIAMGIA45','AA45',_binary '\0',45.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'GIAMGIA43','AA43',_binary '\0',43.00,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `status` int DEFAULT NULL,
  `description` varchar(250) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl65dyy5me2ypoyj8ou1hnt64e` (`category_id`),
  CONSTRAINT `FKl65dyy5me2ypoyj8ou1hnt64e` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'Áo polo','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(2,'Áo polo','\'\'',13,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(3,'Áo polo','\'\'',14,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(4,'Áo polo','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(5,'Áo T-Shirt','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(6,'Áo T-Shirt','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(7,'Áo T-Shirt','\'\'',13,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(8,'Áo T-Shirt','\'\'',14,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(9,'Áo nỉ','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(10,'Áo nỉ','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(11,'Áo nỉ','\'\'',13,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(12,'Áo nỉ','\'\'',14,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(13,'Áo sơ mi','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(14,'Áo sơ mi','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(15,'Áo sơ mi','\'\'',13,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(16,'Áo chống nắng','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(17,'Áo chống nắng','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(18,'Áo len','\'\'',5,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(19,'Áo len','\'\'',11,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(20,'Áo len','\'\'',13,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(21,'Quần âu','\'\'',6,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(22,'Quần âu','\'\'',15,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(23,'Quần jean','\'\'',6,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(24,'Quần jean','\'\'',15,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(25,'Quần short','\'\'',6,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(26,'Quần short','\'\'',15,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(27,'Quần short','\'\'',16,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(28,'Chân váy','\'\'',9,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(29,'Bộ vest','\'\'',7,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(30,'Bộ đồ hè','\'\'',7,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(31,'Bộ nỉ','\'\'',7,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(32,'Chân váy','\'\'',10,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(33,'Váy bé gái','\'\'',10,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(34,'Bộ đồ nữ','\'\'',17,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(35,'Bộ nỉ cổ tròn','\'\'',17,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(36,'Bộ xuân hè','\'\'',18,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(37,'Bộ thu đông','\'\'',18,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(38,'Cà vạt','\'\'',8,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007'),(39,'Dây lưng','\'\'',8,1,'none','2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `password_hash` varchar(60) NOT NULL,
  `activated` bit(1) NOT NULL,
  `reset_date` datetime(6) DEFAULT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hungSilver','hungsilvertq1@gmail.com',NULL,'string','string','string','$2a$10$sgzGyPvQGQaTiAy45YHv4udKdZUmLp4lMb5aHkiK1R8xoVf4xPS6i',_binary '',NULL,NULL,NULL,'ROLE_ANONYMOUS','ROLE_ANONYMOUS',NULL,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` bigint NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `FK6ktglpl5mjosa283rvken2py5` (`authority_name`),
  CONSTRAINT `FK6ktglpl5mjosa283rvken2py5` FOREIGN KEY (`authority_name`) REFERENCES `authority` (`name`),
  CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variation`
--

DROP TABLE IF EXISTS `variation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `variation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `is_tier_variation` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variation`
--

LOCK TABLES `variation` WRITE;
/*!40000 ALTER TABLE `variation` DISABLE KEYS */;
INSERT INTO `variation` VALUES (1,'màu sắc',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',1),(2,'size',1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',1),(3,'chất liệu',1,NULL,NULL,0),(4,'xuất xứ',1,NULL,NULL,0);
/*!40000 ALTER TABLE `variation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variation_option`
--

DROP TABLE IF EXISTS `variation_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `variation_option` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` varchar(150) NOT NULL,
  `variation_id` bigint DEFAULT NULL,
  `status` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `asset_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlfkypq92cr21b9mtc7mihks1e` (`variation_id`),
  KEY `FKlnawnjvb9x564dpxrksq3t9n9` (`asset_id`),
  CONSTRAINT `FKlfkypq92cr21b9mtc7mihks1e` FOREIGN KEY (`variation_id`) REFERENCES `variation` (`id`),
  CONSTRAINT `FKlnawnjvb9x564dpxrksq3t9n9` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variation_option`
--

LOCK TABLES `variation_option` WRITE;
/*!40000 ALTER TABLE `variation_option` DISABLE KEYS */;
INSERT INTO `variation_option` VALUES (1,'đỏ',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(2,'xanh',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(3,'vàng',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(4,'tím',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(5,'hồng',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(6,'trắng',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(7,'đen',1,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(8,'S',2,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(9,'M',2,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(10,'L',2,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(11,'XL',2,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(12,'XXL',2,1,'2024-03-05 16:37:47.040007','2024-03-05 16:37:47.040007',NULL),(13,'polyeste',3,1,NULL,NULL,NULL),(14,'da',3,1,NULL,NULL,NULL),(15,'Việt Nam',4,1,NULL,NULL,NULL),(16,'trung quốc',4,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `variation_option` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-26 14:48:28
