-- 1
SELECT MIN(salary) AS salary_min
FROM Users;

-- 2
SELECT MAX(age) AS age_max_engineer
FROM Users
WHERE job = 'Engineer';

-- 3
SELECT ROUND(AVG(salary)) AS salary_avg_teacher
FROM Users
WHERE job = 'Teacher';

-- 4
SELECT SUM(salary) AS total_salary
FROM Users;