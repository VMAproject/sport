-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.16-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных mysport
CREATE DATABASE IF NOT EXISTS `mysport` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mysport`;

-- Дамп структуры для таблица mysport.category_group
CREATE TABLE IF NOT EXISTS `category_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_main` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoi98r1addahotrvqymx7d4bdu` (`user_id`),
  CONSTRAINT `FKoi98r1addahotrvqymx7d4bdu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.customer_card
CREATE TABLE IF NOT EXISTS `customer_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhf6fwaiqrdq6mbw9vi5uxgvq0` (`card_id`),
  KEY `FKpyrp5t529viaejj0tan2trpgr` (`student_id`),
  CONSTRAINT `FKhf6fwaiqrdq6mbw9vi5uxgvq0` FOREIGN KEY (`card_id`) REFERENCES `price` (`id`),
  CONSTRAINT `FKpyrp5t529viaejj0tan2trpgr` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.email
CREATE TABLE IF NOT EXISTS `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.group2
CREATE TABLE IF NOT EXISTS `group2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discription` varchar(255) DEFAULT NULL,
  `is_main` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdtvfnirqqwde9l0thk6ki66bf` (`category_id`),
  KEY `FKkcijryl1msakwebg5n0r4nwv8` (`user_id`),
  CONSTRAINT `FKdtvfnirqqwde9l0thk6ki66bf` FOREIGN KEY (`category_id`) REFERENCES `category_group` (`id`),
  CONSTRAINT `FKkcijryl1msakwebg5n0r4nwv8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.list_date
CREATE TABLE IF NOT EXISTS `list_date` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.price
CREATE TABLE IF NOT EXISTS `price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discription` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price_month` int(11) DEFAULT NULL,
  `price_month_half` int(11) DEFAULT NULL,
  `price_single` int(11) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6exbs956na8dfi8e4nja71ap` (`group_id`),
  KEY `FKs13dswkc5n8832crl1kohoggq` (`user_id`),
  CONSTRAINT `FKq6exbs956na8dfi8e4nja71ap` FOREIGN KEY (`group_id`) REFERENCES `group2` (`id`),
  CONSTRAINT `FKs13dswkc5n8832crl1kohoggq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.session_history
CREATE TABLE IF NOT EXISTS `session_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `browser` varchar(255) DEFAULT NULL,
  `session_ip` varchar(255) DEFAULT NULL,
  `session_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.sport
CREATE TABLE IF NOT EXISTS `sport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `sport` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `record_day` varchar(255) DEFAULT NULL,
  `string_birthday` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa4beipqug69xo0sg0q1stjcbp` (`status_id`),
  KEY `FKk5m148xqefonqw7bgnpm0snwj` (`user_id`),
  CONSTRAINT `FKa4beipqug69xo0sg0q1stjcbp` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `FKk5m148xqefonqw7bgnpm0snwj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.student_group
CREATE TABLE IF NOT EXISTS `student_group` (
  `student_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`student_id`,`group_id`),
  KEY `FKpi1989b2qbwxr5clghm14jtn7` (`group_id`),
  CONSTRAINT `FKgjllnbvo075iomudum0rdrblb` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKpi1989b2qbwxr5clghm14jtn7` FOREIGN KEY (`group_id`) REFERENCES `group2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.student_sport
CREATE TABLE IF NOT EXISTS `student_sport` (
  `student_id` bigint(20) NOT NULL,
  `sport_id` bigint(20) NOT NULL,
  PRIMARY KEY (`student_id`,`sport_id`),
  KEY `FK3vmyj8coum0ldgejqlqerdhb2` (`sport_id`),
  CONSTRAINT `FK3vmyj8coum0ldgejqlqerdhb2` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`),
  CONSTRAINT `FKj0k45wj5qmkupsc9q15k0ti5a` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` datetime DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isactive` varchar(255) DEFAULT NULL,
  `isnonexpired` varchar(255) DEFAULT NULL,
  `isnonlocked` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `session_history_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  KEY `FK5nhqso0fyrl9065uc5hygoc4b` (`session_history_id`),
  CONSTRAINT `FK5nhqso0fyrl9065uc5hygoc4b` FOREIGN KEY (`session_history_id`) REFERENCES `session_history` (`id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица mysport.user_sport
CREATE TABLE IF NOT EXISTS `user_sport` (
  `user_id` bigint(20) NOT NULL,
  `sport_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`sport_id`),
  KEY `FKj0w7peexst59vbyyr4ohet5cc` (`sport_id`),
  CONSTRAINT `FKj0w7peexst59vbyyr4ohet5cc` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`id`),
  CONSTRAINT `FKjv60l7te5e3vqs07pf4rtl2dh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
