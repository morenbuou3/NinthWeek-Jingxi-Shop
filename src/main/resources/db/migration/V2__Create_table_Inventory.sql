CREATE TABLE Inventory(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `count` INT DEFAULT 0,
    locked_count INT DEFAULT 0,
    product_id INT NOT NULL,
    constraint `product_id_for` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;