/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : vue

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-03 16:56:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT NULL COMMENT '父节点ID',
  `menuName` varchar(20) NOT NULL COMMENT '菜单名称',
  `menuPath` varchar(50) DEFAULT NULL COMMENT '请求路径',
  `components` varchar(50) DEFAULT NULL COMMENT '组件路径',
  `menuTitle` varchar(50) DEFAULT NULL COMMENT '菜单标题',
  `menuIcon` varchar(50) DEFAULT NULL COMMENT '图标',
  `isHidden` tinyint(1) DEFAULT '0' COMMENT '是否隐藏',
  `isCache` tinyint(1) DEFAULT '0' COMMENT '是否缓存',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', 'example', 'example', '', 'Table', 'example', '0', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', 'Table', 'table', 'table/index', 'Table', 'table', '0', '0');
INSERT INTO `sys_menu` VALUES ('3', '1', 'Tree', 'tree', 'tree/index', 'Tree', 'tree', '0', '0');
INSERT INTO `sys_menu` VALUES ('4', '0', 'form', 'form', null, 'Form', 'form', '0', '0');
