-- Adminer 4.6.2 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `followup_details`;
CREATE TABLE `followup_details` (
  `followupId` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `next_followup_date` timestamp NULL DEFAULT NULL,
  `payment_mode` varchar(50) NOT NULL,
  `visitor_id` int(11) NOT NULL,
  `created_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`followupId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `followup_details` (`followupId`, `model`, `status`, `next_followup_date`, `payment_mode`, `visitor_id`, `created_timestamp`) VALUES
(1,	'model23',	'sold',	NULL,	'cash',	1,	'2021-05-01 14:36:58');

DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `visitor_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  `phone_no` varchar(50) DEFAULT NULL,
  `salesman_name` varchar(50) DEFAULT NULL,
  `created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `visitor` (`visitor_id`, `visitor_name`, `address`, `profession`, `phone_no`, `salesman_name`, `created_timestamp`, `modified_timestamp`) VALUES
(1,	'Aman',	'Ape Agency',	'Bussinessman',	'123',	'Salman',	'2021-05-01 14:38:05',	NULL);

-- 2021-05-01 14:40:48
