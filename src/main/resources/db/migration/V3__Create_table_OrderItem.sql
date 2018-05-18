CREATE TABLE `Order`(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    total_price DECIMAL(20,2) NOT NULL,
    status VARCHAR(10),
    create_time DATETIME DEFAULT NOW(),
    finish_time DATETIME,
    paid_time DATETIME,
    withdrawn_time DATETIME
) engine=InnoDB DEFAULT CHARSET = utf8;