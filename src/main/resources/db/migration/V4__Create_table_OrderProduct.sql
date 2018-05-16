CREATE TABLE OrderProduct(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(100) NOT NULL,
    productDescription VARCHAR(200),
    purchasePrice DECIMAL(10,2) NOT NULL,
    purchaseCount INT NOT NULL,

    orderItemId INT NOT NULL,
    productId INT NOT NULL,
    constraint `orderItem_id_for` FOREIGN KEY (`orderItemId`) REFERENCES `OrderItem` (`id`),
    constraint `productOrder_id_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;