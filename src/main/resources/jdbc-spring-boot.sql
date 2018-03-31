/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.7.17-log : Database - springjdbcdb
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springjdbcdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springjdbcdb`;

/*Table structure for table `icici_bank` */

DROP TABLE IF EXISTS `icici_bank`;

CREATE TABLE `icici_bank` (
  `account_balance` double(5,2) DEFAULT '0.00',
  `account_holder_name` varchar(255) DEFAULT NULL,
  `account_no` int(11) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `icici_bank` */

insert  into `icici_bank`(`account_balance`,`account_holder_name`,`account_no`,`account_type`,`id`) values (995.00,'Bidhan Khanal',42100003,'Saving',53),(894.00,'Sanjok Khakurel',42100002,'Saving',54);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
