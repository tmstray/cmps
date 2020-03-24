
DROP TABLE IF EXISTS `cement_lastcount`;

CREATE TABLE `cement_lastcount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cementcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=726 DEFAULT CHARSET=utf8;

/*Table structure for table `eqds_data` */

DROP TABLE IF EXISTS `eqds_data`;

CREATE TABLE `eqds_data` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `gid` int(10) DEFAULT NULL COMMENT '原id',
  `sampleNoG` varchar(30) DEFAULT NULL COMMENT 'x试样编号',
  `drags` varchar(30) DEFAULT NULL COMMENT '焦渣号',
  `mar` varchar(30) DEFAULT NULL COMMENT '收到基水分',
  `mad` varchar(30) DEFAULT NULL COMMENT '空干基水分',
  `vad` varchar(30) DEFAULT NULL COMMENT '空干基挥发分',
  `aad` varchar(30) DEFAULT NULL COMMENT '空干基灰分',
  `had` varchar(30) DEFAULT NULL COMMENT '空干基氢含量',
  `createTimeG` varchar(20) DEFAULT NULL COMMENT '测试日期',
  `yid` int(10) DEFAULT NULL COMMENT '原id',
  `sampleNoY` varchar(30) DEFAULT NULL COMMENT 'x试样编号',
  `stad` double DEFAULT NULL COMMENT '空干基硫含量',
  `createTimeY` varchar(20) DEFAULT NULL COMMENT '测试日期',
  `lid` int(10) DEFAULT NULL COMMENT '原id',
  `sampleNoL` varchar(30) DEFAULT NULL COMMENT '量热仪试样编号',
  `qbad` double DEFAULT NULL COMMENT '弹筒发热量',
  `createTimeL` varchar(20) DEFAULT NULL COMMENT '测试日期',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `qnetar` varchar(30) DEFAULT NULL COMMENT '备用字段1',
  `qnetad` varchar(30) DEFAULT NULL COMMENT '备用字段2',
  `qgrd` varchar(30) DEFAULT NULL COMMENT '备用字段3',
  `fcad` varchar(30) DEFAULT NULL,
  `keed` int(1) DEFAULT NULL COMMENT '煤种',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `eqds_lastcount` */

DROP TABLE IF EXISTS `eqds_lastcount`;

CREATE TABLE `eqds_lastcount` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `gcount` int(10) DEFAULT NULL,
  `ycount` int(10) DEFAULT NULL,
  `lcount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `business_module` varchar(100) DEFAULT '' COMMENT '业务模块',
  `business_type` int(20)  COMMENT '业务类型（ 1新增 2修改 3删除,4数据同步 5数据上传）',
  `method` varchar(100) DEFAULT '' COMMENT '操作方法',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `ip` varchar(64) DEFAULT '' COMMENT '操作者IP',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `remarks` varchar(200) DEFAULT '' COMMENT '备注',
  `create_by` varchar(32) DEFAULT '' COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `delete_flag` int(11) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `phone_number` varchar(30) DEFAULT '' COMMENT '手机号码',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `menu_id` varchar(200) DEFAULT '' COMMENT '菜单id',
  `menu_name` varchar(2000) DEFAULT '' COMMENT '菜单名称',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

