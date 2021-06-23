/*
 Navicat Premium Data Transfer

 Source Server         : 刘小雨
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 1.117.97.60:3307
 Source Schema         : h_takenumber

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 23/06/2021 17:01:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_call_proof
-- ----------------------------
DROP TABLE IF EXISTS `h_call_proof`;
CREATE TABLE `h_call_proof`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '取票no',
  `regId` bigint(0) NOT NULL COMMENT '挂号id',
  `departmentId` int(0) NOT NULL COMMENT '科室id',
  `roomName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '房间名',
  `orderNum` int(0) NOT NULL COMMENT '排队序号',
  `createTime` datetime(0) NOT NULL COMMENT '取票时间',
  `status` char(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '取票状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_call_proof
-- ----------------------------
INSERT INTO `h_call_proof` VALUES (27, 'GH1016', 12, 1, '诊室1', 1, '2021-06-22 14:25:32', '1');
INSERT INTO `h_call_proof` VALUES (28, 'GH1017', 12, 1, '诊室1', 2, '2021-06-22 14:32:28', '1');
INSERT INTO `h_call_proof` VALUES (29, 'GH1018', 12, 1, '诊室1', 3, '2021-06-22 14:36:56', '1');
INSERT INTO `h_call_proof` VALUES (30, 'GH1018', 12, 1, '诊室1', 4, '2021-06-23 16:12:50', '1');

-- ----------------------------
-- Table structure for h_examine_proof
-- ----------------------------
DROP TABLE IF EXISTS `h_examine_proof`;
CREATE TABLE `h_examine_proof`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '检查no',
  `orderNum` int(0) NOT NULL COMMENT '排队序号',
  `createTime` datetime(0) NOT NULL COMMENT '取票时间',
  `examineType` char(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '检查类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_examine_proof
-- ----------------------------
INSERT INTO `h_examine_proof` VALUES (2, 'JC0001', 1, '2021-06-22 16:52:43', '1');
INSERT INTO `h_examine_proof` VALUES (3, 'JC0002', 1, '2021-06-22 17:29:37', '2');
INSERT INTO `h_examine_proof` VALUES (4, 'JC0001', 2, '2021-06-22 19:28:52', '1');
INSERT INTO `h_examine_proof` VALUES (5, 'JC0002', 3, '2021-06-22 19:55:02', '1');
INSERT INTO `h_examine_proof` VALUES (6, 'JC1001', 4, '2021-06-22 19:57:47', '1');

-- ----------------------------
-- Table structure for h_pharmacy_proof
-- ----------------------------
DROP TABLE IF EXISTS `h_pharmacy_proof`;
CREATE TABLE `h_pharmacy_proof`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id ',
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '药房取票编码',
  `orderNum` int(0) NOT NULL COMMENT '排队序号',
  `createTime` datetime(0) NOT NULL COMMENT '取票时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_pharmacy_proof
-- ----------------------------
INSERT INTO `h_pharmacy_proof` VALUES (1, 'YF1234', 1, '2021-06-21 19:04:09');
INSERT INTO `h_pharmacy_proof` VALUES (9, 'YF1233', 9, '2021-06-22 14:37:45');
INSERT INTO `h_pharmacy_proof` VALUES (10, 'YF123', 10, '2021-06-22 15:34:40');
INSERT INTO `h_pharmacy_proof` VALUES (11, 'YF123', 11, '2021-06-22 16:16:14');
INSERT INTO `h_pharmacy_proof` VALUES (12, 'YF123', 12, '2021-06-22 19:55:55');
INSERT INTO `h_pharmacy_proof` VALUES (13, 'YF1001', 13, '2021-06-23 16:39:48');

SET FOREIGN_KEY_CHECKS = 1;
