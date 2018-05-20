CREATE TABLE `Order`(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    total_price DECIMAL(20,2) NOT NULL,
    status VARCHAR(10),
    create_time DATE,
    finish_time DATE,
    paid_time DATE,
    withdrawn_time DATE
) engine=InnoDB DEFAULT CHARSET = utf8;