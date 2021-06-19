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

 Date: 18/06/2021 19:42:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_call_proof
-- ----------------------------
DROP TABLE IF EXISTS `h_call_proof`;
CREATE TABLE `h_call_proof`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `regId` int(0) NOT NULL COMMENT '挂号id',
  `departmentId` int(0) NOT NULL COMMENT '科室id',
  `roomName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '房间名',
  `orderNum` int(0) NOT NULL COMMENT '排队序号',
  `createTime` datetime(0) NOT NULL COMMENT '取票时间',
  `status` char(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '取票状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_call_proof
-- ----------------------------
INSERT INTO `h_call_proof` VALUES (1, 1, 1, '1001', 1, '2021-06-17 16:46:31', '1');
INSERT INTO `h_call_proof` VALUES (2, 2, 2, '1002', 2, '2021-06-17 09:00:11', '1');
INSERT INTO `h_call_proof` VALUES (3, 3, 3, '1002', 3, '2021-06-17 17:01:05', '2');

SET FOREIGN_KEY_CHECKS = 1;
