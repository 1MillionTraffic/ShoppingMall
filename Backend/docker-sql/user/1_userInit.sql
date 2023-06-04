CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `uid`     varchar(100),
  `email`   varchar(100),
  `user_name` varchar(255) NOT NULL,
  `created_dt` timestamp   not null default current_timestamp,
  `updated_dt` timestamp   not null default current_timestamp on update current_timestamp,
  PRIMARY KEY (`user_id`)
);
