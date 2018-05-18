CREATE TABLE OrderProduct(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_description VARCHAR(200),
    purchase_price DECIMAL(10,2) NOT NULL,
    purchase_count INT NOT NULL,

    order_id INT NOT NULL,
    product_id INT NOT NULL,
    constraint `order_id_for` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`),
    constraint `product_id_for_b` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;