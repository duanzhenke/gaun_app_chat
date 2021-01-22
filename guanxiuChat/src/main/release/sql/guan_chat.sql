/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.117_eo_dev
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.0.117:23306
 Source Schema         : potato_engineoil

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 22/01/2021 09:52:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guan_chat
-- ----------------------------
DROP TABLE IF EXISTS `guan_chat`;
CREATE TABLE `guan_chat`  (
  `id` float NOT NULL AUTO_INCREMENT,
  `user_name` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `user_high` double NULL DEFAULT NULL,
  `education` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `marital_status` tinyint(4) NULL DEFAULT NULL,
  `monthly_income` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` char(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pass_word` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
