-- Création de la base de données
CREATE DATABASE IF NOT EXISTS test_bdd;
USE test_bdd;

-- Supprime la table Users si elle existe déjà
DROP TABLE IF EXISTS Users;

-- Création de la table Users
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    job VARCHAR(100),
    birth_date DATE,
    birth_location VARCHAR(100)
);

-- Insertion de données aléatoires dans la table Users
INSERT INTO Users (first_name, last_name, job, birth_date, birth_location)
VALUES
    ('John', 'Doe', 'Developer', '1995-05-12', 'New York'),
    ('Alice', 'Smith', 'Designer', '1988-09-28', 'London'),
    ('Michael', 'Johnson', 'Engineer', '1977-02-05', 'Los Angeles'),
    ('Emily', 'Brown', 'Teacher', '1992-04-18', 'Paris'),
    ('David', 'Lee', 'Doctor', '1985-11-30', 'Tokyo'),
    ('Sarah', 'Wilson', 'Lawyer', '1990-06-08', 'Sydney'),
    ('Daniel', 'Anderson', 'Developer', '1983-12-21', 'Toronto'),
    ('Jessica', 'Taylor', 'Engineer', '1991-10-15', 'Berlin'),
    ('Christopher', 'Moore', 'Designer', '1997-01-04', 'Rome'),
    ('Olivia', 'Jackson', 'Teacher', '1994-08-22', 'Moscow'),
    ('James', 'Doe', 'Engineer', '1987-03-12', 'New York'),
    ('Sophia', 'Smith', 'Developer', '1993-07-28', 'London'),
    ('Emma', 'Johnson', 'Designer', '1980-09-05', 'Los Angeles'),
    ('Daniel', 'Brown', 'Doctor', '1992-02-18', 'Paris'),
    ('David', 'Lee', 'Lawyer', '1985-11-30', 'Tokyo');
    
-- Désactiver le Safe Update Mode
SET SQL_SAFE_UPDATES = 0;

-- Ajouter la colonne "age" et "salary" à la table "Users"
ALTER TABLE Users
ADD COLUMN age INT,
ADD COLUMN salary INT NOT NULL DEFAULT 0;

-- Mettre à jour la colonne "age" avec les âges calculés à partir de la date de naissance
UPDATE Users
SET age = TIMESTAMPDIFF(YEAR, birth_date, CURDATE());

-- Mettre à jour la colonne "salaire" avec des valeurs aléatoires entre 2000 et 3500
UPDATE Users
SET salary = FLOOR(2000 + RAND() * (3500 - 2000));

-- Activer le Safe Update Mode
SET SQL_SAFE_UPDATES = 1;