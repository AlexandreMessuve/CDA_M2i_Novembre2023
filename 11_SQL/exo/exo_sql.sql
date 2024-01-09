-- Exercice 01
SELECT * 
FROM Users;

SELECT first_name, last_name, job 
FROM Users; 

-- Exercice 02
SELECT * 
FROM Users 
WHERE job <> 'Developer';

SELECT * 
FROM Users 
WHERE first_name = 'John';

SELECT * 
FROM Users 
WHERE salary >= 3000;

-- Exercice 03
SELECT first_name, last_name, age
FROM Users
WHERE age < 30 OR age >= 35;

SELECT first_name, last_name, job, salary
FROM Users
WHERE job = 'Teacher' AND salary > 2600;


SELECT * 
FROM Users
WHERE birth_location = 'New York' 
AND salary > 3000 AND salary <= 3500 
AND NOT (job = 'Doctor' OR job = 'Lawyer');

-- Exercice 04
SELECT * 
FROM Users
WHERE job IN ('Engineer');

SELECT first_name, last_name
FROM Users
WHERE birth_location IN ('London','Paris', 'Berlin');

SELECT * 
FROM Users
WHERE (age BETWEEN 25 AND 35) ORDER BY age;

SELECT * 
FROM Users
WHERE job IN ('Developer') AND salary > 2500;

-- Exercice 06
SELECT * 
FROM Users
ORDER BY age DESC
LIMIT 5;

SELECT * 
FROM Users
ORDER BY first_name ASC
LIMIT 5 OFFSET 6;

SELECT * 
FROM Users
ORDER BY salary DESC
LIMIT 3;

