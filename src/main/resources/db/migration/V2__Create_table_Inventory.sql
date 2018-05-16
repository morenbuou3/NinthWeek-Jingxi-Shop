CREATE TABLE Inventory(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    count INT DEFAULT 0,
    lockedCount INT DEFAULT 0,
    productId INT NOT NULL,
    constraint `product_id_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;