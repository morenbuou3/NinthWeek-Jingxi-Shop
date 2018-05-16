CREATE TABLE LogisticsRecord(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    deliveryMan VARCHAR(20) NOT NULL,
    outboundTime DATETIME,
    signedTime DATETIME,
    logisticsStatus VARCHAR(10),
    orderItemId INT NOT NULL,
    constraint `orderItemLogistics_id_for` FOREIGN KEY (`orderItemId`) REFERENCES `OrderItem` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;