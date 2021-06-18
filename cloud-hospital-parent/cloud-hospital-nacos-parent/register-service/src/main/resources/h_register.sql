/*
 Navicat Premium Data Transfer

 Source Server         : 1.117.97.60-3307
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 1.117.97.60:3307
 Source Schema         : h_register

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 18/06/2021 19:08:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_patient
-- ----------------------------
DROP TABLE IF EXISTS `h_patient`;
CREATE TABLE `h_patient`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人编号',
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人姓名',
  `age` int(0) NOT NULL COMMENT '病人年龄',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人性别',
  `phone` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人电话',
  `identityId` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人身份证号',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人状态',
  `createTime` datetime(0) NOT NULL COMMENT '病人建档时间',
  `mediCard` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '病人医保卡号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_patient
-- ----------------------------
INSERT INTO `h_patient` VALUES (1, 'WN070300', '刘小雨', 21, '0', '17683858973', '429006', '0', '2021-06-17 07:33:17', NULL);

-- ----------------------------
-- Table structure for h_register
-- ----------------------------
DROP TABLE IF EXISTS `h_register`;
CREATE TABLE `h_register`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号编码',
  `patientId` bigint(0) NOT NULL COMMENT '外键-病人ID',
  `regType` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号类型（1.专家/2.普通）',
  `regTime` datetime(0) NOT NULL COMMENT '挂号时间（病人挂号的时间）',
  `rotaId` bigint(0) NOT NULL COMMENT '外键-选择排班的排班ID',
  `departmentId` int(0) NOT NULL COMMENT '外键-科室ID',
  `roomId` int(0) NOT NULL COMMENT '外键-房间ID',
  `visitTime` date NOT NULL COMMENT '挂号的就诊时间',
  `visitSection` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '就诊时间段（1、上午，2、下午）',
  `price` decimal(5, 2) NOT NULL COMMENT '挂号费',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号类型（1、线上，2、线下）',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_register
-- ----------------------------
INSERT INTO `h_register` VALUES (1, 'CZ12345', 1, '1', '2021-06-18 18:14:29', 1, 1, 1, '2021-06-18', '1', 5.00, '2', '1');

SET FOREIGN_KEY_CHECKS = 1;
