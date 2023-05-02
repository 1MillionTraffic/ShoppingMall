CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `product_option_id` bigint NOT NULL,

  `product_name` varchar(255) NOT NULL,
  `shop_name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `product_option_name` varchar(255) NOT NULL,

  `created_dt` timestamp   not null default current_timestamp,
  `updated_dt` timestamp   not null default current_timestamp on update current_timestamp,
  PRIMARY KEY (`product_id`)
);
