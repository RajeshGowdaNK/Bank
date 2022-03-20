create schema bank;

DROP TABLE IF EXISTS customer, account, bank_employee, payee,transaction ;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aadhar_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `identifier` binary(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `pan_number` varchar(255) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `zip_code` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;




CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_number` bigint DEFAULT NULL,
  `account_type` int DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `current_balance` decimal(19,2) DEFAULT NULL,
  `identifier` varchar(50) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnnwpo0lfq4xai1rs6887sx02k` (`customer_id`),
  CONSTRAINT `FKnnwpo0lfq4xai1rs6887sx02k` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `bank_employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


CREATE TABLE `payee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_number` bigint DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `ifsc_code` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `payee_name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrt46jfroxkilyhgdxbg29kor9` (`account_id`),
  CONSTRAINT `FKrt46jfroxkilyhgdxbg29kor9` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `credited_debited` varchar(255) DEFAULT NULL,
  `transaction_id` binary(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`),
  CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




