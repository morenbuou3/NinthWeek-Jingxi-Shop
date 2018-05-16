CREATE TABLE OrderItem(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    totalPrice DECIMAL(20,2) NOT NULL,
    status VARCHAR(10),
    createTime DATETIME DEFAULT NOW(),
    finishTime DATETIME,
    paidTime DATETIME,
    withdrawnTime DATETIME
) engine=InnoDB DEFAULT CHARSET = utf8;