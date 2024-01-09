-- 1
SELECT birth_location, COUNT(first_name) AS number_user
FROM Users
GROUP BY birth_location
HAVING number_user > 1;

-- 2
SELECT job , ROUND(AVG(salary),2) AS avg_salary_job
FROM Users
GROUP BY job
HAVING avg_salary_job > 2500;

-- 3
SELECT birth_location, ROUND(SUM(salary),2) AS total_salary_location
FROM Users
GROUP BY birth_location
HAVING total_salary_location > 5000;

-- 4
SELECT birth_date , COUNT(birth_date) AS number_user_birth
FROM Users
GROUP BY birth_date
HAVING number_user_birth > 1;

-- 5
SELECT job, birth_location, MAX(salary) AS salary_max_job_location
FROM Users
GROUP BY job, birth_location
HAVING salary_max_job_location > 3000;