/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : myemployees

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2020-05-22 15:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `department_id` int(4) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(3) DEFAULT NULL,
  `manager_id` int(6) DEFAULT NULL,
  `location_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `loc_id_fk` (`location_id`),
  CONSTRAINT `loc_id_fk` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('10', 'Adm', '200', '1700');
INSERT INTO `departments` VALUES ('20', 'Mar', '201', '1800');
INSERT INTO `departments` VALUES ('30', 'Pur', '114', '1700');
INSERT INTO `departments` VALUES ('40', 'Hum', '203', '2400');
INSERT INTO `departments` VALUES ('50', 'Shi', '121', '1500');
INSERT INTO `departments` VALUES ('60', 'IT', '103', '1400');
INSERT INTO `departments` VALUES ('70', 'Pub', '204', '2700');
INSERT INTO `departments` VALUES ('80', 'Sal', '145', '2500');
INSERT INTO `departments` VALUES ('90', 'Exe', '100', '1700');
INSERT INTO `departments` VALUES ('100', 'Fin', '108', '1700');
INSERT INTO `departments` VALUES ('110', 'Acc', '205', '1700');
INSERT INTO `departments` VALUES ('120', 'Tre', null, '1700');
INSERT INTO `departments` VALUES ('130', 'Cor', null, '1700');
INSERT INTO `departments` VALUES ('140', 'Con', null, '1700');
INSERT INTO `departments` VALUES ('150', 'Sha', null, '1700');
INSERT INTO `departments` VALUES ('160', 'Ben', null, '1700');
INSERT INTO `departments` VALUES ('170', 'Man', null, '1700');
INSERT INTO `departments` VALUES ('180', 'Con', null, '1700');
INSERT INTO `departments` VALUES ('190', 'Con', null, '1700');
INSERT INTO `departments` VALUES ('200', 'Ope', null, '1700');
INSERT INTO `departments` VALUES ('210', 'IT ', null, '1700');
INSERT INTO `departments` VALUES ('220', 'NOC', null, '1700');
INSERT INTO `departments` VALUES ('230', 'IT ', null, '1700');
INSERT INTO `departments` VALUES ('240', 'Gov', null, '1700');
INSERT INTO `departments` VALUES ('250', 'Ret', null, '1700');
INSERT INTO `departments` VALUES ('260', 'Rec', null, '1700');
INSERT INTO `departments` VALUES ('270', 'Pay', null, '1700');
