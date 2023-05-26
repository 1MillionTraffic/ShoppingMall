CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `created_dt` timestamp   not null default current_timestamp,
  `updated_dt` timestamp   not null default current_timestamp on update current_timestamp,
  PRIMARY KEY (`product_id`)
);
