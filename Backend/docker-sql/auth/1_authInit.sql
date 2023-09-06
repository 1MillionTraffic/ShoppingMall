CREATE TABLE `auths` (
    `id`    bigint NOT NULL AUTO_INCREMENT,
    `uid`   varchar(100),
    `user_name` varchar(255) NOT NULL,
    `email` varchar(100),
    `provider` varchar(50),
    `encrypted_password` varchar(200),
    `created_dt` timestamp   not null default current_timestamp,
    `updated_dt` timestamp   not null default current_timestamp on update current_timestamp,
    PRIMARY KEY (`id`)
);