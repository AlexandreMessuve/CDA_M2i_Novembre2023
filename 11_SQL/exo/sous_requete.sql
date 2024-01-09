-- 1
SELECT *
FROM Users
WHERE birth_location = 
	(
	SELECT birth_location 
	FROM Users 
	ORDER BY age 
	ASC LIMIT 1
	);

-- 2
SELECT * 
FROM Users
WHERE salary < 
	( 
	SELECT AVG(salary) AS avg_salary
	FROM Users
	WHERE job = 'Developer'
	);

-- 3
SELECT *
FROM Users
WHERE salary > 
	(
	SELECT AVG(salary) AS avg_salary
	FROM Users
	WHERE birth_location = 
		(
		SELECT birth_location 
		FROM Users
		WHERE first_name = 'John' AND last_name = 'Doe'
		)
	);