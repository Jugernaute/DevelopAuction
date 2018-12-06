-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: auction
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategory` (
  `id_SubCategory` int(11) NOT NULL AUTO_INCREMENT,
  `nameSubCategory` varchar(255) DEFAULT NULL,
  `commonCategory_id_CommonCategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_SubCategory`),
  KEY `FKiy6libtkx76w4et8bs6rhewy4` (`commonCategory_id_CommonCategory`),
  CONSTRAINT `FKiy6libtkx76w4et8bs6rhewy4` FOREIGN KEY (`commonCategory_id_CommonCategory`) REFERENCES `commoncategory` (`id_CommonCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,'Автозапчастини',1),(2,'Електрика, автоприбори',1),(3,'Автоаксесуари',1),(4,'Автомагнітоли',1),(5,'GPS пристрої',1),(6,'Відеореєстратори',1),(7,'Світотехніка',1),(8,'Шини',1),(9,'Диски, ковпаки',1),(10,'Обладнання для СТО',1),(11,'Тюнінг',1),(12,'Аудіо-Відео, автозвук',1),(13,'Мототовари',1),(14,'Транспортні засоби',1),(15,'Телефони, сматрфони',2),(16,'Аксесуари і комплектуючі',2),(17,'Стартові пакети',2),(18,'Ноутбуки',3),(19,'Комплектуючі для ноутбуків',3),(20,'Системні блоки, ПК',3),(21,'Комплектуючі для ПК',3),(22,'Планшети',3),(23,'Аксесуари для планшетів',3),(24,'Мережеве обладнання',3),(25,'Принтери, МФУ, Оргтехніка',3),(26,'Монітори',3),(27,'Мишки, клавіатура',3),(28,'Флешки, диски',3),(29,'Електронні книжки',3),(30,'Аудіо, Радіо',4),(31,'Побутова техніка',4),(32,'Музичні інструменти',4),(33,'ТВ, Відео',4),(34,'Фототехніка і Оптика',4),(35,'Велосипеди і аксесуари до них',5),(36,'Все для відпочинку, туризм',5),(37,'Спортінвентар',5),(38,'Риболовство',5),(39,'Прибори і пристрої',5),(40,'Спортивне харчування',5),(41,'Тренажери',5),(42,'Охота',5),(43,'Здоровя',5),(44,'Косметика і парфумерія',6),(45,'Одежа, Взуття, Аксесуари',6),(46,'Ювелірні вироби, Біжутерія',6),(47,'Годинники і аксесуари',6),(48,'Ігри, ігрушки',7),(49,'Одежа',7),(50,'Взуття',7),(51,'Санки',7),(52,'Коляски',7),(53,'Автокрісла',7),(54,'Дитячий транспорт',7),(55,'Дитяча кімната',7),(56,'Здоровя, гігієна',7),(57,'Канцтовари',7),(58,'Дитяча література',7),(59,'Монети України із дорогоцінних сплавів',8),(60,'Нумізматика',8),(61,'Медалі, значки, жетони',8),(62,'Колекційна зброя',8),(63,'Масштабні моделі',8),(64,'Боністика',8),(65,'Скульптури',8),(66,'Столове срібло',8),(67,'Картини, меблі',8),(68,'Книги',8);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 17:48:31
