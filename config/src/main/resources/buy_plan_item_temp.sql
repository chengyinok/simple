/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : simple

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-05 23:33:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buy_plan_item_temp
-- ----------------------------
DROP TABLE IF EXISTS `buy_plan_item_temp`;
CREATE TABLE `buy_plan_item_temp` (
  `buyPlanItemId` int(11) NOT NULL AUTO_INCREMENT,
  `buyPlanId` varchar(15) DEFAULT NULL,
  `directoryId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `commonName` varchar(255) DEFAULT NULL,
  `goodsSpec` varchar(255) DEFAULT '',
  `goodsUtil` varchar(30) DEFAULT '',
  `goodsFactory` varchar(255) DEFAULT '',
  `userBuyerId` int(11) NOT NULL,
  `userSupperId` int(11) DEFAULT NULL,
  `userSupperName` varchar(255) DEFAULT '',
  `goodsPrice` decimal(20,4) DEFAULT '0.0000',
  `planNum` decimal(20,4) DEFAULT '0.0000',
  `itemAmount` decimal(20,2) DEFAULT '0.00',
  `createUserId` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `monthUsed` decimal(20,2) DEFAULT '0.00',
  `storageNum` decimal(20,2) DEFAULT '0.00',
  `sellPrice` decimal(20,4) DEFAULT '0.0000',
  `lastNo` varchar(100) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`buyPlanItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=13483 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy_plan_item_temp
-- ----------------------------
INSERT INTO `buy_plan_item_temp` VALUES ('1', '1503649862580', null, null, '3L粘贴伤口敷料', '6cm*7cm', '张', '江西3L医用制品', '137', null, '江西3L医用制品集团有限公司上海分公司', '1.0000', '9600.0000', '9600.00', '255', '2017-08-25 16:34:03', '0.00', '3180.00', '3180.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('2', '1503649862580', null, null, '编织吸收性缝线', 'VCP345H    2-0', '盒', '美国', '137', null, '温州厚生商贸有限公司', '1620.0000', '4.0000', '6480.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('3', '1503649862580', null, null, '编织吸收性缝线', 'VCP317H', '盒', '美国', '137', null, '温州厚生商贸有限公司', '1620.0000', '2.0000', '3240.00', '255', '2017-08-25 16:34:03', '0.00', '2.00', '2.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('4', '1503649862580', null, null, '编织吸收性缝线', 'VCP310H   4-0', '盒', '美国强生集团理', '137', null, '温州厚生商贸有限公司', '1733.0400', '4.0000', '6932.16', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('5', '1503649862580', null, null, '编织吸收性缝线', 'VCP311H 36包', '盒', '美国强生集团理', '137', null, '温州厚生商贸有限公司', '1700.0000', '4.0000', '6800.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('6', '1503649862580', null, null, '编织吸收性缝线', 'VCP433H 5-0', '盒', '美国', '137', null, '温州厚生商贸有限公司', '1852.0000', '4.0000', '7408.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('7', '1503649862580', null, null, '创可贴', '100片/盒', '盒', '杭州江南世家', '137', null, '瓯文医疗科技（上海）有限公司', '7.0000', '80.0000', '560.00', '255', '2017-08-25 16:34:03', '0.00', '27.00', '27.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('8', '1503649862580', null, null, '导尿管（子宫造影管）', 'F12', '支', '扬州市邗江华飞', '137', null, '扬州捷凯医疗器械有限公司', '3.9000', '100.0000', '390.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('9', '1503649862580', null, null, '碘伏', '500ml', '瓶', '上海利康', '137', null, '上海中优医药高科技股份有限公司', '6.5000', '240.0000', '1560.00', '255', '2017-08-25 16:34:03', '0.00', '60.00', '60.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('10', '1503649862580', null, null, '电极导管', '18Fr', '条', '上海淞行', '137', null, '北京阳光同盛医疗器械有限公司', '65.7200', '360.0000', '23659.20', '255', '2017-08-25 16:34:03', '0.00', '120.00', '120.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('11', '1503649862580', null, null, '反应杯 西门子', '200个/包', '包', '美国', '137', null, '上海倍特生物科技有限公司', '90.1200', '60.0000', '5407.20', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('12', '1503649862580', null, null, '洁芙柔抗菌洗手液', '500ml', '瓶', '上海利康', '137', null, '上海中优医药高科技股份有限公司', '23.0000', '24.0000', '552.00', '255', '2017-08-25 16:34:03', '0.00', '4.00', '4.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('13', '1503649862580', null, null, '洁芙柔免洗手消毒凝胶', '500ml', '瓶', '国产', '137', null, '上海中优医药高科技股份有限公司', '23.0000', '24.0000', '552.00', '255', '2017-08-25 16:34:03', '0.00', '29.00', '29.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('14', '1503649862580', null, null, '静脉留置针', '22G*1.0蓝', '支', '苏州碧迪医疗器', '137', null, '瓯文医疗科技（上海）有限公司', '13.5000', '200.0000', '2700.00', '255', '2017-08-25 16:34:03', '0.00', '200.00', '200.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('15', '1503649862580', null, null, '静脉留置针', '24G*0.75黄', '支', '苏州碧迪医疗器', '137', null, '扬州捷凯医疗器械有限公司', '12.8000', '300.0000', '3840.00', '255', '2017-08-25 16:34:03', '0.00', '100.00', '100.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('16', '1503649862580', null, null, '利器盒', '大号', '只', '国产', '137', null, '上海康艺园环保科技有限公司', '6.5000', '80.0000', '520.00', '255', '2017-08-25 16:34:03', '0.00', '86.00', '86.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('17', '1503649862580', null, null, '灭菌纱布片', '7.5*7.5', '片', '宁波申源', '137', null, '上海舜屹医疗器械有限公司', '0.2300', '9600.0000', '2208.00', '255', '2017-08-25 16:34:03', '0.00', '5700.00', '5700.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('18', '1503649862580', null, null, '男性试子', '100支/包', '支', '江苏长丰', '137', null, '扬州捷凯医疗器械有限公司', '0.2200', '2000.0000', '440.00', '255', '2017-08-25 16:34:03', '0.00', '1800.00', '1800.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('19', '1503649862580', null, null, '女性试子', '支', '支', '江苏康健医疗用', '137', null, '上海舜屹医疗器械有限公司', '0.3500', '2000.0000', '700.00', '255', '2017-08-25 16:34:03', '0.00', '1700.00', '1700.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('20', '1503649862580', null, null, '热敏素白记录纸', '57mm*50m', '卷', '沈阳试剂三厂', '137', null, '常州博凯医疗器械有限公司', '4.5000', '30.0000', '135.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('21', '1503649862580', null, null, '砂轮', '10片 大', '盒', '上海齿科材料厂', '137', null, '上海恒翌医疗器械有限公司', '4.9000', '40.0000', '196.00', '255', '2017-08-25 16:34:03', '0.00', '3.00', '3.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('22', '1503649862580', null, null, '脱脂纱布块', '10cm*20cm-8P', '块', '阜宁县阜达卫生材料厂', '137', null, '无锡市恒通医药卫生用品有限公司', '0.6000', '2000.0000', '1200.00', '255', '2017-08-25 16:34:03', '0.00', '900.00', '900.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('23', '1503649862580', null, null, '小针刀', '0.6*50 100支/盒', '盒', '北京卓越华友', '137', null, '扬州捷凯医疗器械有限公司', '95.0000', '5.0000', '475.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('24', '1503649862580', null, null, '小针刀', '0.4*40 100支/盒', '盒', '北京卓越华友', '137', null, '扬州捷凯医疗器械有限公司', '140.0000', '3.0000', '420.00', '255', '2017-08-25 16:34:03', '0.00', '2.00', '2.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('25', '1503649862580', null, null, '血凝比色杯CA500', '2000个/包', '包', '国产', '137', null, '扬州捷凯医疗器械有限公司', '130.0000', '8.0000', '1040.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('26', '1503649862580', null, null, '血糖试纸.针', '50条', '套', '杭州艾康', '137', null, '厦门市海菲生物技术有限公司', '60.0000', '40.0000', '2400.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('27', '1503649862580', null, null, '血压计.听诊器套装', '套', '套', '国产', '137', null, '上海恒翌医疗器械有限公司', '115.0000', '4.0000', '460.00', '255', '2017-08-25 16:34:03', '0.00', '1.00', '1.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('28', '1503649862580', null, null, '眼用镊', '10cm直唇头齿(无镀边)', '把', '上海三友外科', '137', null, '上海三友医疗器械经营有限公司', '12.8700', '3.0000', '38.61', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('29', '1503649862580', null, null, '样品TIP头 西门子', '360个/包', '包', '美国', '137', null, '上海倍特生物科技有限公司', '249.9600', '36.0000', '8998.56', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('30', '1503649862580', null, null, '一次性备皮刀', '个', '个', '江苏省永宁医疗', '137', null, '瓯文医疗科技（上海）有限公司', '0.8800', '300.0000', '264.00', '255', '2017-08-25 16:34:03', '0.00', '100.00', '100.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('31', '1503649862580', null, null, '一次性垫单', '40*50', '片', '无锡市恒通医药', '137', null, '无锡市恒通医药卫生用品有限公司', '0.1900', '6000.0000', '1140.00', '255', '2017-08-25 16:34:03', '0.00', '1600.00', '1600.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('32', '1503649862580', null, null, '一次性口腔包', '只', '只', '霸州市金盛医疗', '137', null, '苏州登特商贸有限公司', '1.0000', '1000.0000', '1000.00', '255', '2017-08-25 16:34:03', '0.00', '600.00', '600.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('33', '1503649862580', null, null, '一次性使用输氧面罩', '个', '个', '/', '137', null, '/', '0.0000', '200.0000', '0.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('34', '1503649862580', null, null, '一次性扩阴器', '小号', '只', '常州市创佳', '137', null, '上海美晨工贸有限公司', '0.8000', '480.0000', '384.00', '255', '2017-08-25 16:34:03', '0.00', '420.00', '420.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('35', '1503649862580', null, null, '一次性灭菌橡胶手套', '7#', '付', '上海科邦', '137', null, '南通市亚晖医疗器械有限公司', '2.0000', '400.0000', '800.00', '255', '2017-08-25 16:34:03', '0.00', '950.00', '950.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('36', '1503649862580', null, null, '一次性灭菌橡胶手套', '7.5', '付', '上海科邦', '137', null, '南通市亚晖医疗器械有限公司', '2.0000', '800.0000', '1600.00', '255', '2017-08-25 16:34:03', '0.00', '650.00', '650.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('37', '1503649862580', null, null, '一次性乳胶检查手套', 's 100只', '盒', '马来西亚', '137', null, '博洹国际贸易（上海）有限公司', '25.0000', '100.0000', '2500.00', '255', '2017-08-25 16:34:03', '0.00', '57.00', '57.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('38', '1503649862580', null, null, '一次性使用无菌掀针', '0.22*1.3 1000支/箱', '箱', '吴江市云龙医疗', '137', null, '上海博雄医疗器械有限公司', '4200.0000', '6.0000', '25200.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('39', '1503649862580', null, null, '一次性输液器', 'YS04A-2H0.6*25', '套', '江西洪达', '137', null, '江西大卫医疗器械有限公司', '0.6100', '2000.0000', '1220.00', '255', '2017-08-25 16:34:03', '0.00', '3400.00', '3400.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('40', '1503649862580', null, null, '一次性弯盘', 'I号*100个/包', '个', '江苏华飞', '137', null, '扬州捷凯医疗器械有限公司', '0.2000', '4000.0000', '800.00', '255', '2017-08-25 16:34:03', '0.00', '1700.00', '1700.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('41', '1503649862580', null, null, '一次性真空采血管-EDTA', '2ml紫WZK-K2E', '套', '江苏康健医疗用', '137', null, '厦门市海菲生物技术有限公司', '0.3200', '2400.0000', '768.00', '255', '2017-08-25 16:34:03', '0.00', '600.00', '600.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('42', '1503649862580', null, null, '一次性中单', '60*70', '条', '无锡恒通医药卫', '137', null, '无锡市恒通医药卫生用品有限公司', '0.2800', '6000.0000', '1680.00', '255', '2017-08-25 16:34:03', '0.00', '1850.00', '1850.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('43', '1503649862580', null, null, '一次性中单', '100*200', '张', '无锡市恒通医药', '137', null, '无锡市恒通医药卫生用品有限公司', '2.1000', '300.0000', '630.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('44', '1503649862580', null, null, '医用磁贴 600M', '17*18.5*1袋/盒', '套', '徐州东南电子', '137', null, '江西珍卉医疗科技有限公司', '15.0000', '400.0000', '6000.00', '255', '2017-08-25 16:34:03', '0.00', '240.00', '240.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('45', '1503649862580', null, null, '医用输液护贴', '100片/盒 38*72', '盒', '上海好贴卫生用', '137', null, '上海舜屹医疗器械有限公司', '5.5000', '100.0000', '550.00', '255', '2017-08-25 16:34:03', '0.00', '27.00', '27.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('46', '1503649862580', null, null, '医用咬口', '只', '只', '扬州龙虎', '137', null, '扬州贺尔斯医疗器械有限公司', '1.2000', '100.0000', '120.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('47', '1503649862580', null, null, '硬膜外麻醉导管及导管接头', '1.0mm', '支', '新乡鸵人', '137', null, '河南曼夫医疗器械商贸有限公司', '40.0000', '200.0000', '8000.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('48', '1503649862580', null, null, '硅凝胶', '15g', '支', '美国先进生物', '137', null, '上海康奥医疗科技有限公司', '260.0000', '72.0000', '18720.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('49', '1503649862580', null, null, '强氯杀星消毒片', '500mg*100片', '瓶', '上海利康消毒高', '137', null, '上海中优医药高科技股份有限公司', '6.0000', '100.0000', '600.00', '255', '2017-08-25 16:34:03', '0.00', '136.00', '136.0000', null, '补计划');
INSERT INTO `buy_plan_item_temp` VALUES ('50', '1503649862580', null, null, '胶片', '8*10', '盒', '美国', '137', null, '康达洲际医疗器械（宁波）有限公司', '800.0000', '10.0000', '8000.00', '255', '2017-08-25 16:34:03', '0.00', '2.00', '2.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('51', '1503649862580', null, null, '针灸针', '0.35*75', '支', '无锡佳健', '137', null, '无锡佳健医疗器械股份有限公司', '0.1200', '50000.0000', '6000.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('52', '1503649862580', null, null, '针灸针', '0.30*60', '支', '无锡佳健', '137', null, '无锡佳健医疗器械股份有限公司', '0.1200', '50000.0000', '6000.00', '255', '2017-08-25 16:34:03', '0.00', '11500.00', '11500.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('53', '1503649862580', null, null, '竹火罐', '大号', '套', '国产', '137', null, '上海舜屹医疗器械有限公司', '15.0000', '30.0000', '450.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('54', '1503649862580', null, null, '竹火罐', '小号', '套', '国产', '137', null, '上海舜屹医疗器械有限公司', '15.0000', '20.0000', '300.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('55', '1503649862580', null, null, '电容箱', '109', '个', '国产', '137', null, '深圳市慧康医疗器械有限公司', '4000.0000', '1.0000', '4000.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('56', '1503649862580', null, null, 'A6B超黑白打印纸', '110mm*20m', '个', '/', '137', null, '/', '0.0000', '6.0000', '0.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '');
INSERT INTO `buy_plan_item_temp` VALUES ('57', '1503649862580', null, null, '一次性滴定管式输液器', '250ml', '套', '江西洪达', '137', null, '江西大卫医疗器械有限公司', '2.7000', '100.0000', '270.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '补计划');
INSERT INTO `buy_plan_item_temp` VALUES ('58', '1503649862580', null, null, '一次性气管切开包', '套', '套', '江苏荣业', '137', null, '扬州贺尔斯医疗器械有限公司', '260.0000', '1.0000', '260.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '手术室');
INSERT INTO `buy_plan_item_temp` VALUES ('59', '1503649862580', null, null, '腹腔镜手术分离钳', '把', '把', '杭州市桐卢医疗', '137', null, '/', '0.0000', '1.0000', '0.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '手术室');
INSERT INTO `buy_plan_item_temp` VALUES ('60', '1503649862580', null, null, '腹腔镜用无损伤钳', '把', '把', '杭州市桐卢医疗', '137', null, '/', '0.0000', '1.0000', '0.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '手术室');
INSERT INTO `buy_plan_item_temp` VALUES ('61', '1503649862580', null, null, '腹腔镜用吸引器', '个', '个', '上海广慈医学高', '137', null, '/', '0.0000', '1.0000', '0.00', '255', '2017-08-25 16:34:03', '0.00', '0.00', '0.0000', null, '手术室');
