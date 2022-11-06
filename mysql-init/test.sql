-- Adminer 4.8.1 MySQL 8.0.31 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `uuid_role` char(36) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid_role`),
  UNIQUE KEY `UK_c9lijtmr0x68iu1vxftbu2u33` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_role` (`uuid_role`, `role_name`) VALUES
('20b17002-b2bb-4ef9-ad41-7314b16f1753',	'ROLE_ADMIN'),
('f8d4bcbb-4e5e-4bd8-9040-389b08772ace',	'ROLE_USER');

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uuid_user` char(36) NOT NULL,
  `password` varchar(200) NOT NULL,
  `user` varchar(200) NOT NULL,
  PRIMARY KEY (`uuid_user`),
  UNIQUE KEY `UK_itqmd3o8t5oh4gtqvmf63wmd1` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_user` (`uuid_user`, `password`, `user`) VALUES
('05d09995-4d76-48de-9037-d3163c26cf5e',	'$2a$10$xQKue46QQjssCHNZMUWCw.JpOwocN733j8Gr7txYDD5zhfGune/S.',	'admin'),
('355eda27-9666-4aac-8aec-125a4a24457c',	'$2a$10$xQKue46QQjssCHNZMUWCw.JpOwocN733j8Gr7txYDD5zhfGune/S.',	'user');

DROP TABLE IF EXISTS `tb_users_roles`;
CREATE TABLE `tb_users_roles` (
  `uuid_user` char(36) NOT NULL,
  `uuid_role` char(36) NOT NULL,
  KEY `FK9caan3p4c61magkti736fw6ve` (`uuid_role`),
  KEY `FKl82rv41ynjcc95d3ra0hw5aja` (`uuid_user`),
  CONSTRAINT `FK9caan3p4c61magkti736fw6ve` FOREIGN KEY (`uuid_role`) REFERENCES `tb_role` (`uuid_role`),
  CONSTRAINT `FKl82rv41ynjcc95d3ra0hw5aja` FOREIGN KEY (`uuid_user`) REFERENCES `tb_user` (`uuid_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_users_roles` (`uuid_user`, `uuid_role`) VALUES
('05d09995-4d76-48de-9037-d3163c26cf5e',	'20b17002-b2bb-4ef9-ad41-7314b16f1753'),
('355eda27-9666-4aac-8aec-125a4a24457c',	'f8d4bcbb-4e5e-4bd8-9040-389b08772ace');

-- 2022-11-06 01:08:56
