/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2020-08-28 18:34:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `pids` varchar(512) DEFAULT '' COMMENT '父级ids',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('24', '0', '[0],', '总公司', '', '1', null, null, null, null);
INSERT INTO `dept` VALUES ('25', '24', '[0],[24],', '开发部', '', '2', null, null, null, null);
INSERT INTO `dept` VALUES ('26', '24', '[0],[24],', '运营部', '', '3', null, null, null, null);
INSERT INTO `dept` VALUES ('27', '24', '[0],[24],', '战略部', '', '4', null, null, null, null);

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `pids` varchar(512) DEFAULT '' COMMENT '父级ids',
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `icon` varchar(255) DEFAULT NULL COMMENT '描述',
  `href` varchar(255) DEFAULT NULL COMMENT '描述',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT NULL COMMENT '排序',
  `opened` int(11) DEFAULT NULL COMMENT '排序',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否为菜单 0：不是 1：是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('28', '0', '0', null, '系统管理', null, null, null, '1', '1', '0', '0', '1', '2020-07-07 09:15:54', null, null, null);
INSERT INTO `permission` VALUES ('29', '28', '28,', null, '部门管理', null, null, null, '1', '2', '0', '0', '1', '2020-07-07 17:17:24', null, null, null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `pids` varchar(512) DEFAULT '' COMMENT '父级ids',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('28', '0', '[0]', '管理员', null, '1', '2020-07-07 09:00:03', null, '0', '0', 'admin');
INSERT INTO `role` VALUES ('29', '0', '', '客服', null, '2', null, null, null, null, null);

-- ----------------------------
-- Table structure for `role_permission_tr`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_tr`;
CREATE TABLE `role_permission_tr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `permission_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role_permission_tr
-- ----------------------------
INSERT INTO `role_permission_tr` VALUES ('24', '28', '28');
INSERT INTO `role_permission_tr` VALUES ('28', '28', '29');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `deptId` bigint(20) NOT NULL COMMENT '主键id',
  `username` varchar(512) DEFAULT '' COMMENT '父级ids',
  `password` varchar(512) DEFAULT '' COMMENT '父级ids',
  `salt` varchar(512) DEFAULT '' COMMENT '父级ids',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `email` varchar(45) DEFAULT NULL COMMENT '简称',
  `phone` varchar(45) DEFAULT NULL COMMENT '简称',
  `birthday` datetime DEFAULT NULL COMMENT '简称',
  `sex` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  `roleId` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24', '24', 'admin', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '总公司', null, null, null, '1', null, null, null, null, null, '28');
