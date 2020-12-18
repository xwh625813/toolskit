/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : toolskit

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/12/2020 15:28:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(2) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `is_first` int(2) NULL DEFAULT NULL COMMENT '是否为新用户；新用户可修改账号一次 0->否；1->是',
  `identity` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份码标识',
  `role` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份:1->超级用户；2->普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES (1, 'admin', '68f434217cc7914d3acf3920a2e91677', 'http://codell.oss-cn-beijing.aliyuncs.com/codell/images/20201016/c1.jpg', 'xwh@qq.com', 'admin', '许某人专用', '2019-10-06 15:53:51', '2020-12-02 14:04:22', 1, NULL, 'c6b2295b-f548-4c1b-9af0-3e27337e6ee0', NULL);

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '用户主键',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP对应的实际地址:中国|华中|湖南省|长沙市|电信',
  `user_agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
  `system` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 585 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO `ums_admin_login_log` VALUES (581, 1, '2020-12-18 13:54:57', '192.168.111.37', '内网IP|0|0|内网IP|内网IP', '', '');
INSERT INTO `ums_admin_login_log` VALUES (582, 1, '2020-12-18 15:03:48', '192.168.111.37', '内网IP|0|0|内网IP|内网IP', 'Chrome 87', 'Windows 10');
INSERT INTO `ums_admin_login_log` VALUES (583, 1, '2020-12-18 15:07:28', '192.168.111.37', '内网IP|0|0|内网IP|内网IP', 'Chrome 87', 'Windows 10');
INSERT INTO `ums_admin_login_log` VALUES (584, 1, '2020-12-18 15:14:08', '192.168.111.37', '内网IP|0|0|内网IP|内网IP', 'Chrome 87', 'Windows 10');

SET FOREIGN_KEY_CHECKS = 1;
