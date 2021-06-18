/*
Navicat MySQL Data Transfer

Source Server         : four-hospital
Source Server Version : 80025
Source Host           : 1.117.97.60:3307
Source Database       : hospital_four

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-06-18 19:00:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h_drug
-- ----------------------------
DROP TABLE IF EXISTS `h_drug`;
CREATE TABLE `h_drug` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `salePrice` decimal(10,0) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `typeId` int DEFAULT NULL,
  `costPrice` decimal(10,0) DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `productionTime` datetime DEFAULT NULL,
  `expirationTime` datetime DEFAULT NULL,
  `expirationDate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param1` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `param2` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drug
-- ----------------------------
INSERT INTO `h_drug` VALUES ('1', '1', '阿莫西林', '25', '124', '1', '17', '北京生物制药', '2021-03-02 00:00:00', '2021-09-02 18:14:33', '6个月', '1', null, null);
INSERT INTO `h_drug` VALUES ('2', '2', '头孢', '25', '200', '1', '20', '武汉生物制药', '2021-03-02 00:00:00', '2022-06-16 18:15:08', '12个月', '1', null, null);
INSERT INTO `h_drug` VALUES ('3', '3', '美西律', '12', '500', '2', '10', '天津生物制药', '2021-03-02 00:00:00', '2024-06-16 18:15:20', '3年', '1', null, null);
INSERT INTO `h_drug` VALUES ('5', '4', '西瓜霜', '8', '200', '16', '5', '武汉生物制药', '2021-03-02 00:00:00', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('6', '5', '清血解毒合剂', '20', '300', '16', '15', '武汉生物制药', '2021-03-02 00:00:00', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('7', '6', '甲氧氯普胺', '34', '56', '3', '30', '天津生物制药', '2021-04-02 00:00:00', null, null, '0', null, null);
INSERT INTO `h_drug` VALUES ('8', '7', '多潘立酮', '128', '111', '3', '123', '湖北省八峰药业', '2021-05-14 08:00:00', null, null, '0', null, null);
INSERT INTO `h_drug` VALUES ('9', '8', '昔萘沙美特罗气雾剂', '19', '500', '4', '16', '湖北省八峰药业', '2021-05-19 08:00:00', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('10', '9', '曲尼司特', '200', '250', '4', '200', '湖北省八峰药业', '2021-05-19 08:00:00', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('11', '10', '维生素B12注射液', '321', '100', '6', '316', '北京生物制药', '2021-04-27 00:10:44', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('12', '11', '氯吡格雷', '66', '100', '6', '61', '深圳万和制药', '2021-04-14 00:10:49', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('13', '12', '阿加曲班', '56', '100', '6', '51', '北京生物制药', '2021-03-17 00:10:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('14', '13', '达比加群酯', '123', '100', '6', '118', '天津生物制药', '2011-06-13 00:11:07', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('15', '14', '右旋糖酐20', '202', '100', '6', '197', '北京生物制药', '2021-03-10 00:11:00', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('16', '15', '华素片', '700', '100', '7', '680', '天津生物制药', '2021-03-25 00:11:14', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('17', '16', '罗红霉素', '500', '100', '7', '480', '北京生物制药', '2004-12-01 00:11:21', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('18', '17', '红霉素', '340', '100', '7', '320', '深圳万和制药', '2021-02-03 00:11:32', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('19', '18', '喹诺酮类', '180', '100', '7', '175', '北京生物制药', '2021-03-19 00:11:40', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('20', '19', '呋喃坦啶', '1200', '100', '5', '1180', '天津生物制药', '2021-03-05 00:11:50', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('21', '20', '复方新诺明', '680', '100', '5', '670', '深圳万和制药', '2018-11-15 00:12:22', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('22', '21', '呋喃妥因', '566', '100', '5', '551', '深圳万和制药', '2021-05-07 00:12:28', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('23', '22', '甾体激素', '66', '100', '8', '61', '天津生物制药', '2021-03-27 00:12:31', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('24', '23', '非甾体消炎药', '14', '100', '8', '12', '佛山康宝顺药业有限公司', '2020-07-30 00:12:42', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('25', '24', '青霉胺', '23', '100', '8', '20', '天津生物制药', '2020-07-30 00:12:42', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('26', '25', '来氟米特', '42', '100', '8', '39', '佛山康宝顺药业有限公司', '2020-07-30 00:12:42', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('27', '26', '粉针剂', '350', '100', '9', '330', '天津生物制药', '2021-01-14 00:12:54', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('28', '27', '盐酸普鲁卡因注射液', '520', '100', '9', '500', '广东天普药业', '2021-01-29 00:13:01', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('29', '28', '消痔灵注射液', '220', '100', '9', '210', '天津生物制药', '2021-01-21 00:13:05', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('30', '29', '胰岛素', '298', '100', '10', '288', '佛山康宝顺药业有限公司', '2021-03-26 00:13:11', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('31', '30', '磺酰脲类促泌剂', '156', '100', '10', '151', '广东天普药业', '2021-01-28 00:13:15', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('32', '31', '二甲双胍类', '352', '100', '10', '346', '深圳万和制药', '2021-03-25 00:13:21', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('33', '32', '糖皮质激素', '888', '100', '11', '888', '广东天普药业', '2020-07-24 00:13:25', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('34', '33', '肾上腺皮质激素', '1300', '100', '11', '1280', '佛山康宝顺药业有限公司', '2021-02-11 00:14:09', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('35', '34', '去甲肾上腺激素', '366', '100', '11', '356', '深圳万和制药', '2021-05-04 00:14:14', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('36', '35', '鱼石脂', '22', '100', '12', '20', '北京生物制药', '2021-03-18 00:14:19', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('37', '36', '甲氧沙林', '36', '100', '12', '32', '深圳万和制药', '2021-04-13 00:14:25', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('38', '37', '山牡丹胶囊', '128', '100', '13', '120', '佛山康宝顺药业有限公司', '2021-01-14 00:14:32', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('39', '38', '妇炎洁植物本草抑菌洗液', '98', '100', '13', '95', '上海生化制药厂', '2021-02-25 00:14:37', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('40', '39', '脑络通胶囊', '151', '100', '13', '146', '佛山康宝顺药业有限公司', '2021-03-17 00:14:43', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('41', '40', '氮芥', '413', '100', '14', '400', '广东天普药业', '2021-02-25 00:14:48', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('42', '41', '顺铂', '398', '100', '14', '360', '上海生化制药厂', '2021-02-10 00:17:11', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('43', '42', '丝裂霉素', '660', '100', '14', '640', '北京生物制药', '2021-03-10 00:17:16', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('44', '43', '门冬酰胺酶', '575', '100', '14', '540', '广东天普药业', '2004-07-13 00:17:21', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('45', '44', '抗多巴胺', '198', '100', '15', '193', '佛山康宝顺药业有限公司', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('46', '45', '抗去甲肾上腺素', '360', '100', '15', '340', '上海生化制药厂', '2021-03-17 00:17:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('47', '46', '抗血清素', '211', '100', '15', '198', '广东天普药业', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('48', '47', '抗胆碱', '112', '100', '15', '105', '佛山康宝顺药业有限公司', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('49', '48', '黄连', '36', '100', '16', '32', '上海生化制药厂', '2021-03-17 00:17:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('50', '49', '岑连', '72', '100', '16', '68', '上海生化制药厂', '2021-05-05 21:04:30', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('51', '50', '板蓝根', '20', '100', '16', '16', '北京生物制药', '2021-03-17 00:17:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('52', '51', 'M胆碱受体阻断药', '166', '100', '17', '98', '上海生化制药厂', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('53', '52', 'N胆碱受体阻断药', '134', '100', '17', '100', '上海生化制药厂', '2021-03-17 00:17:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('54', '53', '阿托品', '241', '100', '17', '210', '佛山康宝顺药业有限公司', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('55', '54', '人参', '800', '100', '18', '300', '广东天普药业', '2021-05-13 00:18:06', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('56', '55', '党参', '1200', '100', '18', '400', '广东天普药业', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('57', '56', '山药', '30', '100', '18', '5', '天津生物制药', '2021-03-17 00:17:55', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('58', '57', '复合维生素矿物质营养片 ', '212', '100', '19', '130', '上海生化制药厂', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('59', '58', '维生素B', '120', '100', '19', '50', '佛山康宝顺药业有限公司', '2021-02-25 00:17:34', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('60', '59', '维生素E', '68', '100', '19', '38', '广东天普药业', '2021-02-11 00:18:11', null, null, '1', null, null);
INSERT INTO `h_drug` VALUES ('61', '60', '阿莫西林', '0', '0', '3', null, '北京生物制药2', null, null, null, null, null, null);
INSERT INTO `h_drug` VALUES ('62', '61', '阿莫西林', '1', '12', '3', null, '北京生物制药3', null, null, null, null, null, null);
INSERT INTO `h_drug` VALUES ('64', null, '阿莫西林', '128', '23', '1', '88', '北京生物制药4', '2021-06-10 00:00:00', '2021-06-25 00:00:00', null, null, null, null);

-- ----------------------------
-- Table structure for h_drug_in_record
-- ----------------------------
DROP TABLE IF EXISTS `h_drug_in_record`;
CREATE TABLE `h_drug_in_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '进库编码',
  `doctorId` int NOT NULL COMMENT '外键-经手药房医生ID',
  `stockTime` datetime NOT NULL COMMENT '进货时间',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '进货单状态',
  `param1` bigint DEFAULT NULL,
  `param2` int DEFAULT NULL,
  `param3` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param4` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drug_in_record
-- ----------------------------

-- ----------------------------
-- Table structure for h_drug_in_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `h_drug_in_record_detail`;
CREATE TABLE `h_drug_in_record_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `recordId` bigint NOT NULL COMMENT '外键-进货单ID',
  `medId` bigint NOT NULL COMMENT '外键-药品ID',
  `count` bigint NOT NULL COMMENT '该药品进货数量',
  `price` decimal(18,2) NOT NULL COMMENT '进货单价',
  `param1` int DEFAULT NULL,
  `param2` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param3` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param4` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drug_in_record_detail
-- ----------------------------

-- ----------------------------
-- Table structure for h_drug_loss
-- ----------------------------
DROP TABLE IF EXISTS `h_drug_loss`;
CREATE TABLE `h_drug_loss` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lossDrugNo` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `lossDrugName` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `lossReason` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `lossDrugNum` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drug_loss
-- ----------------------------

-- ----------------------------
-- Table structure for h_drug_out_record
-- ----------------------------
DROP TABLE IF EXISTS `h_drug_out_record`;
CREATE TABLE `h_drug_out_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '药品记录no',
  `adviceId` bigint DEFAULT NULL COMMENT '外键-医嘱ID',
  `medId` bigint NOT NULL COMMENT '外键-药品ID',
  `patientId` bigint NOT NULL COMMENT '外键-取药病人ID',
  `count` int NOT NULL COMMENT '购买数量',
  `price` decimal(18,2) NOT NULL COMMENT '购买单价（记录用）',
  `fetchTime` datetime DEFAULT NULL COMMENT '取药时间',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '药品单状态',
  `param1` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param2` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `param3` int DEFAULT NULL,
  `param4` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drug_out_record
-- ----------------------------

-- ----------------------------
-- Table structure for h_drugodd
-- ----------------------------
DROP TABLE IF EXISTS `h_drugodd`;
CREATE TABLE `h_drugodd` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `doctorid` int DEFAULT NULL,
  `totalmoney` decimal(20,2) DEFAULT NULL,
  `patientid` int DEFAULT NULL,
  `status` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drugodd
-- ----------------------------
INSERT INTO `h_drugodd` VALUES ('1', '001', '2021-06-17 20:56:33', '1', '998.00', '1', '1');
INSERT INTO `h_drugodd` VALUES ('2', '002', '2021-06-18 14:54:44', '2', '889.00', '2', '1');
INSERT INTO `h_drugodd` VALUES ('3', '003', '2021-06-18 10:25:36', '3', '1988.00', '3', '1');
INSERT INTO `h_drugodd` VALUES ('4', '004', '2021-06-19 10:26:00', '4', '2088.00', '4', '0');
INSERT INTO `h_drugodd` VALUES ('5', '005', '2021-06-18 14:58:02', '2', '555.00', '2', '0');

-- ----------------------------
-- Table structure for h_drugodd_detail
-- ----------------------------
DROP TABLE IF EXISTS `h_drugodd_detail`;
CREATE TABLE `h_drugodd_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `drugoddId` bigint DEFAULT NULL,
  `drugId` int DEFAULT NULL,
  `drugNum` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drugodd_detail
-- ----------------------------
INSERT INTO `h_drugodd_detail` VALUES ('1', '1', '1', '2');
INSERT INTO `h_drugodd_detail` VALUES ('2', '1', '2', '3');
INSERT INTO `h_drugodd_detail` VALUES ('3', '2', '1', '5');

-- ----------------------------
-- Table structure for h_drugtype
-- ----------------------------
DROP TABLE IF EXISTS `h_drugtype`;
CREATE TABLE `h_drugtype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `drugtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of h_drugtype
-- ----------------------------
INSERT INTO `h_drugtype` VALUES ('1', '抗生素类药品');
INSERT INTO `h_drugtype` VALUES ('2', '心脑血管用药');
INSERT INTO `h_drugtype` VALUES ('3', '消化系统用药');
INSERT INTO `h_drugtype` VALUES ('4', '呼吸系统用药');
INSERT INTO `h_drugtype` VALUES ('5', '泌尿系统用药');
INSERT INTO `h_drugtype` VALUES ('6', '血液系统用药');
INSERT INTO `h_drugtype` VALUES ('7', '五官科用');
INSERT INTO `h_drugtype` VALUES ('8', '抗风湿类药品');
INSERT INTO `h_drugtype` VALUES ('9', '注射剂类药品');
INSERT INTO `h_drugtype` VALUES ('10', '糖尿病用药');
INSERT INTO `h_drugtype` VALUES ('11', '激素类药品');
INSERT INTO `h_drugtype` VALUES ('12', '皮肤科用药');
INSERT INTO `h_drugtype` VALUES ('13', '妇科用药');
INSERT INTO `h_drugtype` VALUES ('14', '抗肿瘤用药');
INSERT INTO `h_drugtype` VALUES ('15', '抗精神病药品');
INSERT INTO `h_drugtype` VALUES ('16', '清热解毒药品');
INSERT INTO `h_drugtype` VALUES ('17', '受体激动\\阻断药和抗过敏药');
INSERT INTO `h_drugtype` VALUES ('18', '滋补类药品');
INSERT INTO `h_drugtype` VALUES ('19', '维生素、矿物质药品');
