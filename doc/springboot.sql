/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2020-10-12 09:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父id',
  `pids` varchar(512) DEFAULT '' COMMENT '父级ids',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('24', '0', '[0]', '总公司', '', '1', null, null, null, null);
INSERT INTO `dept` VALUES ('25', '24', '[0],[24]', 'A公司', '', '2', null, null, null, null);
INSERT INTO `dept` VALUES ('26', '24', '[0],[24]', 'B公司', '', '3', null, null, null, null);
INSERT INTO `dept` VALUES ('27', '24', '[0],[24]', 'C公司', '', '4', null, null, null, null);
INSERT INTO `dept` VALUES ('32', '25', '[0],[24][25]', '开发部', '', '1', '2020-09-09 09:24:26', '2020-09-09 09:24:26', '24', '24');
INSERT INTO `dept` VALUES ('34', '25', '[0],[24][25]', '客服部', '', '2', '2020-09-09 09:29:07', '2020-09-09 09:29:07', '24', '24');
INSERT INTO `dept` VALUES ('35', '25', '[0],[24][25]', '运营部', '', '1', '2020-09-24 03:44:44', '2020-09-24 03:44:44', '24', '24');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `code` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` int(20) DEFAULT NULL COMMENT '修改人',
  `dictionary_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('24', 'A1', 'A1', '1', null, null, null, null, '24');
INSERT INTO `dictionary` VALUES ('25', 'B1', 'B1', '2', null, null, null, null, '24');
INSERT INTO `dictionary` VALUES ('26', 'C1', 'C1', '3', null, null, null, null, '24');

