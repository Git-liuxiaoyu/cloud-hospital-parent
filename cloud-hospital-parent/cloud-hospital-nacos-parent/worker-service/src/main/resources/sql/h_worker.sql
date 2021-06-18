/*
 Navicat Premium Data Transfer

 Source Server         : XY-MySQL-Linux
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 1.117.97.60:3307
 Source Schema         : h_worker

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 18/06/2021 17:59:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_department
-- ----------------------------
DROP TABLE IF EXISTS `h_department`;
CREATE TABLE `h_department`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `divisionId` int NOT NULL COMMENT '外键-大类别ID',
  `no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '科室编号',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '科室名称',
  `directorId` bigint NOT NULL COMMENT '科室主任',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '科室所在地（一般在住院楼）',
  `phone` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '科室联系方式（座机）',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '科室描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '科室状态',
  `param1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `param2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `param3` bigint NULL DEFAULT NULL,
  `param4` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_h_department_h_division_1`(`divisionId`) USING BTREE,
  CONSTRAINT `fk_h_department_h_division_1` FOREIGN KEY (`divisionId`) REFERENCES `h_division` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_department
-- ----------------------------
INSERT INTO `h_department` VALUES (1, 1, 'DEPART20210617174311425134', '心脏内科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (2, 1, 'DEPART20210617174311154680', '心脏外科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (3, 2, 'DEPART20210617174311287500', '神经内科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (4, 2, '20210617174311232577', '笑话内科 ', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (5, 3, '20210617174311365253', '泌尿外科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (6, 3, '20210617174311465881', '普外科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (7, 4, '20210617174311785417', '妇科门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (8, 4, '20210617174311807465', '产科门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (9, 5, '20210617174311938101', '儿科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (10, 6, '20210617174311929353', '口腔科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (11, 7, '20210617174311650316', '针灸科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (12, 7, '20210617174311446863', '按摩科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (13, 7, '20210617174311638381', '中医科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (14, 8, '20210617174311815918', '皮肤科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (15, 8, '20210617174311537189', '美容门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (16, 9, '20210617174311277751', '肠道门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (17, 9, '20210617174311639227', '肝炎门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (18, 9, '20210617174311799658', '发热门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (19, 10, '20210617174311370646', '心理咨询门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (20, 11, '20210617174311647378', 'CT室', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (21, 11, '20210617174311432527', '普通放射科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (22, 11, '20210617174311670350', '核医学门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (23, 12, '20210617174311587479', '职业病门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (24, 13, '20210617174311470886', '疑难病会诊中心', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (26, 14, '20210617174311527134', '放疗科', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (27, 15, '20210617174311876655', '先天性心脏病门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (28, 15, '20210617174311545608', '通风门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (29, 15, '20210617174311851474', '睡眠障碍门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `h_department` VALUES (30, 15, '20210617174311703491', '老年综合症门诊', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for h_division
-- ----------------------------
DROP TABLE IF EXISTS `h_division`;
CREATE TABLE `h_division`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '大类别名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '大类别描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '大类别状态',
  `param1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `param2` datetime NULL DEFAULT NULL,
  `param3` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_division
-- ----------------------------
INSERT INTO `h_division` VALUES (1, '心脏中心', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (2, '内科系统', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (3, '外科系统', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (4, '妇产科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (5, '儿科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (6, '五官科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (7, '中医科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (8, '皮肤科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (9, '感染性疾病科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (10, '临床心理科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (11, '医学影像', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (12, '职业病', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (13, '特需门诊', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (14, '放射治疗科', NULL, '1', NULL, NULL, NULL);
INSERT INTO `h_division` VALUES (15, '专病门诊', NULL, '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for h_out_room
-- ----------------------------
DROP TABLE IF EXISTS `h_out_room`;
CREATE TABLE `h_out_room`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `departmentId` int NOT NULL COMMENT '外键-科室ID',
  `roomName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '房间名称',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '房间状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_h_room_h_department_1`(`departmentId`) USING BTREE,
  CONSTRAINT `fk_h_room_h_department_1` FOREIGN KEY (`departmentId`) REFERENCES `h_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_out_room
-- ----------------------------
INSERT INTO `h_out_room` VALUES (1, 1, '诊室1', '1');
INSERT INTO `h_out_room` VALUES (2, 1, '诊室2', '1');

-- ----------------------------
-- Table structure for h_user
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE `h_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `workerNo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '外键-员工No',
  `lastLoginTime` datetime NOT NULL COMMENT '上一次登录时间',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_h_user_h_worker_info_1`(`workerNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_user
-- ----------------------------
INSERT INTO `h_user` VALUES (1, '123', '123', 'STAFF20210616175114619751', '2021-06-16 18:01:36', '1');

-- ----------------------------
-- Table structure for h_worker_info
-- ----------------------------
DROP TABLE IF EXISTS `h_worker_info`;
CREATE TABLE `h_worker_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工编号',
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工姓名',
  `birthday` date NOT NULL COMMENT '员工生日',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工性别',
  `phone` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工手机号',
  `identityNo` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工身份证号',
  `topEducation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工最高学历',
  `career` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工履历',
  `departmentId` int NOT NULL COMMENT '员工所属部门（科室）',
  `positionId` int NOT NULL COMMENT '员工职位（外键-职位表）',
  `signTime` datetime NOT NULL COMMENT '员工入职时间',
  `resignTime` datetime NULL DEFAULT NULL COMMENT '员工离职时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '员工照片',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '员工状态',
  `param2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `param3` bigint NULL DEFAULT NULL,
  `param4` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_h_worker_info_h_position_1`(`positionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_worker_info
-- ----------------------------
INSERT INTO `h_worker_info` VALUES (1, 'STAFF20210616175114619751', '张方松', '1998-07-20', '1', '18071410720', '420111199807203719', '武汉工程大学本科', '无', 1, 1, '2021-06-17 15:03:49', '2021-06-17 15:03:52', '111', '1', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
