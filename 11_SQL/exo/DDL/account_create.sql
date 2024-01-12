DROP TABLE IF EXISTS Account;

CREATE TABLE Account(
	account_id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    last_connection VARCHAR(50) NOT NULL
    );