-- ----------------------------
-- Table structure for `dictionary_class`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_class`;
CREATE TABLE `dictionary_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `code` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of dictionary_class
-- ----------------------------
INSERT INTO `dictionary_class` VALUES ('24', 'A', '', '1', null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('25', 'B ', '', '2', null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('26', 'C', '', '3', null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('36', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('37', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('38', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('39', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('40', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('41', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('42', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('43', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('44', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('45', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('46', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('47', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('48', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('49', 'D', 'D', null, null, null, null, null);
INSERT INTO `dictionary_class` VALUES ('50', 'D', 'D', null, null, null, null, null);

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `pids` varchar(512) DEFAULT '' COMMENT '父级ids',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `icon` varchar(255) DEFAULT NULL COMMENT '描述',
  `href` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `opened` int(11) DEFAULT NULL COMMENT '排序',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否为菜单 0：不是 1：是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('28', '0', '[0]', 'sys', '系统管理', '', '', null, '1', '0', '0', '0', '0', '2020-07-07 09:15:54', '2020-09-24 08:09:05', null, '24');
INSERT INTO `permission` VALUES ('29', '28', '[0][28]', 'dept', '机构管理', '', '/dept/index', null, '1', '0', '0', '0', '0', '2020-07-07 17:17:24', '2020-09-24 08:09:13', null, '24');
INSERT INTO `permission` VALUES ('30', '28', '[0][28]', 'role', '角色管理', '1', '/role/index', null, '1', '0', '0', '0', '0', '2020-09-07 17:11:46', '2020-09-24 08:12:46', null, '24');
INSERT INTO `permission` VALUES ('31', '0', '[0]', 'order', '订单管理', '', '', null, '1', '0', '0', '0', '0', '2020-09-08 15:08:01', '2020-09-28 05:24:01', null, '24');
INSERT INTO `permission` VALUES ('32', '31', '[31]', 'order_tb', '淘宝订单管理', null, null, null, null, null, null, null, '0', null, null, null, null);
INSERT INTO `permission` VALUES ('40', '28', '[0][28]', 'permission', '权限管理', '1', '/permission/index', null, '1', '0', '0', '0', '0', '2020-09-24 07:54:52', '2020-09-24 07:54:52', '24', '24');
INSERT INTO `permission` VALUES ('47', '30', '[0][28][30]', 'role_add', '添加', '1', '/role/add', null, '1', '0', '0', '0', '1', '2020-09-24 08:34:42', '2020-09-28 05:23:27', '24', '24');
INSERT INTO `permission` VALUES ('48', '30', '[0][28][30]', 'role_edit', '修改', '1', '/role/edit', null, '1', '0', '0', '0', '1', '2020-09-24 08:37:05', '2020-09-24 08:37:05', '24', '24');
INSERT INTO `permission` VALUES ('49', '30', '[0][28][30]', 'role_delete', '删除', '1', '/role/delete', null, '1', '0', '0', '0', '1', '2020-09-24 08:37:37', '2020-09-28 05:23:36', '24', '24');
INSERT INTO `permission` VALUES ('50', '28', '[0][28]', 'user', '用户管理', '1', '/user/index', null, '1', '0', '0', '0', '0', '2020-09-24 08:57:33', '2020-09-24 08:57:33', '24', '24');

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
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `dept_id` bigint(20) DEFAULT '0' COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '0', '[0]', '超级管理员', '超级管理员', '1', '2020-07-07 09:00:03', null, '0', '0', 'admin', '24');
INSERT INTO `role` VALUES ('29', '28', '[0],[28]', '普通管理员', '普通管理员', '2', null, null, null, null, 'manager', '25');
INSERT INTO `role` VALUES ('35', '29', '[0],[28],[29]', '经理', '经理', '0', '2020-09-08 16:48:57', '2020-09-08 16:48:57', '24', '24', 'jl', '25');
INSERT INTO `role` VALUES ('36', '35', '[0],[28],[29],[35]', '客服', '客服', null, null, null, null, null, 'kf', '25');

-- ----------------------------
-- Table structure for `role_permission_tr`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_tr`;
CREATE TABLE `role_permission_tr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT '0' COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role_permission_tr
-- ----------------------------
INSERT INTO `role_permission_tr` VALUES ('89', '36', '28');
INSERT INTO `role_permission_tr` VALUES ('90', '36', '30');
INSERT INTO `role_permission_tr` VALUES ('91', '36', '33');
INSERT INTO `role_permission_tr` VALUES ('213', '1', '28');
INSERT INTO `role_permission_tr` VALUES ('214', '1', '29');
INSERT INTO `role_permission_tr` VALUES ('215', '1', '30');
INSERT INTO `role_permission_tr` VALUES ('216', '1', '47');
INSERT INTO `role_permission_tr` VALUES ('217', '1', '48');
INSERT INTO `role_permission_tr` VALUES ('218', '1', '49');
INSERT INTO `role_permission_tr` VALUES ('219', '1', '40');
INSERT INTO `role_permission_tr` VALUES ('220', '1', '50');
INSERT INTO `role_permission_tr` VALUES ('221', '1', '31');
INSERT INTO `role_permission_tr` VALUES ('222', '1', '32');
INSERT INTO `role_permission_tr` VALUES ('235', '35', '31');
INSERT INTO `role_permission_tr` VALUES ('236', '35', '32');
INSERT INTO `role_permission_tr` VALUES ('237', '29', '28');
INSERT INTO `role_permission_tr` VALUES ('238', '29', '50');
INSERT INTO `role_permission_tr` VALUES ('239', '29', '31');
INSERT INTO `role_permission_tr` VALUES ('240', '29', '32');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  `username` varchar(512) DEFAULT '' COMMENT '用户名',
  `password` varchar(512) DEFAULT '' COMMENT '密码',
  `salt` varchar(512) DEFAULT '' COMMENT '撒盐',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系方式',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24', '24', 'admin', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '超级管理员', '13857652373@163.com', '13857652373', '2020-08-29 09:16:59', '1', '1', '2020-08-29 09:17:03', '2020-08-29 09:17:06', '24', '24', '1');
INSERT INTO `user` VALUES ('25', '25', 'gly', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '管理员', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '29');
INSERT INTO `user` VALUES ('65', '25', 'jl', '6352028e29867bd9a7d4161deb5c179c', '714d404d5fdaa3c5e891c6b50178a9a7', '经理', null, null, null, '1', '0', '2020-09-14 07:18:36', '2020-09-14 07:18:36', '24', '24', '35');
