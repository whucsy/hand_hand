# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.27)
# Database: hand_hand
# Generation Time: 2020-03-12 08:50:50 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table hibernate_sequence
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;

INSERT INTO `hibernate_sequence` (`next_val`)
VALUES
	(20),
	(20),
	(20),
	(20);

/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mission`;

CREATE TABLE `mission` (
  `mid` int(11) NOT NULL,
  `change_number` int(11) NOT NULL,
  `deadline` varchar(255) DEFAULT NULL,
  `existence_date` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `label1` varchar(255) DEFAULT NULL,
  `label2` varchar(255) DEFAULT NULL,
  `label3` varchar(255) DEFAULT NULL,
  `m_title` varchar(255) DEFAULT NULL,
  `mission_info` varchar(255) DEFAULT NULL,
  `money` double NOT NULL,
  `people_amount` int(11) NOT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `mission` WRITE;
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;

INSERT INTO `mission` (`mid`, `change_number`, `deadline`, `existence_date`, `file_name`, `label1`, `label2`, `label3`, `m_title`, `mission_info`, `money`, `people_amount`, `publish_time`, `state`, `uid`)
VALUES
	(10,0,'2020-3-30','2020-3-25',NULL,'实习',NULL,NULL,'求人','大家有没有想来阿里实习做编译器的呀。有兴趣的话可以加vx:legend-yodahaji-k 详聊或 直接发送简历到 legend-k@qq.com',10,0,'2020-3-10',1,1),
	(11,0,'2020-3-30','2020-3-25',NULL,NULL,NULL,NULL,'求群号','2r求喻士贵老师大英4周三的群',10,0,'2020-3-10',0,1),
	(12,0,'2020-3-30','2020-3-25',NULL,'计算机','python',NULL,'求较爬取机票价格','求大佬指导一下 python 爬取机票价格',10,0,'2020-3-10',0,1),
	(13,0,'2020-3-30','2020-3-25',NULL,'比赛',NULL,NULL,'找队友','有无想参加创青春大赛的同学，目前策划书和产品的原型图、安卓app的初步架构都已经搭好了，内容是老年群体的公益类相关产品~开发用Android Studio，求开发队友',10,0,'2020-3-10',0,1),
	(14,0,'2020-3-30','2020-3-25',NULL,'资料',NULL,NULL,'找资料','有没有马原和近代史的复习资料',10,0,'2020-3-10',0,1);

/*!40000 ALTER TABLE `mission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table receive_list
# ------------------------------------------------------------

DROP TABLE IF EXISTS `receive_list`;

CREATE TABLE `receive_list` (
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `receive_list` WRITE;
/*!40000 ALTER TABLE `receive_list` DISABLE KEYS */;

INSERT INTO `receive_list` (`rid`, `mid`, `state`, `uid`)
VALUES
	(19,10,0,16);

/*!40000 ALTER TABLE `receive_list` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table save_list
# ------------------------------------------------------------

DROP TABLE IF EXISTS `save_list`;

CREATE TABLE `save_list` (
  `sid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `uid` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `motto` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `score` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;

INSERT INTO `user_account` (`uid`, `balance`, `icon`, `level`, `motto`, `password`, `phone_number`, `score`, `user_name`)
VALUES
	(15,0,'',0,'','csy666','13618593273',8,'csy'),
	(16,0,'',0,'','xsy666','15387315836',2,'xsy'),
	(17,0,'',0,'','123','123',3,'gyt');

/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `stuent_no` varchar(255) DEFAULT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
