/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-03-27 15:14:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `systemuser`
-- ----------------------------
DROP TABLE IF EXISTS `systemuser`;
CREATE TABLE `systemuser` (
  `userid` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `power` int(11) NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 NOT NULL,
  `text` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of systemuser
-- ----------------------------
INSERT INTO `systemuser` VALUES ('2', 'admin', '123', '0', '男', '我是管理员');
INSERT INTO `systemuser` VALUES ('10', '登录名要六个字以上', '123456', '0', '女', '测试');
