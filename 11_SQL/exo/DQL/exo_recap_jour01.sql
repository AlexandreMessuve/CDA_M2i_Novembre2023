-- Exercice récap jour 01 

-- 1
SELECT * 
FROM Users;

-- 2 
SELECT first_name, last_name
FROM Users
WHERE birth_location IN ('New York', 'Paris');

-- 3 
SELECT * 
FROM Users
WHERE job IN ('Developer', 'Designer');

-- 4
SELECT * 
FROM Users
WHERE age > 30;

-- 5
SELECT * 
FROM Users
WHERE (salary BETWEEN 2500 AND 3000);

-- 6 
SELECT * 
FROM Users
WHERE (job NOT IN ('Developer','Designer'));

-- 7
SELECT *
FROM Users
ORDER BY last_name ASC, first_name ASC;

-- 8
SELECT *
FROM Users
WHERE YEAR(birth_date) < 1990;

-- 9
SELECT * 
FROM Users
WHERE birth_location IN ('London', 'Berlin') AND job = 'Designer';

-- 10
SELECT * 
FROM Users
ORDER BY salary ASC
LIMIT 10;

-- 11
SELECT first_name, last_name, age
FROM Users
WHERE (YEAR(birth_date) BETWEEN 1980 AND 1990);

-- 12
SELECT * 
FROM Users
ORDER BY age DESC;

-- 13
SELECT *
FROM Users
WHERE job = 'Doctor' AND salary > 3000;

-- 14
SELECT * 
FROM Users
ORDER BY birth_location ASC, salary DESC;

-- 15
SELECT *
FROM Users
WHERE birth_location = 'Paris' AND job = 'Lawyer';

-- 16
SELECT MIN(salary) AS salary_min
FROM Users;

-- 17 
SELECT * 
FROM Users
WHERE YEAR(birth_date) > 1985 AND job = 'Engineer';

-- 18
SELECT *
FROM Users 
WHERE first_name = 'John' AND last_name = 'Doe';

-- 19
SELECT *
FROM Users
ORDER BY salary ASC
LIMIT 6 
OFFSET 3;

-- 20
SELECT * 
FROM Users
ORDER BY age ASC
LIMIT 5;