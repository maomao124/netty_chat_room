-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`
(
    `id`                       bigint(20)  NOT NULL COMMENT 'ID',
    `username`                 varchar(30) NOT NULL COMMENT '账号',
    `status`                   bit(1)               DEFAULT b'0' COMMENT '启用状态 1启用 0禁用',
    `password`                 varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
    `last_login_time`          datetime             DEFAULT NULL COMMENT '最后登录时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_username` (`username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='用户';
