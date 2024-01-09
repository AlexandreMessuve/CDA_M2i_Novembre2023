-- 1 
SELECT *
FROM Users
WHERE first_name LIKE 'D%';

-- 2
SELECT * 
FROM Users
WHERE last_name LIKE '%son';

-- 3
SELECT *
FROM Users
WHERE first_name LIKE '_____';

-- 4
SELECT * 
FROM Users
WHERE job LIKE '%Doctor%';