/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-03-21 09:21:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for systemuser
-- ----------------------------
DROP TABLE IF EXISTS `systemuser`;
CREATE TABLE `systemuser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of systemuser
-- ----------------------------
INSERT INTO `systemuser` VALUES ('1', 'root', '123');
INSERT INTO `systemuser` VALUES ('2', 'admin', '123');
