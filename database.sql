DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
     `username` varchar(50) NOT NULL,
     `password` text,
     `enabled` varchar(50) DEFAULT NULL,
     PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('adm','pwd123','true'),('user','pwd123','true');
UNLOCK TABLES;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(50) DEFAULT NULL,
    `authority` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `authorities` WRITE;
INSERT INTO `authorities` VALUES (1,'user','ROLE_USER'),(2,'adm','ROLE_ADMIN');
UNLOCK TABLES;






