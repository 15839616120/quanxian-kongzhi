/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.27-log : Database - yingxiao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yingxiao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `yingxiao`;

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) DEFAULT NULL COMMENT '父菜单id',
  `permission_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(100) DEFAULT '' COMMENT '资源路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`pid`,`permission_name`,`url`) values 
(1,0,'用户管理',''),
(2,0,'内容管理',''),
(3,0,'订单管理',''),
(4,0,'客服中心',''),
(5,0,'审核管理',''),
(6,0,'数据统计',''),
(7,0,'财务管理',''),
(8,0,'CMS网站管理',''),
(9,0,'系统管理',''),
(10,1,'用户列表','/user/list'),
(11,1,'用户邀请关系','/user/inviterelation'),
(12,2,'模板管理','/contentadmin/template'),
(13,2,'作品管理','/contentadmin/work'),
(14,3,'平台订单','/orderadmin/platform'),
(15,3,'用户订单','/orderadmin/userorder'),
(16,4,'举报中心','/callcenter/reportcenter'),
(17,4,'邀请函提交表单','/callcenter/invitationSubForm'),
(18,5,'模板审核','/auditadmin/templateAudit'),
(19,5,'作品审核','/auditadmin/workAudit'),
(20,5,'个人认证','/auditadmin/personAttestation'),
(21,5,'企业认证','/auditadmin/companyAttestation'),
(22,6,'整体概览','/dataStatistics/comment'),
(23,6,'实时统计','/dataStatistics/customer'),
(24,7,'财务概述','/financeadmin/finance'),
(25,8,'模板轮播图','/cms/swiper'),
(26,8,'模板分类icon','/cms/classIcon'),
(27,8,'模板广告banner','/cms/adBanner'),
(28,8,'热门模板设置','/cms/hotTemplate'),
(29,8,'热门搜索词管理','/cms/hotSearch'),
(30,8,'品牌管理','/cms/brand'),
(31,8,'标签管理','/cms/label'),
(32,8,'行业分类管理','/cms/industry'),
(33,9,'系统账号管理','/systemadmin/ayetem'),
(34,9,'修改密码','/systemadmin/syste');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`role_desc`) values 
(1,'ROLE_SUPER','超级管理员'),
(2,'ROLE_USER','用户管理'),
(3,'ROLE_CONTENT','内容管理'),
(4,'ROLE_ORDER','订单管理'),
(5,'ROLE_CUSTOMER','客服中心'),
(6,'ROLE_EXAMINE','审核管理'),
(7,'ROLE_STATISTICS','数据统计'),
(8,'ROLE_FINANCE','财务管理'),
(9,'ROLE_CMS','cms网站管理'),
(10,'ROLE_SYSTEM','系统管理');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`permission_id`,`role_id`) values 
(1,1),
(1,2),
(2,1),
(2,3),
(3,1),
(3,4),
(4,1),
(4,5),
(5,1),
(5,6),
(6,1),
(6,7),
(7,1),
(7,8),
(8,1),
(8,9),
(9,1),
(9,10),
(10,1),
(10,2),
(11,1),
(11,2),
(12,1),
(12,3),
(13,1),
(13,3),
(14,1),
(14,4),
(15,1),
(15,4),
(16,1),
(16,5),
(17,1),
(17,5),
(18,1),
(18,6),
(19,1),
(19,6),
(20,1),
(20,6),
(21,1),
(21,6),
(22,1),
(22,7),
(23,1),
(23,7),
(24,1),
(24,8),
(25,1),
(25,9),
(26,1),
(26,9),
(27,1),
(27,9),
(28,1),
(28,9),
(29,1),
(29,9),
(30,1),
(30,9),
(31,1),
(31,9),
(32,1),
(32,9),
(33,1),
(33,10),
(34,1),
(34,10);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) DEFAULT NULL COMMENT '系统账号-手机号码',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `status` int(11) DEFAULT NULL COMMENT '账号状态 0正常;1禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique` (`username`),
  KEY `username_idx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`phone`,`username`,`password`,`status`,`create_time`) values 
(1,'13283705681','前子','e10adc3949ba59abbe56e057f20f883e',0,'2019-11-09 16:49:56'),
(5,'15712058302','爱谁谁','e10adc3949ba59abbe56e057f20f883e',0,'2019-11-11 10:35:32'),
(11,'13283705683','cms网站管理','e10adc3949ba59abbe56e057f20f883e',0,'2019-11-12 18:57:25');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values 
(1,1),
(5,10),
(11,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
