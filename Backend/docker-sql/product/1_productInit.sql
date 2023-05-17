CREATE TABLE products
(
    product_id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    shop_id            BIGINT       NOT NULL,
    thumbnail_photo_id BIGINT       NOT NULL,
    category_id        BIGINT       NOT NULL,
    sub_category_id    BIGINT,
    sale_id            BIGINT,
    serial_number      VARCHAR(256) NOT NULL,
    product_state      VARCHAR(256) NOT NULL,
    product_name       VARCHAR(256) NOT NULL,
    product_desc       VARCHAR(256) NOT NULL,
    gender             VARCHAR(256) NOT NULL,
    price              BIGINT       NOT NULL DEFAULT 0,
    register_dt        TIMESTAMP,
    created_dt         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_dt         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE `like`
(
    like_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT     NOT NULL,
    product_id BIGINT     NOT NULL,
    activation TINYINT(1) NOT NULL,
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE options
(
    option_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_option_id BIGINT       NOT NULL,
    has_child_option TINYINT(1)   NOT NULL,
    quantity         INTEGER,
    title            VARCHAR(256) NOT NULL,
    price_offset     BIGINT       NOT NULL DEFAULT 0,
    created_dt       TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_dt       TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

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

CREATE TABLE photo_map
(
    photo_map_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ref_id       BIGINT NOT NULL,
    photo_id     BIGINT NOT NULL,
    created_dt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE posts
(
    post_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id         BIGINT       NOT NULL,
    thumbnail_photo_id BIGINT       NOT NULL,
    user_id            BIGINT       NOT NULL,
    title              VARCHAR(256) NOT NULL,
    content            VARCHAR(256) NOT NULL,
    post_type          VARCHAR(256) NOT NULL,
    post_state         VARCHAR(256) NOT NULL,
    created_dt         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE post_views
(
    post_view_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    view_count   BIGINT NOT NULL,
    created_dt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE review
(
    review_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT       NOT NULL,
    product_id BIGINT       NOT NULL,
    photo_id   BIGINT,
    rate       INTEGER      NOT NULL,
    comment    VARCHAR(256) NOT NULL,
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE shops
(
    shop_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    shop_name  VARCHAR(256) NOT NULL,
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE tags
(
    tag_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    tag_type   VARCHAR(256) NOT NULL,
    content    VARCHAR(256) NOT NULL,
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE tag_map
(
    tag_map_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ref_id     BIGINT NOT NULL,
    tag_id     BIGINT NOT NULL,
    created_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE sales
(
    sale_id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    discount_percent BIGINT,
    discount_amount  BIGINT,
    created_dt       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';

CREATE TABLE categories
(
    category_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_category_id BIGINT,
    has_child_category TINYINT(1)   NOT NULL,
    content            VARCHAR(256) NOT NULL,
    created_dt         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_dt         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = 'utf8mb4'
  DEFAULT COLLATE = 'utf8mb4_general_ci';
