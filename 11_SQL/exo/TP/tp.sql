-- ETAPE 01 Création bdd et tables

-- 1
CREATE DATABASE IF NOT EXISTS tabletoptreasures_database;

USE tabletoptreasures_database;

DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Games;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Clients;

-- 2
CREATE TABLE Clients (
	id_clients INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address_delivery VARCHAR(255),
    phone_number VARCHAR(15)
    );

CREATE TABLE Categories(
	id_categories INT AUTO_INCREMENT PRIMARY KEY,
    categ_name VARCHAR(100) NOT NULL
);


CREATE TABLE Games (
	id_games INT AUTO_INCREMENT PRIMARY KEY,
    games_name VARCHAR(100) NOT NULL,
    games_description TEXT,
    price FLOAT NOT NULL,
    id_categories INT NOT NULL,
    FOREIGN KEY (id_categories) 
		REFERENCES Categories(id_categories)
    );
    
CREATE TABLE Orders(
	id_orders INT AUTO_INCREMENT PRIMARY KEY,
    id_clients INT NOT NULL,
    id_games INT NOT NULL,
    orders_date DATETIME NOT NULL,
    address_delivery  VARCHAR(255) NOT NULL,
    orders_status TINYINT,
    FOREIGN KEY (id_clients) 
		REFERENCES Clients(id_clients),
	FOREIGN KEY (id_games)
		REFERENCES Games(id_games)
);

-- Etape 02 Opération DML
-- 1
INSERT INTO Clients (last_name, first_name, email, address_delivery, phone_number)
VALUES 
	('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
	('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
	('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
	('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
	('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
	('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
	('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
	('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
	('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
	('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
	('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
	('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
	('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
	('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
	('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');

INSERT INTO Categories (categ_name)
VALUES
	('Stratégie'),
	('Familial'),
	('Aventure');
    
INSERT INTO Games (games_name, games_description, price, id_categories)
VALUES
	('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
	('Dixit', 'Jeu d''association d''images', 25, 2),
	('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
	('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
	('Codenames', 'Jeu de mots et d''indices', 20, 2),
	('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
	('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
	('Splendor', 'Jeu de développement économique', 27, 2),
	('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
	('Risk', 'Jeu de conquête mondiale', 22, 1),
	('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
	('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
	('Small World', 'Jeu de civilisations fantastiques', 32, 1),
	('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
	('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);
    

-- 2
INSERT INTO Orders (id_clients,id_games, orders_date, address_delivery, orders_status)
VALUES
	(2,3,NOW(), '456 Avenue des Roses, Ville', 0),
    (4,8,'2023-05-07 16:35:12', '567 Avenue de la Liberté, Ville',2),
    (7,10, '2024-01-05 10:10:30', '345 Boulevard du Bonheur, Ville', 1);
    
-- 3

UPDATE Games
	SET price = 35
WHERE 
	id_games = 3;

-- 4
DELETE 
	FROM Games 
	WHERE id_games = 2;

-- Requetes SQL Simples
-- Categories

-- 1
SELECT DISTINCT categ_name 
	FROM Categories;
-- 2
SELECT categ_name
	FROM Categories
	WHERE
	categ_name LIKE 'A%' OR categ_name LIKE 'S%';
-- 3
SELECT categ_name
	FROM Categories
	WHERE id_categories BETWEEN 2 AND 5;
-- 4
SELECT DISTINCT count(*) AS numbers_categ
	FROM Categories;
-- 5
SELECT categ_name
	FROM Categories
    ORDER BY LENGTH(categ_name) DESC 
    LIMIT 1;
-- 6
SELECT c.categ_name, COUNT(g.id_games) AS number_games
	FROM Categories AS c
    INNER JOIN Games AS g
		ON c.id_categories = g.id_categories
    GROUP BY categ_name;
-- 7
SELECT categ_name
	FROM Categories
	ORDER BY categ_name DESC;

-- Games
-- 1
SELECT DISTINCT games_name, games_description, price
	FROM Games;

-- 2
SELECT games_name, games_description, price
	FROM Games
    WHERE price BETWEEN 25 AND 40;

-- 3
SELECT games_name, games_description, price
	FROM Games 
    WHERE id_categories = 3;
-- 4
SELECT COUNT(*) AS number_games
	FROM Games
    WHERE games_description LIKE '%aventure%';

-- 5
SELECT games_name, games_description, price
	FROM Games
    ORDER BY price ASC 
    LIMIT 1;

-- 6
SELECT SUM(price) AS total_price_games
	FROM Games;
    
-- 7
SELECT games_name, games_description, price
	FROM Games
    ORDER BY games_name ASC
    LIMIT 5;
 -- Clients
 
 -- 1
 SELECT DISTINCT first_name
	FROM Clients;
    
-- 2
SELECT first_name, last_name, address_delivery, phone_number
	FROM Clients
    WHERE address_delivery LIKE '%Rue%' AND phone_number LIKE '+1%';

-- 3 
SELECT first_name, last_name, address_delivery, phone_number
	FROM Clients 
    WHERE last_name LIKE 'M%' OR last_name LIKE 'R%';

-- 4
SELECT COUNT(*) AS clients_count
	FROM Clients
    WHERE email LIKE '%@%';

-- 5
SELECT first_name, last_name, address_delivery, phone_number
	FROM Clients 
    ORDER BY LENGTH(first_name) ASC
    LIMIT 1;
    
-- 6
SELECT COUNT(*) AS total_clients
	FROM Clients;
    
-- 7
SELECT first_name, last_name, address_delivery, phone_number
	FROM Clients
    ORDER BY last_name ASC
    LIMIT 15 OFFSET 3;
    
-- Etape 4 Requete SQL avancées

-- 1
SELECT c.last_name,c.first_name,g.games_name,o.orders_date
	FROM Orders AS o
	RIGHT JOIN Clients AS c
		ON o.id_clients = c.id_clients
	LEFT JOIN Games AS g
		ON o.id_games = g.id_games;
-- 2
SELECT c.last_name,c.first_name,SUM(g.price) AS total_price
		FROM Clients AS c
	INNER JOIN Orders AS o
		ON o.id_clients = c.id_clients
	INNER JOIN Games AS g
		ON o.id_games = g.id_games
	GROUP BY o.id_clients
    ORDER BY total_price DESC;
    
-- 3
SELECT g.games_name, c.categ_name, g.price
	FROM Games AS g
    INNER JOIN Categories AS c
		ON c.id_categories = g.id_categories;
        
-- 4
INSERT INTO Orders (id_clients,id_games, orders_date, address_delivery, orders_status)
VALUES
	(2,5,'2023-05-10 14:30:10', '456 Avenue des Roses, Ville', 1),
    (4,10,'2023-05-07 16:35:12', '567 Avenue de la Liberté, Ville',2),
    (7,7, '2024-01-05 10:10:30', '345 Boulevard du Bonheur, Ville', 1);

SELECT c.last_name,c.first_name,g.games_name,o.orders_date
	FROM Clients AS c
	INNER JOIN Orders AS o
		ON o.id_clients = c.id_clients
	INNER JOIN Games AS g
		ON o.id_games = g.id_games;
        
-- 5
SELECT c.last_name,c.first_name,COUNT(o.id_orders) AS total_orders, SUM(g.price) AS total_prices
	FROM Clients AS c
	LEFT JOIN Orders AS o
		ON o.id_clients = c.id_clients
	LEFT JOIN Games AS g
		ON o.id_games = g.id_games
	GROUP BY c.id_clients
    HAVING total_orders > 1;