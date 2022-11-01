CREATE TABLE `t_user`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(50)         NOT NULL                   COMMENT '유저 이름',
    `createdAt`     TIMESTAMP           NOT NULL   DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP           NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '유저 정보';