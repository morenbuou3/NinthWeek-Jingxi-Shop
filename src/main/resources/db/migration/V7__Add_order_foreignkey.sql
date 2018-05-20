ALTER TABLE `Order` ADD user_id INT NOT NULL;
ALTER TABLE `Order` ADD CONSTRAINT `user_id_for` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);