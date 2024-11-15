
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 34.174.38.209    Database: agencia_de_viajes
-- ------------------------------------------------------
-- Server version	8.0.31-google

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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '89101f8f-63ac-11ef-9e28-42010a400002:1-405338';

--
-- Table structure for table `aerolinea`
--

DROP TABLE IF EXISTS `aerolinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aerolinea` (
                             `id_aerolinea` int NOT NULL AUTO_INCREMENT,
                             `aerolinea` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id_aerolinea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `asiento`
--

DROP TABLE IF EXISTS `asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento` (
                           `columna_asiento` int NOT NULL,
                           `fila_asiento` int NOT NULL,
                           `id_asiento` int NOT NULL AUTO_INCREMENT,
                           `numero_asiento` int NOT NULL,
                           PRIMARY KEY (`id_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `descuento_excursion`
--

DROP TABLE IF EXISTS `descuento_excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento_excursion` (
                                       `descuento` double DEFAULT NULL,
                                       `disponible` bit(1) DEFAULT NULL,
                                       `id_descuento_vuelo` int NOT NULL AUTO_INCREMENT,
                                       `id_excursion` int DEFAULT NULL,
                                       PRIMARY KEY (`id_descuento_vuelo`),
                                       UNIQUE KEY `UK6h9liyu1ercayt6uqmn2tyhbp` (`id_excursion`),
                                       CONSTRAINT `FKs17a9s7thtj6lx9mvea9xq7bl` FOREIGN KEY (`id_excursion`) REFERENCES `excursion` (`id_excursion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `descuento_hotel`
--

DROP TABLE IF EXISTS `descuento_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento_hotel` (
                                   `descuento` double DEFAULT NULL,
                                   `disponible` bit(1) DEFAULT NULL,
                                   `id_descuento_hotel` int NOT NULL AUTO_INCREMENT,
                                   `id_hotel` int DEFAULT NULL,
                                   PRIMARY KEY (`id_descuento_hotel`),
                                   UNIQUE KEY `UK19xv67ecjanu673esbe90x4y8` (`id_hotel`),
                                   CONSTRAINT `FK8ii6u1k72gaolokj5478l94lg` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `descuento_vuelo`
--

DROP TABLE IF EXISTS `descuento_vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento_vuelo` (
                                   `descuento` double DEFAULT NULL,
                                   `disponible` bit(1) DEFAULT NULL,
                                   `id_descuento_vuelo` int NOT NULL AUTO_INCREMENT,
                                   `id_vuelo` int DEFAULT NULL,
                                   PRIMARY KEY (`id_descuento_vuelo`),
                                   UNIQUE KEY `UK1dxo3lj68ou9e9an5jk0evm9g` (`id_vuelo`),
                                   CONSTRAINT `FKlj6qwxvmneygbhnsaxts5ug4n` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelo` (`id_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra` (
                                  `id_detalle_compra` int NOT NULL AUTO_INCREMENT,
                                  `precio_total` double DEFAULT NULL,
                                  `id_usuario` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`id_detalle_compra`),
                                  KEY `FKc9p10nfskxktsqpymugedelkh` (`id_usuario`),
                                  CONSTRAINT `FKc9p10nfskxktsqpymugedelkh` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_compra_excursion`
--

DROP TABLE IF EXISTS `detalle_compra_excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra_excursion` (
                                            `id_detalle_compra` int NOT NULL,
                                            `id_detalle_excursion` int NOT NULL,
                                            PRIMARY KEY (`id_detalle_compra`,`id_detalle_excursion`),
                                            KEY `FKtbc79igakkmrb7m5vovvq3vsl` (`id_detalle_excursion`),
                                            CONSTRAINT `FK73mhs7dtg0436tourv09d0w31` FOREIGN KEY (`id_detalle_compra`) REFERENCES `detalle_compra` (`id_detalle_compra`),
                                            CONSTRAINT `FKtbc79igakkmrb7m5vovvq3vsl` FOREIGN KEY (`id_detalle_excursion`) REFERENCES `detalle_excursion` (`id_detalle_excursion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_compra_hotel`
--

DROP TABLE IF EXISTS `detalle_compra_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra_hotel` (
                                        `id_detalle_compra` int NOT NULL,
                                        `id_detalle_hotel` int NOT NULL,
                                        PRIMARY KEY (`id_detalle_compra`,`id_detalle_hotel`),
                                        KEY `FK3l1sh75dcob8atw2p7mta2qec` (`id_detalle_hotel`),
                                        CONSTRAINT `FK3l1sh75dcob8atw2p7mta2qec` FOREIGN KEY (`id_detalle_hotel`) REFERENCES `detalle_hotel` (`id_detalle_hotel`),
                                        CONSTRAINT `FKolvssd5afb20lvs6fp9cx2jnh` FOREIGN KEY (`id_detalle_compra`) REFERENCES `detalle_compra` (`id_detalle_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_compra_vuelo`
--

DROP TABLE IF EXISTS `detalle_compra_vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra_vuelo` (
                                        `id_detalle_compra` int NOT NULL,
                                        `id_detalle_vuelo` int NOT NULL,
                                        PRIMARY KEY (`id_detalle_compra`,`id_detalle_vuelo`),
                                        KEY `FKs1e4y5crcdkbtx9ubjlis08ph` (`id_detalle_vuelo`),
                                        CONSTRAINT `FK1mj75kjnajikcrsnkp9kox16x` FOREIGN KEY (`id_detalle_compra`) REFERENCES `detalle_compra` (`id_detalle_compra`),
                                        CONSTRAINT `FKs1e4y5crcdkbtx9ubjlis08ph` FOREIGN KEY (`id_detalle_vuelo`) REFERENCES `detalle_vuelo` (`id_detalle_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_excursion`
--

DROP TABLE IF EXISTS `detalle_excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_excursion` (
                                     `id_detalle_excursion` int NOT NULL AUTO_INCREMENT,
                                     `id_excursion` int DEFAULT NULL,
                                     `numero_personas` int DEFAULT NULL,
                                     `valor_total_excursion` double DEFAULT NULL,
                                     PRIMARY KEY (`id_detalle_excursion`),
                                     KEY `FKgqf1bphd4profxkq5ysmxyhy0` (`id_excursion`),
                                     CONSTRAINT `FKgqf1bphd4profxkq5ysmxyhy0` FOREIGN KEY (`id_excursion`) REFERENCES `excursion` (`id_excursion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_hotel`
--

DROP TABLE IF EXISTS `detalle_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_hotel` (
                                 `id_detalle_hotel` int NOT NULL AUTO_INCREMENT,
                                 `id_hotel` int DEFAULT NULL,
                                 `numero_visitantes` int DEFAULT NULL,
                                 `valor_total` double DEFAULT NULL,
                                 `fecha_entrada` datetime(6) DEFAULT NULL,
                                 `fecha_salida` datetime(6) DEFAULT NULL,
                                 PRIMARY KEY (`id_detalle_hotel`),
                                 KEY `FKogkafb82ia44b0issvyf8girv` (`id_hotel`),
                                 CONSTRAINT `FKogkafb82ia44b0issvyf8girv` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_vuelo`
--

DROP TABLE IF EXISTS `detalle_vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_vuelo` (
                                 `id_asiento` int DEFAULT NULL,
                                 `id_detalle_vuelo` int NOT NULL AUTO_INCREMENT,
                                 `id_tipo_equipaje` int DEFAULT NULL,
                                 `id_tipo_pasajero` int DEFAULT NULL,
                                 `id_vuelo` int DEFAULT NULL,
                                 PRIMARY KEY (`id_detalle_vuelo`),
                                 KEY `FK8p1jefguckl3p953ll4mbturg` (`id_tipo_equipaje`),
                                 KEY `FK5deumettgw523e2vwseoumq0b` (`id_vuelo`),
                                 KEY `FK3mqesnv5a7a2k77kqf7d9pc` (`id_tipo_pasajero`),
                                 KEY `FK915v6uort1qr71run3u6pdyak` (`id_asiento`),
                                 CONSTRAINT `FK3mqesnv5a7a2k77kqf7d9pc` FOREIGN KEY (`id_tipo_pasajero`) REFERENCES `tipo_pasajero` (`id_tipo_pasajero`),
                                 CONSTRAINT `FK5deumettgw523e2vwseoumq0b` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelo` (`id_vuelo`),
                                 CONSTRAINT `FK8p1jefguckl3p953ll4mbturg` FOREIGN KEY (`id_tipo_equipaje`) REFERENCES `tipo_equipaje` (`id_tipo_equipaje`),
                                 CONSTRAINT `FK915v6uort1qr71run3u6pdyak` FOREIGN KEY (`id_asiento`) REFERENCES `asiento` (`id_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `excursion` (
                             `id_excursion` int NOT NULL AUTO_INCREMENT,
                             `id_lugar_turistico` int DEFAULT NULL,
                             `precio_pasajero` double DEFAULT NULL,
                             `descrpcion_excursion` varchar(255) DEFAULT NULL,
                             `nombre_excursion` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id_excursion`),
                             UNIQUE KEY `UK5ns4dehgl8iwqbjxwgc4xxbij` (`id_lugar_turistico`),
                             CONSTRAINT `FKloo3g9owawwf59g1w2jwgssvr` FOREIGN KEY (`id_lugar_turistico`) REFERENCES `lugar_turistico` (`id_lugar_turistico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
                          `id_genero` int NOT NULL AUTO_INCREMENT,
                          `genero` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
                         `id_hotel` int NOT NULL AUTO_INCREMENT,
                         `id_lugar_turistico` int DEFAULT NULL,
                         `numero_huespedes` int NOT NULL,
                         `valor_total` double NOT NULL,
                         `detalles_hotel` varchar(255) DEFAULT NULL,
                         `nombre_hotel` varchar(255) NOT NULL,
                         PRIMARY KEY (`id_hotel`),
                         UNIQUE KEY `UKd222pp6a93dey3wshma0jqofo` (`id_lugar_turistico`),
                         CONSTRAINT `FKnnrdujl6gdgxxubrp7c728hjv` FOREIGN KEY (`id_lugar_turistico`) REFERENCES `lugar_turistico` (`id_lugar_turistico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lugar_turistico`
--

DROP TABLE IF EXISTS `lugar_turistico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar_turistico` (
                                   `id_lugar_turistico` int NOT NULL AUTO_INCREMENT,
                                   `descripcion_lugar_turistico` varchar(255) DEFAULT NULL,
                                   `lugar_turistico` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id_lugar_turistico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medio_notificacion`
--

DROP TABLE IF EXISTS `medio_notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio_notificacion` (
                                      `id_medio_notificacion` int NOT NULL AUTO_INCREMENT,
                                      `medio_notificacion` varchar(255) DEFAULT NULL,
                                      PRIMARY KEY (`id_medio_notificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
                                  `id_tipo_documento` int NOT NULL AUTO_INCREMENT,
                                  `nombre_tipo_documento` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_equipaje`
--

DROP TABLE IF EXISTS `tipo_equipaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_equipaje` (
                                 `id_tipo_equipaje` int NOT NULL AUTO_INCREMENT,
                                 `tipo_equipaje` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id_tipo_equipaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_pasajero`
--

DROP TABLE IF EXISTS `tipo_pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_pasajero` (
                                 `id_tipo_pasajero` int NOT NULL AUTO_INCREMENT,
                                 `tipo_pasajero` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id_tipo_pasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_vuelo`
--

DROP TABLE IF EXISTS `tipo_vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_vuelo` (
                              `id_tipo_vuelo` int NOT NULL AUTO_INCREMENT,
                              `tipo_vuelo` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id_tipo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
                           `id_genero` int DEFAULT NULL,
                           `id_tipo_documento` int DEFAULT NULL,
                           `fecha_nacimiento` datetime(6) DEFAULT NULL,
                           `apellidos_usuario` varchar(255) DEFAULT NULL,
                           `celular` varchar(255) DEFAULT NULL,
                           `contrasena` varchar(255) DEFAULT NULL,
                           `direccion` varchar(255) DEFAULT NULL,
                           `email` varchar(255) DEFAULT NULL,
                           `id_usuario` varchar(255) NOT NULL,
                           `nombres_usuario` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id_usuario`),
                           KEY `FKi84twx6f7o0pu9mbi856hhp7s` (`id_tipo_documento`),
                           KEY `FKnmdnwl24pqv47wjko49ekm9ys` (`id_genero`),
                           CONSTRAINT `FKi84twx6f7o0pu9mbi856hhp7s` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`),
                           CONSTRAINT `FKnmdnwl24pqv47wjko49ekm9ys` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_notificacion`
--

DROP TABLE IF EXISTS `usuario_notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_notificacion` (
                                        `id_medio_notificacion` int NOT NULL,
                                        `id_usuario` varchar(255) NOT NULL,
                                        PRIMARY KEY (`id_medio_notificacion`,`id_usuario`),
                                        KEY `FKco2p1m4bin9ndroykw85daf99` (`id_usuario`),
                                        CONSTRAINT `FKco2p1m4bin9ndroykw85daf99` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
                                        CONSTRAINT `FKe2lq6r9i11j0fj2th2hmffro8` FOREIGN KEY (`id_medio_notificacion`) REFERENCES `medio_notificacion` (`id_medio_notificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
                         `cargos` double NOT NULL,
                         `id_aerolinea` int DEFAULT NULL,
                         `id_lugar_turistico_destino` int NOT NULL,
                         `id_lugar_turistico_origen` int NOT NULL,
                         `id_tipo_vuelo` int DEFAULT NULL,
                         `id_vuelo` int NOT NULL AUTO_INCREMENT,
                         `impuestos` double NOT NULL,
                         `numero_pasajeros` int NOT NULL,
                         `tarifa_base` double NOT NULL,
                         `total_tarifa` double NOT NULL,
                         `fecha_fin` datetime(6) NOT NULL,
                         `fecha_inicio` datetime(6) NOT NULL,
                         PRIMARY KEY (`id_vuelo`),
                         KEY `FK6rcasheqx4kka5foymny6v5p0` (`id_aerolinea`),
                         KEY `FKm6hejoph9vsuid0qr750t71c7` (`id_tipo_vuelo`),
                         KEY `FKblp6c8buqi8rqs2gdtwqjbr9s` (`id_lugar_turistico_destino`),
                         KEY `FKidgk506mqiye701mr4prxuu8p` (`id_lugar_turistico_origen`),
                         CONSTRAINT `FK6rcasheqx4kka5foymny6v5p0` FOREIGN KEY (`id_aerolinea`) REFERENCES `aerolinea` (`id_aerolinea`),
                         CONSTRAINT `FKblp6c8buqi8rqs2gdtwqjbr9s` FOREIGN KEY (`id_lugar_turistico_destino`) REFERENCES `lugar_turistico` (`id_lugar_turistico`),
                         CONSTRAINT `FKidgk506mqiye701mr4prxuu8p` FOREIGN KEY (`id_lugar_turistico_origen`) REFERENCES `lugar_turistico` (`id_lugar_turistico`),
                         CONSTRAINT `FKm6hejoph9vsuid0qr750t71c7` FOREIGN KEY (`id_tipo_vuelo`) REFERENCES `tipo_vuelo` (`id_tipo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-15  1:21:23
insert into medio_notificacion values(1, "sms");
insert into medio_notificacion values(2, "email");
insert into medio_notificacion values(3, "push");

insert into tipo_documento values(null, 'cedula de ciudadania');
insert into tipo_documento values(null, 'pasaporte');
insert into tipo_documento values(null, 'nit');
insert into tipo_documento values(null, 'rut');
insert into tipo_documento values(null, 'tarjeta de identidad');
insert into tipo_documento values(null, 'licencia de conduccion');
insert into tipo_documento values(null, 'nit internacional');
insert into tipo_documento values(null, 'cedula de extranjeria');
insert into tipo_documento values(null, 'tarjeta de extranjeria');
insert into tipo_documento values(null, 'registro civil');

insert into genero values(null, 'hombre');
insert into genero values(null, 'mujer');

insert into lugar_turistico values(null, 'cartagena', "ciudad colonial con murallas, playas y vibrante vida nocturna. patrimonio de la humanidad por su historia y belleza.");
insert into lugar_turistico values(null, 'villa de leyva','pueblo colonial con calles empedradas, arquitectura historica y la plaza mayor mas grande de colombia.');
insert into lugar_turistico values(null, 'medellin','la "ciudad de la eterna primavera" es moderna, con parques, museos y el innovador sistema de transporte metrocable.');
insert into lugar_turistico values(null, 'santa marta','ciudad costera con acceso al parque tayrona, playas tropicales y una vibrante vida cultural.');
insert into lugar_turistico values(null, 'barichara','pueblo colonial en santander con calles de piedra, arquitectura tradicional y paisajes montanosos.');
insert into lugar_turistico values(null, 'salento','pueblo en el eje cafetero, famoso por el valle de cocora, las altas palmas de cera y la cultura cafetera.');
insert into lugar_turistico values(null, 'guatape','colorido pueblo cerca de medellin, conocido por la piedra del penol y su embalse ideal para actividades acuaticas.');
insert into lugar_turistico values(null, 'bogota','capital del pais con historia, cultura, museos y el cerro de monserrate que ofrece vistas espectaculares de la ciudad.');
insert into lugar_turistico values(null, 'san gil','capital colombiana de los deportes extremos, con rafting, parapente y senderismo en paisajes naturales increibles.');
insert into lugar_turistico values(null, 'popayan','ciudad conocida por su arquitectura colonial blanca y su importancia historica y religiosa en la semana santa.');

insert into tipo_pasajero values(null, 'turista');
insert into tipo_pasajero values(null, 'ejecutivo');
insert into tipo_pasajero values(null, 'primera clase');

insert into tipo_equipaje values(null, 'equipaje de bodega');
insert into tipo_equipaje values(null, 'equipaje de mano');

insert into tipo_vuelo values(null, 'vuelo directo');
insert into tipo_vuelo values(null, 'maximo una escala');
insert into tipo_vuelo values(null, 'maximo dos escala');

insert into aerolinea values(null, 'wingo');
insert into aerolinea values(null, 'latam airlines colombia');
insert into aerolinea values(null, 'viva air colombia');
insert into aerolinea values(null, 'avianca');
insert into aerolinea values(null, 'easyfly');
insert into aerolinea values(null, 'satena');

insert into hotel values (1, 1, 100, 5000.00, 'Hotel todo incluido con acceso a la playa', 'Hotel Playa Bonita');
insert into detalle_hotel values(1, 1, 10, 500.0, '2024-12-07 08:00:00', '2024-12-07 08:00:00');