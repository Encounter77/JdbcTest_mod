/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-10-19 20:09:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bookta`
-- ----------------------------
DROP TABLE IF EXISTS `bookta`;
CREATE TABLE `bookta` (
  `isbn` varchar(16) NOT NULL,
  `title` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookta
-- ----------------------------
INSERT INTO `bookta` VALUES ('002', '史记', '传记', '85');
INSERT INTO `bookta` VALUES ('004', '钢铁是怎样炼成的', '小说', '76');
INSERT INTO `bookta` VALUES ('007', '爱的教育', '小说', '28');
INSERT INTO `bookta` VALUES ('120', '海底两万里', '小说', '50');
