use  swpp;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: swp
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartID` int AUTO_INCREMENT NOT NULL,
  ` title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `totalcost` int DEFAULT NULL,
  `productID` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`cartID`),
  KEY `ProductID_idx` (`productID`),
  KEY `userID_idx` (`userID`),
  CONSTRAINT `ProductID` FOREIGN KEY (`productID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryID` int AUTO_INCREMENT NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'earphone',_binary ''),(2,'keyboard',_binary ''),(3,'mouse',_binary ''),(4,'phone',_binary '\0');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `earphone`
--

DROP TABLE IF EXISTS `earphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `earphone` (
  `earphoneID`  int AUTO_INCREMENT NOT NULL,
  `type` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `frequency` float DEFAULT NULL,
  `sensitive` float DEFAULT NULL,
  `empedance` float DEFAULT NULL,
  `control` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `earphone_ProductID` int DEFAULT NULL,
  PRIMARY KEY (`earphoneID`),
  KEY `ProductID_idx` (`earphone_ProductID`),
  CONSTRAINT `earphone_productID` FOREIGN KEY (`earphone_ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `earphone`
--

LOCK TABLES `earphone` WRITE;
/*!40000 ALTER TABLE `earphone` DISABLE KEYS */;
INSERT INTO `earphone` VALUES (1,'headset',1500,0,20,'1',NULL,1),(2,'headset',1000,5,2,'4',NULL,2),(3,'bluetooth',500,3,2,'3',NULL,3),(4,'normal',1500,2,20,'3',NULL,4);
/*!40000 ALTER TABLE `earphone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `FeedbackID` int AUTO_INCREMENT NOT NULL,
  `FeedbackID_ProductID` int DEFAULT NULL,
  `feedbackID_userID` int DEFAULT NULL,
  `information` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`FeedbackID`),
  KEY `ProductID_idx` (`FeedbackID_ProductID`),
  KEY `feedback_userID_idx` (`feedbackID_userID`),
  CONSTRAINT `feedback_productID` FOREIGN KEY (`FeedbackID_ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `feedback_userID` FOREIGN KEY (`feedbackID_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,7,'ok',_binary ''),(2,2,7,'good',_binary ''),(3,12,8,'damn~',_binary '');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `messageID` int AUTO_INCREMENT NOT NULL,
  `message_userID` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`messageID`),
  KEY `message_userID_idx` (`message_userID`),
  CONSTRAINT `message_userID` FOREIGN KEY (`message_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,5,_binary '','Cant see shit'),(2,7,_binary '','i want to creat acc'),(3,4,_binary '','No product');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderID` int AUTO_INCREMENT NOT NULL,
  `order_shippingID` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `order_userID` int DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `order_salecodeID` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `order_shippingID_idx` (`order_shippingID`),
  KEY `order_userID_idx` (`order_userID`),
  KEY `order_salecodeID_idx` (`order_salecodeID`),
  CONSTRAINT `order_salecodeID` FOREIGN KEY (`order_salecodeID`) REFERENCES `salecode` (`salecodeID`),
  CONSTRAINT `order_shippingID` FOREIGN KEY (`order_shippingID`) REFERENCES `shipping` (`shippingID`),
  CONSTRAINT `order_userID` FOREIGN KEY (`order_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'2023-05-30',6,NULL,1,_binary ''),(2,1,'2023-05-30',6,NULL,1,_binary '\0'),(3,2,'2023-05-30',6,NULL,2,_binary ''),(4,3,'2023-05-30',7,NULL,3,_binary ''),(5,3,'2023-05-30',8,NULL,4,_binary ''),(6,4,'2023-05-30',9,NULL,1,_binary ''),(7,5,'2023-05-30',9,NULL,2,_binary ''),(8,5,'2023-05-30',9,NULL,5,_binary '');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `orderdetailID` int AUTO_INCREMENT NOT NULL,
  `orderdetail_orderID` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `orderdetail_productID` int DEFAULT NULL,
  PRIMARY KEY (`orderdetailID`),
  KEY `orderdetial_orderID_idx` (`orderdetail_orderID`),
  KEY `orderdetail_productID_idx` (`orderdetail_productID`),
  CONSTRAINT `orderdetail_productID` FOREIGN KEY (`orderdetail_productID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `orderdetial_orderID` FOREIGN KEY (`orderdetail_orderID`) REFERENCES `order` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,1,2,NULL,1),(2,2,4,NULL,1),(3,3,1,NULL,1),(4,4,1,NULL,2),(5,5,4,NULL,2),(6,6,2,NULL,3),(7,7,2,NULL,4),(8,8,5,NULL,5);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ProductID` int AUTO_INCREMENT NOT NULL,
  `product_categoryID` int DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `desciption` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `product_categoryID_idx` (`product_categoryID`),
  CONSTRAINT `product_categoryID` FOREIGN KEY (`product_categoryID`) REFERENCES `category` (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'vx150','good for air head',NULL,100,10,_binary ''),(2,1,'vfx200',NULL,NULL,102,1004,_binary ''),(3,1,'vsfx250','upgrade',NULL,99,200,_binary '\0'),(4,1,'Nsfx',NULL,NULL,8,310,_binary ''),(5,2,'redcow','first',NULL,300,0,_binary '\0'),(6,2,'rg360',NULL,NULL,4500,12,_binary ''),(7,2,'nocap','ccp',NULL,22,66,_binary ''),(8,2,'ia',NULL,NULL,33.3,0,_binary ''),(9,3,'legion','s',NULL,88,2,_binary '\0'),(10,3,'jerry',NULL,NULL,6.6,11,_binary '\0'),(11,3,'logitech',NULL,NULL,99,0,_binary ''),(12,4,'sizeM',NULL,NULL,6969,0,_binary '\0');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleID` int NOT NULL,
  `roleName` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Manager'),(3,'User');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salecode`
--

DROP TABLE IF EXISTS `salecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salecode` (
  `salecodeID`  int AUTO_INCREMENT NOT NULL,
  `code` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`salecodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salecode`
--

LOCK TABLES `salecode` WRITE;
/*!40000 ALTER TABLE `salecode` DISABLE KEYS */;
INSERT INTO `salecode` VALUES (1,'jjijfidsj',5,'2023-05-30'),(2,'12bjbqbwe',2,'2023-06-30'),(3,'e21fqw',69,'2023-07-23'),(4,'1313da',60,'2023-08-04'),(5,'fwqeq',42,'2023-09-30');
/*!40000 ALTER TABLE `salecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sex`
--

DROP TABLE IF EXISTS `sex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sex` (
  `sexID` int  NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`sexID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sex`
--

LOCK TABLES `sex` WRITE;
/*!40000 ALTER TABLE `sex` DISABLE KEYS */;
INSERT INTO `sex` VALUES (1,'F'),(2,'M'),(3,'L'),(4,'G'),(5,'B'),(6,'T'),(7,'Q'),(8,'+');
/*!40000 ALTER TABLE `sex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping`
--

DROP TABLE IF EXISTS `shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping` (
  `shippingID`  int AUTO_INCREMENT NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`shippingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping`
--

LOCK TABLES `shipping` WRITE;
/*!40000 ALTER TABLE `shipping` DISABLE KEYS */;
INSERT INTO `shipping` VALUES (1,NULL,'1.1.3.4040'),(2,NULL,'19.2.3.444'),(3,NULL,'wall street'),(4,NULL,'nebraska'),(5,NULL,'thanh hoa');
/*!40000 ALTER TABLE `shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int AUTO_INCREMENT NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_roleID` int DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `user_sexID` int DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `register_code` varchar(150) DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `user_roleID_idx` (`user_roleID`),
  KEY `user_sexID_idx` (`user_sexID`),
  CONSTRAINT `user_roleID` FOREIGN KEY (`user_roleID`) REFERENCES `role` (`roleID`),
  CONSTRAINT `user_sexID` FOREIGN KEY (`user_sexID`) REFERENCES `sex` (`sexID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hoang@fu','1',1,'hoang',17,2,NULL,'0932233424','',NULL,'a@gmail.com',_binary ''),(2,'ha','1',1,'ha',20,3,NULL,'0784888822',NULL,NULL,'ha@gmail.com',_binary '\0'),(3,'dang2012','1',2,'dang',22,2,NULL,'0293929994',NULL,NULL,'dang@gmail.com',_binary ''),(4,'tri2k8','1',2,'tri',18,1,NULL,'0299402888',NULL,NULL,'tri@gmail.com',_binary '\0'),(5,'bestFlo','1',2,'dan',19,1,NULL,'0485003032',NULL,NULL,'dan@gmail.com',_binary ''),(6,'trancalli','1',3,'tran',NULL,3,NULL,'0912827474',NULL,NULL,'tran@gmail.com',_binary ''),(7,'momo','1',3,'dao',NULL,4,NULL,'0288899444',NULL,NULL,'dao@gmail.com',_binary ''),(8,'hunggay','1',3,'hung',NULL,5,NULL,'0494777364',NULL,NULL,'hung@gmail.com',_binary '\0'),(9,'dangnguyen','1',3,'dang',NULL,6,NULL,'0487563344',NULL,NULL,'dangtr@gmail.com',_binary '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-02 10:20:35

