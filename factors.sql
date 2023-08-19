/*
 Navicat Premium Data Transfer

 Source Server         : erpplussd
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : factors

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 19/08/2023 13:51:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bp_relationship
-- ----------------------------
DROP TABLE IF EXISTS `bp_relationship`;
CREATE TABLE `bp_relationship`  (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `relationship_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `search_term` int NULL DEFAULT NULL,
  `valid_from` date NULL DEFAULT NULL,
  `valid_to` date NULL DEFAULT NULL,
  `vip` int NULL DEFAULT NULL,
  `department` int NULL DEFAULT NULL,
  `function` int NULL DEFAULT NULL,
  `customer_id` int NULL DEFAULT NULL,
  `contact_person_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`relationship_id`) USING BTREE,
  INDEX `cu_re`(`customer_id` ASC) USING BTREE,
  INDEX `cp_re`(`contact_person_id` ASC) USING BTREE,
  CONSTRAINT `cp_re` FOREIGN KEY (`contact_person_id`) REFERENCES `contact_person` (`contact_person_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cu_re` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bp_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for bprelationship
-- ----------------------------
DROP TABLE IF EXISTS `bprelationship`;
CREATE TABLE `bprelationship`  (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `relationship_ategory` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `search_term` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `business_partner1` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `business_partner2` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `valid_from` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `valid_to` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `VIP` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `Department` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `functions` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`relationship_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bprelationship
-- ----------------------------
INSERT INTO `bprelationship` VALUES (2, 'BUR001', '9999', '3', '2', 'dsad', 'dsd', 'dad', 'dsad', '12321321', NULL);
INSERT INTO `bprelationship` VALUES (6, 'BUR001', '1', '', '', '1', '1', '1', '1', '1', NULL);
INSERT INTO `bprelationship` VALUES (7, 'BUR001', '1', '7', '2', '1', '1', '1', '1', '1', NULL);
INSERT INTO `bprelationship` VALUES (8, 'BUR001', '2', '6', '2', '2', '1', '3123', '12312', '3123123', NULL);

-- ----------------------------
-- Table structure for business_partner
-- ----------------------------
DROP TABLE IF EXISTS `business_partner`;
CREATE TABLE `business_partner`  (
  `bp_id` int NOT NULL AUTO_INCREMENT,
  `search_term` int NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `customer_id` int NULL DEFAULT NULL,
  `contact_person_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`bp_id`) USING BTREE,
  INDEX `cu_bp`(`customer_id` ASC) USING BTREE,
  INDEX `cp_bp`(`contact_person_id` ASC) USING BTREE,
  CONSTRAINT `cp_bp` FOREIGN KEY (`contact_person_id`) REFERENCES `contact_person` (`contact_person_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cu_bp` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of business_partner
-- ----------------------------

-- ----------------------------
-- Table structure for businesspartner
-- ----------------------------
DROP TABLE IF EXISTS `businesspartner`;
CREATE TABLE `businesspartner`  (
  `business_partner_number` int NOT NULL AUTO_INCREMENT,
  `search_term` int NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`business_partner_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of businesspartner
-- ----------------------------

-- ----------------------------
-- Table structure for contact_person
-- ----------------------------
DROP TABLE IF EXISTS `contact_person`;
CREATE TABLE `contact_person`  (
  `contact_person_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `correspondance_lang` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `bp_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`contact_person_id`) USING BTREE,
  INDEX `bp_cp`(`bp_id` ASC) USING BTREE,
  CONSTRAINT `bp_cp` FOREIGN KEY (`bp_id`) REFERENCES `business_partner` (`bp_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contact_person
-- ----------------------------

-- ----------------------------
-- Table structure for contactperson
-- ----------------------------
DROP TABLE IF EXISTS `contactperson`;
CREATE TABLE `contactperson`  (
  `contact_person_number` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `correspondance_lang` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`contact_person_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contactperson
-- ----------------------------
INSERT INTO `contactperson` VALUES (2, '123', '999999', '3123123', '2132132', '321312');
INSERT INTO `contactperson` VALUES (3, 'a', 'aa', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `postal_code` int NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `reconciliation_acct` int UNSIGNED NULL DEFAULT NULL,
  `sort_key` int NULL DEFAULT NULL,
  `payment_terms` int NULL DEFAULT NULL,
  `sales_org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `division` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_district` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `price_group` int NULL DEFAULT NULL,
  `customer_stats_group` int NULL DEFAULT NULL,
  `delivery_priority` int NULL DEFAULT NULL,
  `shipping_conditions` int NULL DEFAULT NULL,
  `delivering_plant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `max_part_deliviries` int NULL DEFAULT NULL,
  `incoterms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `incoterms_loctaion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `acct_assmt_grp_cust` int NULL DEFAULT NULL,
  `tax_classific` int NULL DEFAULT NULL,
  `bp_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE,
  INDEX `bp_cu`(`bp_id` ASC) USING BTREE,
  CONSTRAINT `bp_cu` FOREIGN KEY (`bp_id`) REFERENCES `business_partner` (`bp_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, NULL, 'Success', 659877, 'SH', 'CH', NULL, NULL, NULL, NULL, 'CS', 'WH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (2, NULL, 'Bikee', 659823, 'SH', 'CH', NULL, NULL, NULL, NULL, 'CS', 'WH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (3, NULL, 'Ali', 659898, 'SH', 'CH', NULL, NULL, NULL, NULL, 'CS', 'IN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (4, NULL, 'Company1', 695833, 'SH', 'CH', NULL, NULL, NULL, NULL, 'CS', 'IN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (5, NULL, 'Company2', 695821, 'BJ', 'CH', NULL, NULL, NULL, NULL, 'CN', 'WH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (6, NULL, 'Company3', 695800, 'BJ', 'CH', NULL, NULL, NULL, NULL, 'CN', 'WH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (7, NULL, 'Company4', 659824, 'BJ', 'CH', NULL, NULL, NULL, NULL, 'CN', 'IN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customer` VALUES (8, NULL, 'Company5', 695811, 'SZ', 'CH', NULL, NULL, NULL, NULL, 'CS', 'WH', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`  (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sales_district` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `customer_stats_group` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `postal_code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `reconciliation_acct` int NULL DEFAULT NULL,
  `sort_key` int NULL DEFAULT NULL,
  `payment_terms` int NULL DEFAULT NULL,
  `sales_org` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `division` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price_group` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `delivery_priority` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `shipping_conditions` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `delivering_plant` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `max_part_deliviries` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `incoterms` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `incoterms_location` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `acct_assmt_grp_cust` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tax_classific` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `bp_id` int NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `incoterms_loctaion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES (3, '99999999999', '323', 'das', 'sdsa', '12321', 'da', 'wqdad', 'dasda', 132, 312, 31, '', '', 'dasd', 'das', 'asd', 'dasd', 'sds', 'dasd', 'dasd', 'sdsd', 'sdsad', 'asd', NULL, NULL, NULL);
INSERT INTO `customers` VALUES (6, NULL, 'Company3', '', 'BJ', '695800', NULL, 'CH', NULL, NULL, NULL, NULL, 'CN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (7, NULL, 'Company4', '', 'BJ', '659824', NULL, 'CH', NULL, NULL, NULL, NULL, 'CN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (66, NULL, 'Success', '', 'SH', '659877', NULL, 'CH', NULL, NULL, NULL, NULL, 'CS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (67, NULL, 'Bikee', '', 'SH', '659823', NULL, 'CH', NULL, NULL, NULL, NULL, 'CS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (68, NULL, 'Ali', '', 'SH', '659898', NULL, 'CH', NULL, NULL, NULL, NULL, 'CS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (69, NULL, 'Company1', '', 'SH', '695833', NULL, 'CH', NULL, NULL, NULL, NULL, 'CS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (70, NULL, 'Company2', '', 'BJ', '695821', NULL, 'CH', NULL, NULL, NULL, NULL, 'CN', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `customers` VALUES (71, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (72, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (73, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (74, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (75, '211', '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (76, '123', 'asdasdasd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `customers` VALUES (77, 'a', 'aa', 'asdasd', 'asd', 'aa', 'aa', 'JPN', 'a', 11, 11, 1, 'UE00', '', 'USD', 'asd', 'asd', 'asd', 'dasd', 'adasd', 'ad', NULL, 'asd', 'ads', 0, NULL, NULL);

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `delivery_id` int NOT NULL AUTO_INCREMENT,
  `ship_to_party` int NULL DEFAULT NULL,
  `priority` int NULL DEFAULT NULL,
  `picking_status` tinyint(1) NULL DEFAULT NULL,
  `net_weight` double NULL DEFAULT NULL,
  `gross_weight` double NULL DEFAULT NULL,
  `delivery_date` date NULL DEFAULT NULL,
  `planned_gi_date` date NULL DEFAULT NULL,
  `picking_date` date NULL DEFAULT NULL,
  `gi_status` tinyint(1) NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`delivery_id`) USING BTREE,
  INDEX `or_deli`(`order_id` ASC) USING BTREE,
  CONSTRAINT `or_deli` FOREIGN KEY (`order_id`) REFERENCES `sales_order` (`order_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES (1, 1, NULL, NULL, NULL, NULL, '2023-08-18', NULL, NULL, NULL, 300001);
INSERT INTO `delivery` VALUES (2, 2, NULL, 1, 28.5, 30, '2023-08-18', '2023-08-18', '2023-08-18', 1, NULL);

-- ----------------------------
-- Table structure for delivery_item
-- ----------------------------
DROP TABLE IF EXISTS `delivery_item`;
CREATE TABLE `delivery_item`  (
  `delivery_item_id` int NOT NULL AUTO_INCREMENT,
  `picking_status` tinyint(1) NULL DEFAULT NULL,
  `picking_quatity` int NULL DEFAULT NULL,
  `original_delivery_quantity` int NULL DEFAULT NULL,
  `plant_id` int NULL DEFAULT NULL,
  `material_id` int NULL DEFAULT NULL,
  `delivery_id` int NULL DEFAULT NULL,
  `picking_quantity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`delivery_item_id`) USING BTREE,
  INDEX `ma_deli_it`(`material_id` ASC) USING BTREE,
  INDEX `deli_deli_it`(`delivery_id` ASC) USING BTREE,
  CONSTRAINT `deli_deli_it` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ma_deli_it` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of delivery_item
-- ----------------------------
INSERT INTO `delivery_item` VALUES (1, 1, NULL, 80, 2, 2, 1, '2');
INSERT INTO `delivery_item` VALUES (2, 1, NULL, 20, 22, 1, 1, '22');
INSERT INTO `delivery_item` VALUES (3, 1, NULL, 40, 3, 3, 1, '3');
INSERT INTO `delivery_item` VALUES (4, 1, NULL, 50, 2, 1, 2, '3');

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details`  (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NULL DEFAULT NULL,
  `expected_probability` int NULL DEFAULT NULL,
  `net_value` double NULL DEFAULT NULL,
  `inquiry_id` int NULL DEFAULT NULL,
  `quotation_id` int NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  `discount_id` int NULL DEFAULT NULL,
  `material_id` int NULL DEFAULT NULL,
  `batch` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `in_de`(`inquiry_id` ASC) USING BTREE,
  INDEX `qu_de`(`quotation_id` ASC) USING BTREE,
  INDEX `or_de`(`order_id` ASC) USING BTREE,
  INDEX `dr_de`(`discount_id` ASC) USING BTREE,
  INDEX `ma_de`(`material_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES (94, 3, 0, 237, 0, 0, 8, NULL, 2, '1692413949');
INSERT INTO `details` VALUES (95, 3, 0, 219, 0, 16, 0, NULL, 3, '1692415198');
INSERT INTO `details` VALUES (96, 6, 80, 420, 100002, 0, 0, NULL, 1, '1692415529');
INSERT INTO `details` VALUES (97, 2, 0, 200, 100002, 0, 0, NULL, 4, '1692415529');
INSERT INTO `details` VALUES (98, 6, 80, 351, 0, 200002, 0, NULL, 1, '1692415529');
INSERT INTO `details` VALUES (99, 2, 0, 180, 0, 200002, 0, NULL, 4, '1692415529');
INSERT INTO `details` VALUES (100, 6, 80, 351, 0, 0, 300002, NULL, 1, '0');
INSERT INTO `details` VALUES (101, 2, 0, 180, 0, 0, 300002, NULL, 4, '0');
INSERT INTO `details` VALUES (102, 4, 70, 320, 100003, 0, 0, NULL, 2, '1692418227');
INSERT INTO `details` VALUES (103, 2, 0, 210, 100003, 0, 0, NULL, 5, '1692418227');
INSERT INTO `details` VALUES (104, 4, 70, 249.60000000000002, 0, 200003, 0, NULL, 2, '1692418227');
INSERT INTO `details` VALUES (105, 2, 0, 160, 0, 200003, 0, NULL, 5, '1692418227');
INSERT INTO `details` VALUES (106, 4, 70, 249.60000000000002, 0, 0, 300003, NULL, 2, '0');
INSERT INTO `details` VALUES (107, 2, 0, 160, 0, 0, 300003, NULL, 5, '0');
INSERT INTO `details` VALUES (108, 2, 0, 158, 0, 0, 300004, NULL, 2, '1692418473');

-- ----------------------------
-- Table structure for discount_rules
-- ----------------------------
DROP TABLE IF EXISTS `discount_rules`;
CREATE TABLE `discount_rules`  (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `discount_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `num` double NULL DEFAULT NULL,
  `detail_id` int NULL DEFAULT NULL,
  `discount_all` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`discount_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discount_rules
-- ----------------------------
INSERT INTO `discount_rules` VALUES (1, '1', 1, 39, '0.0');
INSERT INTO `discount_rules` VALUES (2, '2', 22, 39, '0.0');
INSERT INTO `discount_rules` VALUES (3, 'K004', 10, 53, '20.0');
INSERT INTO `discount_rules` VALUES (4, 'RA00', 334, 53, '-304.2');
INSERT INTO `discount_rules` VALUES (5, '2', 2, 69, '0.0');
INSERT INTO `discount_rules` VALUES (6, '2', 2, 75, '0.0');
INSERT INTO `discount_rules` VALUES (7, 'K004', 10, 83, '20.0');
INSERT INTO `discount_rules` VALUES (8, 'RA00', 334, 83, '-304.2');
INSERT INTO `discount_rules` VALUES (9, '2', 2, 84, '0.0');
INSERT INTO `discount_rules` VALUES (10, 'K004', 10, 86, '20.0');
INSERT INTO `discount_rules` VALUES (11, 'RA00', 334, 86, '-304.2');
INSERT INTO `discount_rules` VALUES (12, 'K004', 1, 94, '3.0');
INSERT INTO `discount_rules` VALUES (13, 'K004', 2, 95, '6.0');
INSERT INTO `discount_rules` VALUES (14, 'K004', 5, 98, '30.0');
INSERT INTO `discount_rules` VALUES (15, 'RA00', 90, 98, '39.0');
INSERT INTO `discount_rules` VALUES (16, 'RA00', 90, 99, '20.0');
INSERT INTO `discount_rules` VALUES (17, 'K004', 5, 100, '30.0');
INSERT INTO `discount_rules` VALUES (18, 'RA00', 90, 100, '39.0');
INSERT INTO `discount_rules` VALUES (19, 'RA00', 90, 101, '20.0');
INSERT INTO `discount_rules` VALUES (20, 'K004', 2, 104, '8.0');
INSERT INTO `discount_rules` VALUES (21, 'K004', 5, 105, '10.0');
INSERT INTO `discount_rules` VALUES (22, 'RA00', 80, 104, '62.4');
INSERT INTO `discount_rules` VALUES (23, 'RA00', 80, 105, '40.0');
INSERT INTO `discount_rules` VALUES (24, 'K004', 2, 106, '8.0');
INSERT INTO `discount_rules` VALUES (25, 'RA00', 80, 106, '62.4');
INSERT INTO `discount_rules` VALUES (26, 'K004', 5, 107, '10.0');
INSERT INTO `discount_rules` VALUES (27, 'RA00', 80, 107, '40.0');
INSERT INTO `discount_rules` VALUES (28, 'K004', 1, 108, '2.0');

-- ----------------------------
-- Table structure for inquiry
-- ----------------------------
DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE `inquiry`  (
  `inquiry_id` int NOT NULL AUTO_INCREMENT,
  `ship_to_party` int NULL DEFAULT NULL,
  `sold_to_party` int NULL DEFAULT NULL,
  `valid_from` date NULL DEFAULT NULL,
  `valid_to` date NULL DEFAULT NULL,
  `req_deliv_date` date NULL DEFAULT NULL,
  `net_value` double NULL DEFAULT NULL,
  `expect_ord_val` double NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_office` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `division` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `customer_reference` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`inquiry_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inquiry
-- ----------------------------
INSERT INTO `inquiry` VALUES (100001, 3366900, 565677, '2023-08-01', '2023-08-16', '2023-08-17', 150, 0, '1', '2', '2', '2', '2', '2', '0');
INSERT INTO `inquiry` VALUES (100002, 68, 68, '2023-08-15', '2023-08-30', '2023-08-01', 620, 336, NULL, NULL, NULL, NULL, NULL, NULL, '188');
INSERT INTO `inquiry` VALUES (100003, 68, 68, '2023-08-08', '2023-08-23', '2023-08-21', 530, 224, NULL, NULL, NULL, NULL, NULL, NULL, '192');

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `billing_date` date NULL DEFAULT NULL,
  `ship_to_party` int NULL DEFAULT NULL,
  `sold_to_party` int NULL DEFAULT NULL,
  `net_value` double NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`) USING BTREE,
  INDEX `or_in`(`order_id` ASC) USING BTREE,
  CONSTRAINT `or_in` FOREIGN KEY (`order_id`) REFERENCES `sales_order` (`order_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES (12, 'Success', '2023-08-14', 2, 2, 380, 'CNY', NULL);
INSERT INTO `invoice` VALUES (13, 'Bikee', '2023-08-15', 2, 2, 380, 'USD', NULL);
INSERT INTO `invoice` VALUES (14, 'Success', '2023-08-15', 1, 1, 250, 'CNY', 300001);

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `net_weight` double NULL DEFAULT NULL,
  `gross_weight` double NULL DEFAULT NULL,
  PRIMARY KEY (`material_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, 'Material1', 70, 9.5, 10);
INSERT INTO `material` VALUES (2, 'Material2', 80, 7, 8);
INSERT INTO `material` VALUES (3, 'Material3', 75, 8, 8.5);
INSERT INTO `material` VALUES (4, 'Material4', 100, 12, 11);
INSERT INTO `material` VALUES (5, 'Material5', 105, 11.5, 12.5);
INSERT INTO `material` VALUES (6, 'Material6', 120, 13, 11);

-- ----------------------------
-- Table structure for plant
-- ----------------------------
DROP TABLE IF EXISTS `plant`;
CREATE TABLE `plant`  (
  `plant_id` int NOT NULL AUTO_INCREMENT,
  `storage_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`plant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of plant
-- ----------------------------
INSERT INTO `plant` VALUES (1, 'SH');
INSERT INTO `plant` VALUES (2, 'BJ');
INSERT INTO `plant` VALUES (3, 'SZ');

-- ----------------------------
-- Table structure for quotation
-- ----------------------------
DROP TABLE IF EXISTS `quotation`;
CREATE TABLE `quotation`  (
  `quotation_id` int NOT NULL AUTO_INCREMENT,
  `ship_to_party` int NULL DEFAULT NULL,
  `sold_to_party` int NULL DEFAULT NULL,
  `valid_from` date NULL DEFAULT NULL,
  `valid_to` date NULL DEFAULT NULL,
  `req_deliv_date` date NULL DEFAULT NULL,
  `net_value` double NULL DEFAULT NULL,
  `expect_ord_val` double NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `inquiry_id` int NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  `sales_office` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `division` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `customer_reference` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `detail_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`quotation_id`) USING BTREE,
  INDEX `in_qu`(`inquiry_id` ASC) USING BTREE,
  INDEX `or_qu`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of quotation
-- ----------------------------
INSERT INTO `quotation` VALUES (200002, 68, 68, '2023-08-15', '2023-08-30', '2023-08-01', 531, 280.8, NULL, 100002, 0, NULL, NULL, NULL, NULL, NULL, '188', NULL);
INSERT INTO `quotation` VALUES (200003, 68, 68, '2023-08-08', '2023-08-23', '2023-08-21', 409.6, 174.72, NULL, 100003, 0, NULL, NULL, NULL, NULL, NULL, '192', NULL);

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt`  (
  `receipt_id` int NOT NULL AUTO_INCREMENT,
  `account` int NULL DEFAULT NULL,
  `amount_received` double NULL DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `payment_date` date NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`receipt_id`) USING BTREE,
  INDEX `or_re`(`order_id` ASC) USING BTREE,
  CONSTRAINT `or_re` FOREIGN KEY (`order_id`) REFERENCES `sales_order` (`order_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of receipt
-- ----------------------------

-- ----------------------------
-- Table structure for rule_description
-- ----------------------------
DROP TABLE IF EXISTS `rule_description`;
CREATE TABLE `rule_description`  (
  `ruledescription_id` int NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rule_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ruledescription_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rule_description
-- ----------------------------
INSERT INTO `rule_description` VALUES (1, 'JR4', 'Tax Jur Code Level 4');
INSERT INTO `rule_description` VALUES (2, 'K004', 'Material');
INSERT INTO `rule_description` VALUES (3, 'K005', 'Customer/Material');
INSERT INTO `rule_description` VALUES (4, 'K007', 'Customer Discount');
INSERT INTO `rule_description` VALUES (5, 'K020', 'Price Group');
INSERT INTO `rule_description` VALUES (6, 'K029', 'Material pricing grp');
INSERT INTO `rule_description` VALUES (7, 'K030', 'Customer/Mat.Pr.Grp');
INSERT INTO `rule_description` VALUES (8, 'K031', 'Price Grp/Mat.Pr.Grp');
INSERT INTO `rule_description` VALUES (9, 'K032', 'Price Group/Material');
INSERT INTO `rule_description` VALUES (10, 'KA00', 'Sales deal');
INSERT INTO `rule_description` VALUES (11, 'KF00', 'Freight');
INSERT INTO `rule_description` VALUES (12, 'KP00', 'Pallet Discount');
INSERT INTO `rule_description` VALUES (13, 'Pallet Discount', 'Incomp.Pallet Surch.');
INSERT INTO `rule_description` VALUES (14, 'KP02', 'Mixed Pallet Disc.');
INSERT INTO `rule_description` VALUES (15, 'KP03', 'Mixed Pallet Surch.');
INSERT INTO `rule_description` VALUES (16, 'PB00', 'Price (Gross)');
INSERT INTO `rule_description` VALUES (17, 'PI01', 'Inter-company Price');
INSERT INTO `rule_description` VALUES (18, 'PI02', 'Inter-company %');
INSERT INTO `rule_description` VALUES (19, 'PMIN', 'Minimum Price');
INSERT INTO `rule_description` VALUES (20, 'PI01', 'Inter-company Price');
INSERT INTO `rule_description` VALUES (21, 'PI02', 'Inter-company %');
INSERT INTO `rule_description` VALUES (22, 'PMIN', 'Minimum Price');
INSERT INTO `rule_description` VALUES (23, 'PN00', 'Price (net)');
INSERT INTO `rule_description` VALUES (24, 'PR00', 'Price');
INSERT INTO `rule_description` VALUES (25, 'RA00', '% Discount from Net');
INSERT INTO `rule_description` VALUES (26, 'RA01', '% Disc.from Gross');
INSERT INTO `rule_description` VALUES (27, 'RB00', 'Discount (Value)');
INSERT INTO `rule_description` VALUES (28, 'RC00', 'Quantity Discount');
INSERT INTO `rule_description` VALUES (29, 'RD00', 'Weight Discount');

-- ----------------------------
-- Table structure for sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sales_order`;
CREATE TABLE `sales_order`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `ship_to_party` int NULL DEFAULT NULL,
  `sold_to_party` int NULL DEFAULT NULL,
  `valid_from` date NULL DEFAULT NULL,
  `valid_to` date NULL DEFAULT NULL,
  `req_deliv_date` date NULL DEFAULT NULL,
  `net_value` double NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `quotation_id` int NULL DEFAULT NULL,
  `invoice_id` int NULL DEFAULT NULL,
  `receipt_id` int NULL DEFAULT NULL,
  `sales_office` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `distr_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sales_org` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `division` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `customer_reference` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `qu_or`(`quotation_id` ASC) USING BTREE,
  INDEX `in_or`(`invoice_id` ASC) USING BTREE,
  INDEX `re_or`(`receipt_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 300005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sales_order
-- ----------------------------
INSERT INTO `sales_order` VALUES (8, 0, 12345, NULL, NULL, '2023-08-28', 237, NULL, 0, 0, 0, NULL, NULL, 'OL', 'US00', NULL, '0', NULL);
INSERT INTO `sales_order` VALUES (300001, 1, 1, '2023-07-12', '2023-07-14', '2023-07-20', 250, 'CNY', NULL, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sales_order` VALUES (300002, 68, 68, NULL, NULL, '2023-08-01', 531, NULL, 200002, 0, 0, NULL, NULL, NULL, NULL, NULL, '188', NULL);
INSERT INTO `sales_order` VALUES (300003, 68, 68, NULL, NULL, '2023-08-21', 409.6, NULL, 200003, 0, 0, NULL, NULL, NULL, NULL, NULL, '192', NULL);
INSERT INTO `sales_order` VALUES (300004, 7, 69, NULL, NULL, '2023-08-27', 158, NULL, 0, 0, 0, NULL, NULL, 'OL', 'EU00', NULL, '0', NULL);

-- ----------------------------
-- Table structure for sduser
-- ----------------------------
DROP TABLE IF EXISTS `sduser`;
CREATE TABLE `sduser`  (
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sduser
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `stock_id` int NOT NULL AUTO_INCREMENT,
  `reserved_stock` int NULL DEFAULT NULL,
  `unrestricted_use_stock` int NULL DEFAULT NULL,
  `on_order_stock` int NULL DEFAULT NULL,
  `material_id` int NULL DEFAULT NULL,
  `plant_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`stock_id`) USING BTREE,
  INDEX `ma_st`(`material_id` ASC) USING BTREE,
  INDEX `pl_st`(`plant_id` ASC) USING BTREE,
  CONSTRAINT `ma_st` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pl_st` FOREIGN KEY (`plant_id`) REFERENCES `plant` (`plant_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 500, 467, 324, 1, 1);
INSERT INTO `stock` VALUES (2, 678, 257, 230, 2, 1);
INSERT INTO `stock` VALUES (3, 435, 765, 315, 3, 2);
INSERT INTO `stock` VALUES (4, 234, 453, 444, 4, 3);
INSERT INTO `stock` VALUES (5, 316, 231, 743, 3, 1);
INSERT INTO `stock` VALUES (6, 112, 109, 321, 3, 2);
INSERT INTO `stock` VALUES (7, 321, 176, 231, 1, 3);
INSERT INTO `stock` VALUES (8, 543, 743, 316, 4, 2);
INSERT INTO `stock` VALUES (9, 231, 343, 219, 5, 1);
INSERT INTO `stock` VALUES (10, 131, 353, 218, 6, 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '密码',
  `nike_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '1234', 'admin');
INSERT INTO `users` VALUES (9, '2', '2', 'def');
INSERT INTO `users` VALUES (10, 'test1', '1234', 'def');
INSERT INTO `users` VALUES (11, 'test2', '123456', 'def');
INSERT INTO `users` VALUES (12, 'test2', '123456', 'def');
INSERT INTO `users` VALUES (13, 'tt2', '123456', 'def');

SET FOREIGN_KEY_CHECKS = 1;
