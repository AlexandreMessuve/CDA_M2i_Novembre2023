CREATE DATABASE IF NOT EXISTS `m2i-sql`;

USE `m2i-sql`;

DROP TABLE IF EXISTS Students;


CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT,
    grade VARCHAR(10)
);
-- Partie 01
INSERT INTO Students (student_id, first_name, last_name, age, grade)
VALUES 
	(1, 'Maria', 'Rodriguez', 21, 'B'),
	(2, 'Ahmed', 'Khan', 19, 'A'),
	(3, 'Emily', 'Baker', 33, 'C');

SELECT * FROM Students;

-- Partie 02
UPDATE Students
	SET grade = 'A'
WHERE 
	first_name = 'Maria' AND student_id = 1;
    
SELECT * FROM Students;

SET SQL_SAFE_UPDATES = 0;
UPDATE Students 
	SET age = age + 1;

SELECT * FROM Students;

-- Partie 03
DELETE FROM Students 
WHERE 
	first_name = 'Emily' AND student_id = 3;

SELECT * FROM Students;

DELETE FROM Students
WHERE 
	age < 20;

SELECT * FROM Students;
-- partie 04
TRUNCATE Students;

SELECT * FROM Students;