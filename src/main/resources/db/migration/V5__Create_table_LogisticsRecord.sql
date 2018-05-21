CREATE TABLE LogisticsRecord(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    delivery_man VARCHAR(20) NOT NULL,
    outbound_time DATE,
    signed_time DATE,
    logistics_status VARCHAR(20),
    order_id INT NOT NULL,
    constraint `order_id_for_b` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;