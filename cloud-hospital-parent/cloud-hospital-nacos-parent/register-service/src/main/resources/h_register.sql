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

 Date: 22/06/2021 11:56:51
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
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '病人状态(0、待就诊 1、已就诊)',
  `createTime` datetime(0) NOT NULL COMMENT '病人建档时间',
  `mediCard` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '病人医保卡号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_patient
-- ----------------------------
INSERT INTO `h_patient` VALUES (38, 'WONIU20210622102208374172', '刘小雨', 21, '0', '17654534523', '374362452554532656', '0', '2021-06-22 02:22:08', NULL);

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
  `roomId` int(0) NULL DEFAULT NULL COMMENT '外键-房间ID',
  `visitTime` date NOT NULL COMMENT '挂号的就诊时间',
  `visitSection` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '就诊时间段（1、上午，2、下午）',
  `price` decimal(5, 2) NOT NULL COMMENT '挂号费',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号类型（1、线上，2、线下）',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '挂号状态',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登入的手机号，用于查看订单的',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_register
-- ----------------------------
INSERT INTO `h_register` VALUES (11, 'GH20210622102208869988203', 38, '2', '2021-06-22 02:22:09', 12, 1, NULL, '2021-06-22', '1', 5.00, '1', '0', '17683858973');

SET FOREIGN_KEY_CHECKS = 1;
