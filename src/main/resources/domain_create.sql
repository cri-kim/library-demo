CREATE TABLE `book` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `category_id` int,
  `name` varchar(255),
  `stat` varchar(255),
  `amount` int,
  `author` varchar(255),
  `publisher` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `category` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `user` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `email` varchar(255),
  `lateFee` int,
  `phone` varchar(255),
  `addr` varchar(255),
  `oauth_id` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `order` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `book_id` int,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `Loan` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `book_id` int,
  `due_at` timestamp,
  `return_at` timestamp,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `reservation` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `book_id` int,
  `stat` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `review` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `book_id` int,
  `content` varchar(255),
  `score` int,
  `created_at` timestamp,
  `updated_at` timestamp
);

ALTER TABLE `book` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

ALTER TABLE `Loan` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `Loan` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

ALTER TABLE `reservation` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `reservation` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
