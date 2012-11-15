CREATE DATABASE  IF NOT EXISTS `grafos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grafos`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: grafos
-- ------------------------------------------------------
-- Server version	5.5.17

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
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidades` (
  `idCidades` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `Populacao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCidades`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (1,'Palmas','228297'),(2,'Araguaina','150520'),(3,'Gurupi','76765'),(4,'Porto Nacional','49143'),(5,'Paraiso do Tocantins','44432'),(6,'Araguatins','31324'),(7,'Colinas do Tocantins','30879'),(8,'Guarai','23212'),(9,'Tocantinopolis','22608'),(10,'Miracema do Tocantins','20692'),(11,'Dianopolis','19110'),(12,'Formoso do Araguaia','18428'),(13,'Augustinopolis','15965'),(14,'Taguatinga','15053'),(15,'Miranorte','12626'),(16,'Goiatins','12064'),(17,'Pedro Afonso','11542'),(18,'Xambioa','11484'),(19,'Wanderlandia','10978'),(20,'Nova Olinda','10686'),(21,'Arraias','10643'),(22,'Sao Miguel do Tocantins','10490'),(23,'Babaçulandia','10446'),(24,'Peixe','10389'),(25,'Parana','10335'),(26,'Lagoa da Confusao','10215'),(27,'Ananas','9873'),(28,'Buriti do Tocantins','9770'),(29,'Esperantina','9476'),(30,'Axixa do Tocantins','9275'),(31,'Sitio Novo do Tocantins','9148'),(32,'Natividade','9000'),(33,'Araguacu','8786'),(34,'Colmeia','8607'),(35,'Filadelfia','8502'),(36,'Alvorada','8380'),(37,'Campos Lindos','8139'),(38,'Praia Norte','7661'),(39,'Almas','7595'),(40,'Palmeiropolis','7342'),(41,'Cristalandia','7218'),(42,'Ponte Alta do Tocantins','7180'),(43,'Dois Irmaos do Tocantins','7161'),(44,'Itacaja','7104'),(45,'Arapoema','6742'),(46,'Monte do Carmo','6717'),(47,'Pium','6696'),(48,'Santa Fe do Araguaia','6599'),(49,'Tocantinia','6598'),(50,'Divinopolis do Tocantins','6363'),(51,'Araguacema','6317'),(52,'Rio Sono','6259'),(53,'Itaguatins','6029'),(54,'Aragominas','5882'),(55,'Palmeiras do Tocantins','5746'),(56,'Alianca do Tocantins','5663'),(57,'Barrolandia','5346'),(58,'Figueiropolis','5340'),(59,'Darcinopolis','5273'),(60,'Brejinho de Nazare','5188'),(61,'Aguiarnopolis','5158'),(62,'Silvanopolis','5071'),(63,'Pequizeiro','5052'),(64,'Araguana','5030'),(65,'Couto de Magalhaes','5009'),(66,'Goianorte','4960'),(67,'Palmeirante','4954'),(68,'Combinado','4669'),(69,'Sao Bento do Tocantins','4615'),(70,'Caseara','4601'),(71,'Duere','4589'),(72,'Pau d\'Arco','4588'),(73,'Santa Rosa do Tocantins','4568'),(74,'Ponte Alta do Bom Jesus','4548'),(75,'Pindorama do Tocantins','4506'),(76,'Bernardo Sayao','4467'),(77,'Nazare','4386'),(78,'Sao Valerio da Natividade','4384'),(79,'Marianopolis do Tocantins','4352'),(80,'Sao Sebastiao do Tocantins','4283'),(81,'Aparecida do Rio Negro','4213'),(82,'Riachinho','4183'),(83,'Conceicao do Tocantins','4182'),(84,'Barra do Ouro','4123'),(85,'Sampaio','3868'),(86,'Fatima','3805'),(87,'Nova Rosalandia','3770'),(88,'Bom Jesus do Tocantins','3768'),(89,'Recursolandia','3768'),(90,'Novo Acordo','3762'),(91,'Cariri do Tocantins','3754'),(92,'Lizarda','3731'),(93,'Carrasco Bonito','3690'),(94,'Presidente Kennedy','3685'),(95,'Itapiratins','3534'),(96,'Lagoa do Tocantins','3525'),(97,'Jau do Tocantins','3507'),(98,'Aurora do Tocantins','3446'),(99,'Sandolandia','3326'),(100,'Chapada da Natividade','3280'),(101,'Angico','3169'),(102,'Maurilandia do Tocantins','3158'),(103,'Muricilandia','3152'),(104,'Bandeirantes do Tocantins','3124'),(105,'Piraque','2920'),(106,'Sao Salvador do Tocantins','2910'),(107,'Santa Maria do Tocantins','2894'),(108,'Porto Alegre do Tocantins','2795'),(109,'Lajeado','2773'),(110,'Luzinopolis','2622'),(111,'Rio dos Bois','2570'),(112,'Centenario','2565'),(113,'Talisma','2562'),(114,'Santa Tereza do Tocantins','2523'),(115,'Santa Terezinha do Tocantins','2471'),(116,'Novo Jardim','2457'),(117,'Itapora do Tocantins','2439'),(118,'Fortaleza do Tabocao','2423'),(119,'Abreulandia','2387'),(120,'Pugmil','2366'),(121,'Carmolandia','2305'),(122,'Novo Alegre','2286'),(123,'Juarina','2231'),(124,'Mateiros','2219'),(125,'Cachoeirinha','2148'),(126,'Santa Rita do Tocantins','2128'),(127,'Tupiratins','2097'),(128,'Monte Santo do Tocantins','2085'),(129,'Brasilandia do Tocantins','2066'),(130,'Taipas do Tocantins','1945'),(131,'Sucupira','1739'),(132,'Rio da Conceicao','1714'),(133,'Ipueiras','1639'),(134,'Lavandeira','1605'),(135,'Tupirama','1574'),(136,'Crixas do Tocantins','1566'),(137,'Sao Felix do Tocantins','1445'),(138,'Chapada de Areia','1335'),(139,'Oliveira de Fatima','1035');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-14 16:55:54
