CREATE TABLE `book` (
  `id` INTEGER,
  `category_id` INTEGER,
  `author` varchar(255),
  `publisher` varchar(255),
  `name` varchar(255),
  `gimmick` INTEGER,
  `stat` varchar(255),
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `book_reservation` (
  `id` INTEGER,
  `book_id` INTEGER,
  `reservation_id` INTEGER,
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `user_reservation` (
  `id` INTEGER,
  `user_id` INTEGER,
  `reservation_id` INTEGER,
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `user` (
  `id` INTEGER,
  `name` varchar(255),
  `created_at` varchar(255),
  `updated_at` varchar(255),
  `email` varchar(255),
  `late_fee` INTEGER,
  `phone` varchar(255),
  `adr` INTEGER,
  `oauth_id` varchar(255)
);

CREATE TABLE `review` (
  `id` INTEGER,
  `user_id` INTEGER,
  `book_id` INTEGER,
  `score` INTEGER,
  `stat` varchar(255),
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `reservation` (
  `id` INTEGER,
  `stat` INTEGER,
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `category` (
  `id` INTEGER,
  `name` INTEGER,
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `order` (
  `id` INTEGER,
  `user_id` INTEGER,
  `book_id` INTEGER,
  `created_at` varchar(255),
  `updated_at` varchar(255)
);

CREATE TABLE `loan` (
  `id` INTEGER,
  `user_id` INTEGER,
  `book_id` INTEGER,
  `due_at` varchar(255),
  `created_at` varchar(255),
  `return_at` varchar(255),
  `updated_at` varchar(255)
);

ALTER TABLE `book` ADD FOREIGN KEY (`id`) REFERENCES `book_reservation` (`book_id`);

ALTER TABLE `reservation` ADD FOREIGN KEY (`id`) REFERENCES `book_reservation` (`reservation_id`);

ALTER TABLE `category` ADD FOREIGN KEY (`id`) REFERENCES `book` (`category_id`);

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `user_reservation` (`user_id`);

ALTER TABLE `reservation` ADD FOREIGN KEY (`id`) REFERENCES `user_reservation` (`reservation_id`);

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `loan` (`user_id`);

ALTER TABLE `book` ADD FOREIGN KEY (`id`) REFERENCES `loan` (`book_id`);

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `order` (`user_id`);

ALTER TABLE `book` ADD FOREIGN KEY (`id`) REFERENCES `order` (`book_id`);

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `review` (`user_id`);

ALTER TABLE `book` ADD FOREIGN KEY (`id`) REFERENCES `review` (`book_id`);
