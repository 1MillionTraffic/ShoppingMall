CREATE TABLE `products`
(
    `product_id`      bigint        NOT NULL AUTO_INCREMENT,
    `shop_id`         bigint        NOT NULL,
    `category_id`     bigint        NOT NULL,
    `sub_category_id` bigint        NULL,

    `product_state`   char(255)     NOT NULL default 'REGISTERED',
    `product_name`    varchar(255)  NOT NULL,
    `product_desc`    varchar(1024) NOT NULL,
    `serial_number`   char(255)     NOT NULL,
    `gender`          char(255)     NOT NULL default 'MALE',
    `price`           bigint        NOT NULL default 0,
    `reservation_dt`  timestamp     NULL,

    `created_dt`      timestamp     NOT NULL default current_timestamp,
    `updated_dt`      timestamp     NOT NULL default current_timestamp on update current_timestamp,
    PRIMARY KEY (`product_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';
