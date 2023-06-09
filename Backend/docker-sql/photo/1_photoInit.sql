CREATE TABLE photos
(
    photo_id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id        BIGINT       NOT NULL,
    encoded_name   VARCHAR(256) NOT NULL,
    original_name  VARCHAR(256) NOT NULL,
    path           VARCHAR(256) NOT NULL,
    file_extension VARCHAR(256) NOT NULL,
    created_dt     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';
