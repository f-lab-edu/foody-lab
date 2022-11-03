CREATE TABLE `t_order`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `customer_id`   BIGINT(50) UNSIGNED NOT NULL            COMMENT '고객 id',
    `store_id`      BIGINT(50) UNSIGNED NOT NULL            COMMENT '가게 id',
    `order_price`   BIGINT(50) UNSIGNED NOT NULL            COMMENT '주문 금액',
    `ordered_date`  TIMESTAMP           NOT NULL   DEFAULT CURRENT_TIMESTAMP,
    `updatedAt`     TIMESTAMP           NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '주문 정보';