DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;



CREATE TABLE Person (
	person_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(10) CHECK(title IN('M', 'MME')),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL);
    
CREATE TABLE Address (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10),
    FOREIGN KEY (person_id)
		REFERENCES Person(person_id)
    );

