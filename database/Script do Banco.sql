-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: gestoraeventos
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `atividade`
--

DROP TABLE IF EXISTS `atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividade` (
  `idatividade` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) DEFAULT NULL,
  `responsavel` varchar(30) DEFAULT NULL,
  `musico` varchar(30) DEFAULT NULL,
  `genero` varchar(30) DEFAULT NULL,
  `buffet` varchar(30) DEFAULT NULL,
  `tipo_cardapio` varchar(150) DEFAULT NULL,
  `decoracao` varchar(15) DEFAULT NULL,
  `danca` varchar(15) DEFAULT NULL,
  `midia` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idatividade`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade`
--

LOCK TABLES `atividade` WRITE;
/*!40000 ALTER TABLE `atividade` DISABLE KEYS */;
INSERT INTO `atividade` VALUES (1,'Show de Samba com performance dançante','Ana Ribeiro','Grupo Samba Quente','Samba',NULL,NULL,NULL,'Samba no Pé','Ao Vivo'),(2,'Balada Eletrônica com dança urbana','Carlos Andrade','DJ Lara Fox','Eletrônica',NULL,NULL,NULL,'Hip Hop','Pendrive'),(3,'Forró tradicional com casal dançando','Juliana Silva','Trio do Forró','Forró',NULL,NULL,NULL,'Forró','Ao Vivo'),(4,'Noite Pop com dança contemporânea','Fábio Mendes','Banda PopWave','Pop',NULL,NULL,NULL,'Contemporânea','Playback'),(5,'Salsa com dança de salão','Rodrigo Torres','Grupo Latino Caliente','Salsa',NULL,NULL,NULL,'Salsa','Ao Vivo'),(6,'Jantar italiano com massas e risotos','Roberta Souza',NULL,NULL,'La Tavola Buffet','Italiano',NULL,NULL,NULL),(7,'Opção vegetariana com pratos quentes e saladas','Carlos Andrade',NULL,NULL,'Verde Vida Buffet','Vegetariano',NULL,NULL,NULL),(8,'Jantar japonês com sushis e sashimis','Rodrigo Torres',NULL,NULL,'Buffet Oriental Sun','Japonês',NULL,NULL,NULL),(9,'Culinária francesa com entrada refinada','Alberto Mendes',NULL,NULL,'Buffet Paris Class','Francês',NULL,NULL,NULL),(10,'Opção saudável com grelhados e saladas','Joana Prado',NULL,NULL,'Buffet Leve & Sabor','Fit',NULL,NULL,NULL),(11,'Menu vegano com pratos criativos','Bruno Silveira',NULL,NULL,'Veg&Sabor Buffet','Vegano',NULL,NULL,NULL),(12,'Buffet infantil com mini lanches e doces','Pastor Elias',NULL,NULL,'Buffet Alegria','Infantil',NULL,NULL,NULL),(13,'Cardápio nordestino com pratos típicos','Patrícia Lima',NULL,NULL,'Sabores do Sertão','Regional',NULL,NULL,NULL),(14,'Cardápio de churrasco com acompanhamentos','Fábio Mendes',NULL,NULL,'ChurrasTop Eventos','Churrasco',NULL,NULL,NULL),(15,'Serviço à francesa com garçom exclusivo','Diego Rocha',NULL,NULL,'Buffet Imperial','Alta Gastronomia',NULL,NULL,NULL),(16,'Decoração rústica com iluminação aconchegante','Decorarte Eventos',NULL,NULL,NULL,NULL,'Rústica',NULL,'Projeções mapeadas e spots LED'),(17,'Ambiente tropical com painéis verdes e luzes coloridas','Studio Visual',NULL,NULL,NULL,NULL,'Tropical',NULL,'Telões LED exibindo vídeos'),(18,'Espaço moderno com decoração minimalista e luz branca','Lumina Design',NULL,NULL,NULL,NULL,'Minimalista',NULL,'Sistema de som ambiente'),(19,'Tema vintage com elementos retrô e luz amarela suave','Eventos Clássicos',NULL,NULL,NULL,NULL,'Vintage',NULL,'Projeções de imagens antigas'),(20,'Ambiente clean com iluminação dinâmica e decoração neutra','Ambienta Pro',NULL,NULL,NULL,NULL,'Clean',NULL,'Telões e painéis digitais');
/*!40000 ALTER TABLE `atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `codevento` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(30) NOT NULL,
  `plano` varchar(10) NOT NULL,
  `valor_plano` int NOT NULL,
  `atividade` int NOT NULL,
  `local` int NOT NULL,
  `organizador` int NOT NULL,
  `programacao` int NOT NULL,
  PRIMARY KEY (`codevento`),
  KEY `fk_evento_atividade_idx` (`atividade`),
  KEY `fk_evento_local_idx` (`local`),
  KEY `fk_evento_participante_idx` (`organizador`),
  KEY `fk_evento_programacao_idx` (`programacao`),
  CONSTRAINT `fk_evento_atividade` FOREIGN KEY (`atividade`) REFERENCES `atividade` (`idatividade`),
  CONSTRAINT `fk_evento_local` FOREIGN KEY (`local`) REFERENCES `local` (`idlocal`),
  CONSTRAINT `fk_evento_participante` FOREIGN KEY (`organizador`) REFERENCES `organizador` (`idorganizador`),
  CONSTRAINT `fk_evento_programacao` FOREIGN KEY (`programacao`) REFERENCES `programacao` (`idprogramacao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `idlocal` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `capacidade` int NOT NULL,
  `recursos_disponiveis` varchar(300) NOT NULL,
  `acessibilidade` varchar(300) NOT NULL,
  `quantidade_participantes` int NOT NULL,
  PRIMARY KEY (`idlocal`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Espaço Harmonia','Rua das Flores, 123 - Belo Horizonte, MG',150,'Projetor multimídia, Sistema de som, Equipamento para DJ, Equipamento de audiovisual','Banheiros adaptados, Vaga reservada para PCD',98),(2,'Villa Real Eventos','Av. Brasil, 456 - São Paulo, SP',200,'Sistema de som, Banheiros químicos, Mesas e cadeiras, Máquina de fumaça, Gerador de energia','Rampas de acesso para cadeirantes, Banheiros adaptados',172),(3,'Casa Bella Festas','Rua do Sol, 789 - Rio de Janeiro, RJ',100,'Projetor multimídia, Sistema de som, Tela para projeção','Legenda em tempo real',86),(4,'Salão Cristal','Rua Diamante, 55 - Curitiba, PR',250,'Banheiros químicos, Tela para projeção, Mesas e cadeiras','Banheiros adaptados, Elevadores ou plataformas elevatórias, Atendimento prioritário, Legenda em tempo real',143),(5,'Espaço Encanto','Av. Atlântica, 321 - Recife, PE',180,'Sistema de som, Estrutura para apresentações, Banheiros químicos, Microfone sem fio, Máquina de fumaça, Equipamento para DJ, Gerador de energia','Assentos reservados para PCD, Plataformas com corrimão',160),(6,'Jardim Imperial','Rua Palmeiras, 987 - Fortaleza, CE',300,'Sistema de som','Banheiros adaptados, Vaga reservada para PCD',285),(7,'Mansão das Rosas','Rua Vitória, 12 - Salvador, BA',220,'Sistema de som, Estrutura para apresentações, Mesas e cadeiras, Microfone sem fio, Máquina de fumaça, Equipamento para DJ, Gerador de energia, Equipamento de audiovisual','Rampas de acesso para cadeirantes, Banheiros adaptados, Atendimento prioritário, Vaga reservada para PCD, Plataformas com corrimão, Legenda em tempo real',190),(8,'Espaço Nobre','Av. Independência, 89 - Porto Alegre, RS',120,'Gerador de energia','Vaga reservada para PCD',118),(9,'Recanto dos Sonhos','Rua Alegria, 45 - Campinas, SP',140,'Projetor multimídia, Sistema de som, Estrutura para apresentações, Microfone sem fio','Banheiros adaptados, Vaga reservada para PCD',140),(10,'Palácio das Festas','Av. Central, 77 - Goiânia, GO',500,'Projetor multimídia, Sistema de som, Tela para projeção, Máquina de fumaça','Plataformas com corrimão',460),(11,'Casa do Lago','Rua Beira Lago, 101 - Florianópolis, SC',160,'Projetor multimídia, Tela para projeção, Equipamento de audiovisual','Legenda em tempo real',148),(12,'Estação Eventos','Av. Paulista, 999 - São Paulo, SP',350,'Projetor multimídia, Sistema de som, Estrutura para apresentações, Banheiros químicos, Tela para projeção, Mesas e cadeiras, Microfone sem fio, Máquina de fumaça, Equipamento para DJ, Gerador de energia, Equipamento de audiovisual','Rampas de acesso para cadeirantes, Assentos reservados para PCD, Vaga reservada para PCD, Legenda em tempo real',312),(13,'Espaço Brilho','Rua do Prado, 22 - Vitória, ES',130,'Projetor multimídia, Sistema de som','Legenda em tempo real',97),(14,'Salão Versailles','Av. França, 66 - Brasília, DF',280,'Sistema de som, Mesas e cadeiras, Microfone sem fio, Equipamento para DJ','Rampas de acesso para cadeirantes, Assentos reservados para PCD, Atendimento prioritário, Legenda em tempo real',265),(15,'Jardim das Estrelas','Rua Céu Azul, 33 - Manaus, AM',200,'Projetor multimídia, Estrutura para apresentações, Microfone sem fio, Equipamento para DJ, Gerador de energia','Rampas de acesso para cadeirantes, Banheiros adaptados, Assentos reservados para PCD, Vaga reservada para PCD, Plataformas com corrimão',180),(16,'Villa Celebration','Rua Aurora, 10 - Niterói, RJ',170,'Projetor multimídia, Estrutura para apresentações, Tela para projeção, Mesas e cadeiras, Microfone sem fio','Assentos reservados para PCD, Vaga reservada para PCD, Legenda em tempo real',170),(17,'Espaço Viena','Av. Europa, 555 - Londrina, PR',190,'Sistema de som, Estrutura para apresentações, Microfone sem fio, Máquina de fumaça','Banheiros adaptados',180),(18,'Recanto Real','Rua Realengo, 82 - João Pessoa, PB',230,'Projetor multimídia, Sistema de som, Tela para projeção, Gerador de energia','Rampas de acesso para cadeirantes',215),(19,'Casa Monte Carlo','Rua da Paz, 60 - Teresina, PI',240,'Projetor multimídia, Sistema de som, Estrutura para apresentações, Tela para projeção, Gerador de energia','Rampas de acesso para cadeirantes, Banheiros adaptados, Assentos reservados para PCD, Vaga reservada para PCD, Plataformas com corrimão',210),(20,'Palácio de Cristal','Av. das Nações, 70 - Belém, PA',400,'Projetor multimídia, Sistema de som, Estrutura para apresentações, Banheiros químicos, Tela para projeção, Mesas e cadeiras','Assentos reservados para PCD, Atendimento prioritário, Vaga reservada para PCD, Plataformas com corrimão, Legenda em tempo real',370),(21,'Espaço Gentil','Rua Antonio do Monte 70',200,'Projetor multimídia, Estrutura para apresentações, Tela para projeção','Banheiros adaptados, Elevadores ou plataformas elevatórias, Atendimento prioritário',190);
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizador`
--

DROP TABLE IF EXISTS `organizador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizador` (
  `idorganizador` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_nasc` datetime(6) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  PRIMARY KEY (`idorganizador`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizador`
--

LOCK TABLES `organizador` WRITE;
/*!40000 ALTER TABLE `organizador` DISABLE KEYS */;
INSERT INTO `organizador` VALUES (1,'11218514865','Lucas Andrade','2001-04-08 00:00:00.000000','3188954747'),(2,'19374516200','Mariana Souza','1998-05-12 00:00:00.000000','3198765432'),(3,'17451236987','Bruno Martins','1999-12-20 00:00:00.000000','3199988776'),(4,'15987123456','Juliana Rocha','2000-03-30 00:00:00.000000','3188877665'),(5,'13445566789','Rafael Costa','1997-07-15 00:00:00.000000','3199776611'),(6,'19887766554','Larissa Gomes','2002-10-02 00:00:00.000000','3188123456'),(7,'14556677889','Thiago Lima','1995-11-25 00:00:00.000000','3199112233'),(8,'12345678901','Isabela Pereira','1996-12-10 00:00:00.000000','3199654321'),(9,'16778899001','Camila Ferreira','1999-01-05 00:00:00.000000','3188765432'),(10,'12165498700','Daniel Oliveira','2002-02-22 00:00:00.000000','3199988123'),(11,'11233455677','Bruna Almeida','2001-09-25 00:00:00.000000','3198123456'),(12,'12398765432','Fernando Dias','1998-06-14 00:00:00.000000','3198654321'),(13,'14567891234','Aline Marques','1997-12-30 00:00:00.000000','3198543219'),(14,'16754321987','João Pedro Ramos','1995-05-18 00:00:00.000000','3188234567'),(15,'13476985213','Patrícia Mendes','2003-03-22 00:00:00.000000','3198999888'),(16,'15678932145','Gustavo Tavares','1996-10-10 00:00:00.000000','3199123456'),(17,'19812345678','Nicole Moreira','2000-02-11 00:00:00.000000','3188765432'),(18,'17634598712','Caio Fernandes','1999-12-01 00:00:00.000000','3199567890'),(19,'13216549875','Lívia Cardoso','2000-11-30 00:00:00.000000','3198345678'),(20,'15487963201','Vinícius Araújo','1998-07-07 00:00:00.000000','3199443210');
/*!40000 ALTER TABLE `organizador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programacao`
--

DROP TABLE IF EXISTS `programacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programacao` (
  `idprogramacao` int NOT NULL AUTO_INCREMENT,
  `data_evento` datetime(6) NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fim` time NOT NULL,
  PRIMARY KEY (`idprogramacao`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programacao`
--

LOCK TABLES `programacao` WRITE;
/*!40000 ALTER TABLE `programacao` DISABLE KEYS */;
INSERT INTO `programacao` VALUES (1,'2008-12-20 00:00:00.000000','18:30:00','22:00:00'),(2,'2009-01-15 00:00:00.000000','14:00:00','17:00:00'),(3,'2009-02-10 00:00:00.000000','09:00:00','11:30:00'),(4,'2009-03-05 00:00:00.000000','10:00:00','12:30:00'),(5,'2009-04-18 00:00:00.000000','15:00:00','18:00:00'),(6,'2009-05-22 00:00:00.000000','13:00:00','16:00:00'),(7,'2009-06-30 00:00:00.000000','19:00:00','21:00:00'),(8,'2009-07-14 00:00:00.000000','08:00:00','10:00:00'),(9,'2009-08-09 00:00:00.000000','17:00:00','20:00:00'),(10,'2009-09-25 00:00:00.000000','12:00:00','15:00:00'),(11,'2009-10-11 00:00:00.000000','18:00:00','21:00:00'),(12,'2009-11-20 00:00:00.000000','10:00:00','13:00:00'),(13,'2009-12-31 00:00:00.000000','22:00:00','01:00:00'),(14,'2010-01-01 00:00:00.000000','00:00:00','03:00:00'),(15,'2010-02-17 00:00:00.000000','14:30:00','17:30:00'),(16,'2010-03-03 00:00:00.000000','16:00:00','19:00:00'),(17,'2010-04-10 00:00:00.000000','11:00:00','14:00:00'),(18,'2010-05-27 00:00:00.000000','15:00:00','18:30:00'),(19,'2010-06-15 00:00:00.000000','09:30:00','12:00:00');
/*!40000 ALTER TABLE `programacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestoraeventos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-18 20:42:52
