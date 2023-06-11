CREATE DATABASE  IF NOT EXISTS `swpp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `swpp`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: swpp
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
  `cartID` int NOT NULL AUTO_INCREMENT,
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
  `categoryID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'earphone',_binary ''),(2,'keyboard',_binary ''),(3,'mouse',_binary ''),(4,'phone',_binary '\0'),(5,'laptop',_binary '\0'),(6,'bat',_binary '\0');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `earphone`
--

DROP TABLE IF EXISTS `earphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `earphone` (
  `earphoneID` int NOT NULL AUTO_INCREMENT,
  `type` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `frequency` float DEFAULT NULL,
  `sensitive` float DEFAULT NULL,
  `empedance` float DEFAULT NULL,
  `meterial` varchar(100) DEFAULT NULL,
  `earphone_ProductID` int DEFAULT NULL,
  PRIMARY KEY (`earphoneID`),
  KEY `ProductID_idx` (`earphone_ProductID`),
  CONSTRAINT `earphone_productID` FOREIGN KEY (`earphone_ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `earphone`
--

LOCK TABLES `earphone` WRITE;
/*!40000 ALTER TABLE `earphone` DISABLE KEYS */;
INSERT INTO `earphone` VALUES (1,'Wireless',20000,111,32000,'Khung kim loại, đệm tai xốp Foam',1),(2,'Wireless',20000,87.5,36,'Khung kim loại',2),(3,'Wired',28000,100,32,'Khung inox',3),(4,'Console',28000,109,32,'Khung kim loại',4),(5,'Wired ',40000,40,32,'Khung kim loại',5),(6,'Wired ',20000,112,32,'Khung inox',6),(7,'Wired ',20000,114,32,'Khung kim loại',7);
/*!40000 ALTER TABLE `earphone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `FeedbackID` int NOT NULL AUTO_INCREMENT,
  `FeedbackID_ProductID` int DEFAULT NULL,
  `feedbackID_userID` int DEFAULT NULL,
  `information` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`FeedbackID`),
  KEY `ProductID_idx` (`FeedbackID_ProductID`),
  KEY `feedback_userID_idx` (`feedbackID_userID`),
  CONSTRAINT `feedback_productID` FOREIGN KEY (`FeedbackID_ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `feedback_userID` FOREIGN KEY (`feedbackID_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `messageID` int NOT NULL AUTO_INCREMENT,
  `message_userID` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`messageID`),
  KEY `message_userID_idx` (`message_userID`),
  CONSTRAINT `message_userID` FOREIGN KEY (`message_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `orderID` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `orderdetailID` int NOT NULL AUTO_INCREMENT,
  `orderdetail_orderID` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `orderdetail_productID` int DEFAULT NULL,
  `rate` float DEFAULT NULL,
  PRIMARY KEY (`orderdetailID`),
  KEY `orderdetial_orderID_idx` (`orderdetail_orderID`),
  KEY `orderdetail_productID_idx` (`orderdetail_productID`),
  CONSTRAINT `orderdetail_productID` FOREIGN KEY (`orderdetail_productID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `orderdetial_orderID` FOREIGN KEY (`orderdetail_orderID`) REFERENCES `order` (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,1,2,NULL,1,NULL),(2,2,4,NULL,1,NULL),(3,3,1,NULL,1,NULL),(4,4,1,NULL,2,NULL),(5,5,4,NULL,2,NULL),(6,6,2,NULL,3,NULL),(7,7,2,NULL,4,NULL),(8,8,5,NULL,5,NULL);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ProductID` int NOT NULL AUTO_INCREMENT,
  `product_categoryID` int DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `desciption` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci,
  `picture` varchar(255) DEFAULT NULL,
  `picture2` varchar(255) DEFAULT NULL,
  `picture3` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `sale` float DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `product_categoryID_idx` (`product_categoryID`),
  CONSTRAINT `product_categoryID` FOREIGN KEY (`product_categoryID`) REFERENCES `category` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Corsair HS70',' Corsair HS70 Pro Wireless Caron là dòng tai nghe máy tính có phần đệm tai mềm mại, dày dặn, độ sâu lớn, trùm kín tai hạn chế âm thanh từ ên ngoài lọt vào, cùng với độ ền cao, độ đàn hồi lớn ít ị iến dạng và khó rách. ','https://product.hstatic.net/200000722513/product/thumtainghe_438543858545e8683a4e1ccf1d67_1898e6f48834e80a6249d87d9839073_master.png','https://product.hstatic.net/200000722513/product/he-corsair-hs70-pro-wireless-caron-2_3855186e6a3e4f74f4f15d9dc36990d_c3ff6691a24c7c963acfe1e4c0_master.jpg','https://product.hstatic.net/200000722513/product/he-corsair-hs70-pro-wireless-caron-3_a19343fe746f59c4e4f486971ea2_fee978ad3a344dccd22e56923d397f_master.jpg',1790000,10,_binary '',NULL),(2,1,'Logitech G535 LIGHTSPEED','Tai nghe Logitech G535 LIGHTSPEED Wireless lack sở hữu thiết kế không dây tiện lợi, hiệu suất hoạt động tốt với độ trễ thấp. Hứa hẹn sẽ là một trong những chiếc tai nghe gaming tuyệt vời đồng hành cùng ạn trong những lần tham chiến căng thẳng. ','https://product.hstatic.net/200000722513/product/tech-g535-lightspeed-wireless-lack-1_4185ee7505e341c3a8ad512c870091_5190e6a3a164f1cdc92e83d9f7d68e_master.png','https://product.hstatic.net/200000722513/product/tech-g535-lightspeed-wireless-lack-1_4185ee7505e341c3a8ad512c870091_5190e6a3a164f1cdc92e83d9f7d68e_master.png','https://product.hstatic.net/200000722513/product/tech-g535-lightspeed-wireless-lack-2_f158e8d3772e49dea388076a834a1382_1c0edcdd27f84c4aac914a0414d1af3_master.jpg',2550000,1004,_binary '',NULL),(3,1,'Razer lackShark V2 X White','Razer lackShark V2 X dòng tai nghe máy tính chơi game sở hữu âm thanh mạnh mẽ, chống ồn giúp người chơi chìm đắm trong không gian chơi game đa sắc màu. Đồng thời với thiết kế ấn tượng, độc đáo cùng tông màu sang trọng giúp chiếc tai nghe thêm phần nổi ật.','https://product.hstatic.net/200000722513/product/thumtainghe_fdcc35850a249d492068ddd434f69c_2da37c337c20423f983e3e34e93252d_master.gif','https://product.hstatic.net/200000722513/product/adset_trang_rz04_03240700_r3m1_0003_4_4f0ef110cc8a4fad853f48582361574_52a43736985944a88cd84dc0ff000d3_master.jpg','https://product.hstatic.net/200000722513/product/adset_trang_rz04_03240700_r3m1_0002_3_01c2e278fd14347a2556cca1fd1d18e_025d9ef5d2e845f590449f196aaee1_master.jpg',1190000,200,_binary '\0',NULL),(4,1,'Razer Kraken X','Tai nghe chụp tai Razer Kraken X for Console hứa hẹn mang đến những trải nghiệm nghe thoải mái cho người dùng. Thiết kế kiểu dáng đẹp mắt, âm thanh chất lượng đáp ứng mọi nhu cầu chơi game hằng ngày. ','https://product.hstatic.net/200000722513/product/tai-nghe-razer-kraken-x-for-console-1_762ca5861e534168804c620c290c02f_a0e64c763414c699789c6d480e6ec_master.png','https://product.hstatic.net/200000722513/product/tai-nghe-razer-kraken-x-for-console-2_1ed910381304f9002c3a072311fa0_d2f5727ffacc4514833a338f12063021_master.png','https://product.hstatic.net/200000722513/product/tai-nghe-razer-kraken-x-for-console-3_1c1366e9c04ae5aa551384a8ddc031_697017a07704d7ca4f582c23f6cd5_master.png',699000,310,_binary '',NULL),(5,1,'Asus ROG Delta S Animate','Tai nghe Asus ROG Delta S Animate là một trong những siêu phẩm tai nghe máy tính đình đám của ông hoàng Asus. Thiết kế tai nghe chụp tai đẹp mắt, chất lượng âm thanh sống động cùng hệ thống đèn LED hiện đại đã tạo nên một Asus ROG Delta S Animate vô cùng ấn tượng và là một gaming gear đáng sở hữu.','https://product.hstatic.net/200000722513/product/h732__2__46d3c8ea64749379d6357f6d4316199_dae399921c2343de97cd91a919396e8f_master.png','https://product.hstatic.net/200000722513/product/h732__4__668521a96d41e182fd3e20d7d30_f334f205a3d6401585a33e09fe5f6a1f_master.png','https://product.hstatic.net/200000722513/product/h732__3__a2104aaca6754c6448f04391919425_553ed7930d43879083d9e41fae7449_master.png',5690000,12,_binary '',NULL),(6,1,'Zidli FCore FH11L RG 7.1','Tai nghe máy tính Zidli FCore FH11L RG 7.1 lack được thiết kế với phong cách khá đơn giản toát lên sự thanh lịch quý phái, sang trọng. Các đường nét của tai nghe được làm vô cùng chỉnh chu, cùng hiệu ứng đèn LED 2 ên tai nghe vô cùng ắt mắt.','https://product.hstatic.net/200000722513/product/-nghe-zidli-fcore-fh11l-rg-7-1-lack_33fed40468540fc771759a417f176_2293f33c23c4484888108dfd11027c7_master.jpg','https://product.hstatic.net/200000722513/product/ghe-zidli-fcore-fh11l-rg-7-1-lack-1_013af66ae84e968c6c594457691d6_44378cfeed34df9d92a2748ecf069_master.jpg','https://product.hstatic.net/200000722513/product/ghe-zidli-fcore-fh11l-rg-7-1-lack-2_5f72199fe5c84735ac405dd666808766_08eff286a3314d118738a94089033a9_master.jpg',370000,12,_binary '',NULL),(7,1,'Corsair HS55 Stereo White','Corsair được iết đến là một trong những hãng chuyên sản xuất các dòng sản phẩm gaming gear chất lượng được người dùng tiêu dùng đánh giá cao về hiệu năng lẫn thiết kế từ àn phím, chuột máy tính, tai nghe cho đến ghế gaming. ','https://product.hstatic.net/200000722513/product/thumtainghe-recovered_2_e58c6226a844396f19ace0cadaf6f7_67f61c83cada49c38fd5aee5d18cf66_master.png','https://product.hstatic.net/200000722513/product/9273_7781da931e979772c11c38ded18cf28_cdedc8158c74084166484c877ecc8_f5540e83e0dc46ee381d7a7404688_master.jpg','https://product.hstatic.net/200000722513/product/9259_8e2e145947057065632d71f619f149_e89ecdecf3a8405aa2c2d7d0173514_e7716af71d8742958f487c0ac11d0019_master.jpg',1250000,66,_binary '',NULL),(8,2,'àn phím cơ AKKO 5075 Plus Dragon all Super Goku','Nổi tiếng với những chiếc gaming gear chất lượng, Akko là thương hiệu rất nhiều người dùng đặt niềm tin nhờ vào những thành phẩm chất lượng, đặc iệt là àn phím cơ. ao phủ gần như mọi phân khúc trong ngành hàng này, những chiếc àn phím từ Akko sở hữu độ cứng cáp và hoàn thiện ở cấp độ cao. Và hôm nay GEARVN sẽ mang tới model AKKO 5075 Plus Dragon all Super Goku đặc iệt từ chính thương hiệu Trung Quốc.','https://product.hstatic.net/1000026716/product/thumphim_d829ff88d74d4aa105793cd37dd09.gif','https://product.hstatic.net/1000026716/product/gearvn-an-phim-co-akko-5075-plus-dragon-all-super-goku-1_2048c56edd24f07ace36a79135aa009.jpg','https://product.hstatic.net/1000026716/product/gearvn-an-phim-co-akko-5075-plus-dragon-all-super-goku-2_11825f3c2fea4d089daeac211757de.jpg',2799000,13,_binary '',NULL),(9,2,'Leopold FC900RT luetooth Coral lue Limited Edition','Một trong những thương hiệu àn phím cơ đáng sở hữu trên thị trường không thể không nhắc đến là Leopold. Các sản phẩm được sản xuất từ Hàn Quốc theo đuổi phong cách cổ điển cùng cảm giác ấm mới lạ đã làm nên sự thành công của thương hiệu, Leopold FC900RT luetooth Coral lue Limited Edition là một trong số đó.','https://product.hstatic.net/1000026716/product/thumphim_a8c25480de444a5837e6f119d.png','https://product.hstatic.net/1000026716/product/earvn-an-phim-leopold-fc900rt-luetooth-coral-lue-limited-edition-1_d6754d5ffe5442678a4850726ec992ee.jpg','https://product.hstatic.net/1000026716/product/earvn-an-phim-leopold-fc900rt-luetooth-coral-lue-limited-edition-2_1250d5c70444d28433991afe00.jpg',3490000,2,_binary '',NULL),(10,2,'àn Phím Cơ Vortex PC66 (68 Key)','Vortex PC66 (68%) là dòng àn phím máy tính mang đậm màu sắc của “hoài cổ” với tông màu chủ đạo trắng ngọc trai và xám tạo nên tổng thể vô cùng hài hòa, độc đáo. Tính năng kết nối đa dạng, dễ dàng tương thích trên nhiều thiết ị,.','https://product.hstatic.net/1000026716/product/ktre68-1_1080x_ee6240d275946323996d1913f302.png','https://product.hstatic.net/1000026716/product/gearvn-an-phim-co-vortex-kt-re-68-retro-1_50d242422a8410e6f0238ea4d9e22.jpg','https://product.hstatic.net/1000026716/product/gearvn-an-phim-co-vortex-kt-re-68-retro-2_947d4857014496743dd12467c158f.jpg',2790000,11,_binary '',NULL),(11,2,'IKC CD87HR','IKC CD87HR là chiếc àn phím cơ vừa ra mắt vào tháng 8/2022 từ nhà IKC. Mang đến cho người dùng công cụ hỗ trợ công việc với thao tác nhấn phím nhanh và thoải mái. Cùng với đó là mức giá hợp lý đáp ứng nhiều nhu cầu sử dụng. ','https://product.hstatic.net/1000026716/product/hinh-1-white_3d772a2c05a140e1818e8e387c420dd3.gif','https://product.hstatic.net/1000026716/product/hinh-1-white_3d772a2c05a140e1818e8e387c420dd3.gif','https://product.hstatic.net/1000026716/product/gearvn-an-phim-ikc-cd87hr-3_35826c24c1e84f64ae31c006f43ed3c.png',1750000,1,_binary '',NULL),(12,2,'àn phím Mistel X8 Nimitz','Mistel được xem là một trong những hãng chuyên mang đến các dòng àn phím cơ chất lượng với giá thành vô cùng hợp lý phù hợp với người dùng phổ thông và dân văn phòng. Các dòng àn phím đến từ hãng luôn sở hữu thiết kế đơn giản nhưng vô cùng sang trọng và đẳng cấp.','https://product.hstatic.net/1000026716/product/sdfgsdfsd_944433d08d5440c972ee8888213e777.png','https://product.hstatic.net/1000026716/product/carousel_1_1651638273_d93081e7cfc42d98e639adcf935d5c.png','https://product.hstatic.net/1000026716/product/carousel_2_1651638273_fc5de2a5961d40a8a83578869296ade5.png',2100000,3,_binary '',NULL),(19,3,'Chuột Gaming Havit MS878','Havit MS878 là dòng chuột chơi game sở hữu thiết kế ấn tượng, độc đáo mang đến những trải nghiệm chơi game tuyệt vời. Ngoài ra, MS878 còn là một trong những dòng chuột Havit có thể điều chỉnh DPI, led RG và nhiều tính năng hỗ trợ cho mọi nhu cầu sử dụng một cách dễ dàng. ','https://product.hstatic.net/200000722513/product/8a10-95ac-4e6d-9e50-2808c2959505__1__15430e9a7a954cd9a4427309477c0df_e869da53af56496c9c74617366a28e2_master.png','https://product.hstatic.net/200000722513/product/19ecd-e9e-409d-ad6-cee76439d730__1__0ef927efc6e43889037e14c743c5e_eca058454c540deda47d496ca88c_master.jpg','https://product.hstatic.net/200000722513/product/-6858fd8e-556f-470-809f-7e5563c76a68_22a56e0f2d14d7688fd127ed1f98e5_7ca012f26014daa31813d7828fd93_master.jpg',250000,3,_binary '',NULL),(20,3,'Chuột Logitech G502 Hero','Ngoài hiệu suất cốt lõi và các tính năng cá nhân, nhiều chi tiết được thiết kế và chế tạo với sự tận tâm. Logitech G502 Hero là một trong những dòng chuột gaming giá rẻ so với các sản phẩm ở cùng phân khúc với dây ện với nút uộc dây có khóa nhám, phần cầm nắm ên có viền cao su, cửa từ vào khoang để khối nặng và nhiều hơn nữa.','https://product.hstatic.net/1000026716/product/avatar_8473e44966416897cc4a9179da4596.png','https://product.hstatic.net/1000026716/product/gearvn_logitech_g502hero.png','https://product.hstatic.net/1000026716/product/high_resolution_logitech-g502-hero-left-profile-edited-100770385-large.jpg',899000,67,_binary '',NULL),(21,3,'Chuột Logitech G502 X Plus LightSpeed White','Chuột Logitech G502 X PLUS White là sản phẩm mới nhất của series G502 đình đám. Được thiết kế lại và cải tiến với công nghệ chơi game hiện đại, ao gồm công tắc Lightforce lai quang học - cơ học đầu tiên, Lightspeed không dây, LIGHT SYNC RG và cảm iến quang học Hero 25K, Logitech G502 X PLUS chắc chắn là một trong những gaming gear đáng mua nhất cho game thủ thời gian sắp tới.','https://product.hstatic.net/1000026716/product/gearvn-chuot-logitech-g502-x-plus-lightspeed-white-1_2839440723544aa411497814f5043.jpg','https://product.hstatic.net/1000026716/product/gearvn-chuot-logitech-g502-x-plus-lightspeed-white-2_090a6410c89c4d26adc50edaa35ec0a.jpg','https://product.hstatic.net/1000026716/product/gearvn-chuot-logitech-g502-x-plus-lightspeed-white-3_a86f524774564f479085f04c0f2d1aa8.jpg',1200000,24,_binary '',NULL),(22,3,'Chuột chơi game ZOWIE EC3-C','Chuột và àn phím Zowie luôn là sự lựa chọn hàng đầu của nhiều game thủ khi tìm cho mình những dòng sản phẩm chất lượng chiến được mọi tựa game.','https://product.hstatic.net/1000026716/product/thumchuot_f5d10e6f7924de44017ee7cf5a5.png','https://product.hstatic.net/1000026716/product/z3119259393470_39677ee7f7e1fe87f6f0f2e70a6222_724a9df923844a983a39c823dd88022.jpg','https://product.hstatic.net/1000026716/product/z3119259386719_2a6349c167a9cf65eca3a7a4232e2c_af08cd00ee44dd382c1fa0014883f84.jpg',1590000,15,_binary '',NULL),(23,3,'Chuột Logitech G705 Off White','Những dòng chuột Logitech luôn là sự lựa chọn số 1 của hàng triệu người dùng từ các dòng chuột văn phòng đến chuột Gaming với nhiều tính năng nổi ật. Trong đó, Logitech G705 là một trong những sản phẩm chuột máy tính không dây thiết kế nhỏ gọn nhưng vẫn đáp ứng tốt mọi nhu cầu từ người tiêu dùng.','https://product.hstatic.net/1000026716/product/g705-gallery-3_de00421261634884ae13a556cd374ff.png','https://product.hstatic.net/1000026716/product/g705-gallery-3_de00421261634884ae13a556cd374ff.png','https://product.hstatic.net/1000026716/product/gearvn-chuot-logitech-g705-off-white-2_9806d37de98440ad990cfa77e5320a18.jpg',2190000,24,_binary '',NULL),(24,3,'Chuột Logitech MX Anywhere 3 for usiness Pale Grey','Logitech MX Anywhere dòng chuột văn phòng không dây tiện lợi, dễ dàng mang đi và sử dụng ở ất kỳ đâu. Sở hữu kiểu dáng đối xứng ôm sát lòng àn tay giúp mọi thao tác sử dụng chuột thêm phần tiện lợi.','https://product.hstatic.net/1000026716/product/mx-anywhere-3-portale-usiness-mouse-gallery-pale-gray-6_2d988f438eee43998dc855d3ea74a36.png','https://product.hstatic.net/1000026716/product/mx-anywhere-3-portale-usiness-mouse-gallery-pale-gray-5_da8d2dd55e094a5ea6180f24a6639.png','https://product.hstatic.net/1000026716/product/mx-anywhere-3-portale-usiness-mouse-gallery-pale-gray-4_83c666c299646fecaa51f7922454a.png',1999000,21,_binary '',NULL);
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
  `salecodeID` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`salecodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `sexID` int NOT NULL,
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
  `shippingID` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`shippingID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `userID` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2023-06-11 21:13:56
