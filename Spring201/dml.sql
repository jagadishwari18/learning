CREATE DATABASE spring;

USE spring;

CREATE TABLE `property_status` (
  `status_id` int(11) NOT NULL,
  `prop_status` varchar(255) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `spring`.`property_status` (`status_id`, `prop_status`) VALUES ('1', 'Owner');
INSERT INTO `spring`.`property_status` (`status_id`, `prop_status`) VALUES ('2', 'Tenanted');


CREATE TABLE `property_type` (
  `category_id` int(11) NOT NULL,
  `prop_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `spring`.`property_type` (`category_id`, `prop_desc`) VALUES ('1', 'RCC buildings');
INSERT INTO `spring`.`property_type` (`category_id`, `prop_desc`) VALUES ('2', 'RCC buildings with cement or red-oxide flooring');
INSERT INTO `spring`.`property_type` (`category_id`, `prop_desc`) VALUES ('3', 'Tiled/Sheet of all kinds');

CREATE TABLE `property_zone` (
  `zone_Id` int(11) NOT NULL,
  `zone_name` varchar(255) NOT NULL,
  PRIMARY KEY (`zone_Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `spring`.`property_zone` (`zone_Id`, `zone_name`) VALUES ('1', 'Zone A');
INSERT INTO `spring`.`property_zone` (`zone_Id`, `zone_name`) VALUES ('2', 'Zone B');
INSERT INTO `spring`.`property_zone` (`zone_Id`, `zone_name`) VALUES ('3', 'Zone C');



CREATE TABLE `zone_unit_value` (
  `id` int(11) NOT NULL,
  `uav` double DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `zone_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt3mlkbi553t3m0kad7isjak81` (`category_id`),
  KEY `FKhu5mlpo8tevthi1xxn3tbsuwh` (`status_id`),
  KEY `FK9dkanfsyn695g14j0804h0q04` (`zone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('1', '2.50', '1', '1', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('2', '5.00', '1', '2', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('3', '2.00', '1', '1', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('4', '4.00', '1', '2', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('5', '1.80', '1', '1', '3');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('6', '3.60', '1', '2', '3');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('7', '1.80', '2', '1', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('8', '4.00', '2', '2', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('9', '1.60', '2', '1', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('10', '3.50', '2', '2', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('11', '1.20', '2', '1', '3');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('12', '3.00', '2', '2', '3');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('13', '1.25', '3', '1', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('14', '3.00', '3', '2', '1');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('15', '1.00', '3', '1', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('16', '2.50', '3', '2', '2');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('17', '0.75', '3', '1', '3');
INSERT INTO `spring`.`zone_unit_value` (`id`, `uav`, `category_id`, `status_id`, `zone_id`) VALUES ('18', '2.00', '3', '2', '3');


CREATE TABLE `property_details` (
  `user_prop_id` int(11) NOT NULL AUTO_INCREMENT,
  `emailId` varchar(255) NOT NULL,
  `owner_name` varchar(255) NOT NULL,
  `prop_addr` varchar(255) NOT NULL,
  `build_area` double NOT NULL,
  `build_year` int(11) NOT NULL,
  `year_assessment` int(11) NOT NULL,
  `propertyType_category_id` int(11) DEFAULT NULL,
  `status_status_id` int(11) DEFAULT NULL,
  `zone_zone_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_prop_id`),
  KEY `FKd8xu98jkcsmer8lgd5fi7a4t6` (`propertyType_category_id`),
  KEY `FKa1fbb1bqdbi49rau18nkvsaic` (`status_status_id`),
  KEY `FKrv3nl24nphldghq8hd7ajf96i` (`zone_zone_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


CREATE TABLE `property_tax` (
  `taxId` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `propertyId_user_prop_id` int(11) DEFAULT NULL,
  `statusId_status_id` int(11) DEFAULT NULL,
  `zoneId_zone_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`taxId`),
  KEY `FKa4oh8pxjsv3nwes1x5r7f15q4` (`propertyId_user_prop_id`),
  KEY `FKgi8jwh2p1ie0biym0813cic67` (`statusId_status_id`),
  KEY `FKe02murupsdayas5jcnpf1lfn9` (`zoneId_zone_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
