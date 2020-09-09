/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2020-09-09 14:15:12
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('24', '0', '[0]', '总公司', '', '1', null, null, null, null);
INSERT INTO `dept` VALUES ('25', '24', '[0],[24]', '开发部', '', '2', null, null, null, null);
INSERT INTO `dept` VALUES ('26', '24', '[0],[24]', '运营部', '', '3', null, null, null, null);
INSERT INTO `dept` VALUES ('27', '24', '[0],[24]', '战略部', '', '4', null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('28', '0', '[0]', 'sys', '系统管理', null, null, null, '1', '1', '0', '0', '1', '2020-07-07 09:15:54', null, null, null);
INSERT INTO `permission` VALUES ('29', '28', '[0],[28]', 'dept', '机构管理', null, '/dept/index', null, '1', '2', '0', '0', '1', '2020-07-07 17:17:24', null, null, null);
INSERT INTO `permission` VALUES ('30', '28', '[0],[28]', 'role', '角色管理', null, '/role/index', null, '1', '2', '0', '0', '1', '2020-09-07 17:11:46', null, null, null);
INSERT INTO `permission` VALUES ('31', '0', '[0]', 'order', '订单管理', null, null, null, '1', '1', '0', '0', '1', '2020-09-08 15:08:01', null, null, null);
INSERT INTO `permission` VALUES ('32', '31', '[31]', 'order_tb', '淘宝订单管理', null, null, null, null, null, null, null, '0', null, null, null, null);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('28', '0', '[0]', '超级管理员', '超级管理员', '1', '2020-07-07 09:00:03', null, '0', '0', 'admin');
INSERT INTO `role` VALUES ('29', '0', '[0]', '普通管理员', '普通管理员', '2', null, null, null, null, 'manager');
INSERT INTO `role` VALUES ('35', '0', '', '游客', '游客', '0', '2020-09-08 16:48:57', '2020-09-08 16:48:57', '24', '24', 'guest');

-- ----------------------------
-- Table structure for `role_permission_tr`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_tr`;
CREATE TABLE `role_permission_tr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT '0' COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of role_permission_tr
-- ----------------------------
INSERT INTO `role_permission_tr` VALUES ('64', '28', '28');
INSERT INTO `role_permission_tr` VALUES ('65', '28', '29');
INSERT INTO `role_permission_tr` VALUES ('66', '28', '30');
INSERT INTO `role_permission_tr` VALUES ('67', '28', '31');
INSERT INTO `role_permission_tr` VALUES ('68', '28', '32');

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24', '24', 'admin', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '超级管理员', '13857652373@163.com', '13857652373', '2020-08-29 09:16:59', '1', '1', '2020-08-29 09:17:03', '2020-08-29 09:17:06', '24', '24', '28');
INSERT INTO `user` VALUES ('25', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('30', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('31', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('32', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('33', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('34', '26', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('35', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('36', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('37', '26', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('38', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('39', '26', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('40', '26', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('41', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('42', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('43', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('44', '27', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('45', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('46', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('55', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '0', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
INSERT INTO `user` VALUES ('56', '25', 'liandy', '35375bfab839a13275e7ec9269c7eaf6', 'd8a78164feeddc7be3d1482344860a09', '连先森', '1385765823@163.com', '13857652373', '2020-09-04 13:20:30', '1', '1', '2020-09-04 13:20:33', '2020-09-04 13:20:35', '24', '24', '28');
