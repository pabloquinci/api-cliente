
CREATE TABLE `persona` (
  `id_persona` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `dni` bigint DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` bigint DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `cliente` (
  `contrasenia` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `id_persona` bigint NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `FKlbs69o9qkvv7lgn06idak3crb` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
