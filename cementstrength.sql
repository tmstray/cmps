/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.15 : Database - eqds
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eqds` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `eqds`;

/*Table structure for table `cement_lastcount` */

DROP TABLE IF EXISTS `cement_lastcount`;

CREATE TABLE `cement_lastcount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cementcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `cement_strength` */

DROP TABLE IF EXISTS `cement_strength`;

CREATE TABLE `cement_strength` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `sampleID` int(11) DEFAULT NULL COMMENT '原自动编号',
  `sampleNo` varchar(20) DEFAULT NULL COMMENT '实验编号',
  `kind` varchar(20) DEFAULT NULL COMMENT '品种',
  `sampleTime` varchar(20) DEFAULT NULL COMMENT '实验时间',
  `shapeTime` varchar(20) DEFAULT NULL COMMENT '成型时间',
  `destructTime` varchar(20) DEFAULT NULL COMMENT '破型时间',
  `duration` varchar(20) DEFAULT NULL COMMENT '期龄',
  `hour` varchar(20) DEFAULT NULL COMMENT '小时',
  `temperature` varchar(20) DEFAULT NULL COMMENT '室温',
  `experimentStand` varchar(20) DEFAULT NULL COMMENT '实验标准',
  `stressType` varchar(20) DEFAULT NULL COMMENT '抗压型号',
  `flexureType` varchar(20) DEFAULT NULL COMMENT '抗折型号',
  `stressNo` varchar(20) DEFAULT NULL COMMENT '抗压编号',
  `flexureNo` varchar(20) DEFAULT NULL COMMENT '抗折编号',
  `stressSta` varchar(20) DEFAULT NULL COMMENT '抗压状况',
  `flexureSta` varchar(20) DEFAULT NULL COMMENT '抗折状况',
  `stressVail` varchar(20) DEFAULT NULL COMMENT '抗压校核',
  `flexureVail` varchar(20) DEFAULT NULL COMMENT '抗折校核',
  `stressCKS` varchar(20) DEFAULT NULL COMMENT '抗压检验',
  `flexureCKS` varchar(20) DEFAULT NULL COMMENT '抗折检验',
  `notes` varchar(20) DEFAULT NULL COMMENT '备注',
  `stress1` varchar(20) DEFAULT NULL COMMENT '压力1',
  `stress2` varchar(20) DEFAULT NULL COMMENT '压力2',
  `stress3` varchar(20) DEFAULT NULL COMMENT '压力3',
  `stress4` varchar(20) DEFAULT NULL COMMENT '压力4',
  `stress5` varchar(20) DEFAULT NULL COMMENT '压力5',
  `stress6` varchar(20) DEFAULT NULL COMMENT '压力6',
  `pressure1` varchar(20) DEFAULT NULL COMMENT '压强1',
  `pressure2` varchar(20) DEFAULT NULL COMMENT '压强2',
  `pressure3` varchar(20) DEFAULT NULL COMMENT '压强3',
  `pressure4` varchar(20) DEFAULT NULL COMMENT '压强4',
  `pressure5` varchar(20) DEFAULT NULL COMMENT '压强5',
  `pressure6` varchar(20) DEFAULT NULL COMMENT '压强6',
  `avgPressure` varchar(20) DEFAULT NULL COMMENT '平均抗压强度',
  `flexure1` varchar(20) DEFAULT NULL COMMENT '抗折1',
  `flexure2` varchar(20) DEFAULT NULL COMMENT '抗折2',
  `flexure3` varchar(20) DEFAULT NULL COMMENT '抗折3',
  `avgFlexure` varchar(20) DEFAULT NULL COMMENT '平均抗折强度',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
