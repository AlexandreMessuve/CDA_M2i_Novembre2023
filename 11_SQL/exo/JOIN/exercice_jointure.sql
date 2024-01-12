CREATE DATABASE IF NOT EXISTS shop;

USE shop;


DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Clients;

-- 1
CREATE TABLE Clients (
	id_clients INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    city VARCHAR(100) NOT NULL
    );
    
CREATE TABLE Orders (
	id_orders INT AUTO_INCREMENT PRIMARY KEY,
    id_clients INT,
    product VARCHAR(100) NOT NULL,
    amount FLOAT NOT NULL,
    FOREIGN KEY (id_clients) 
		REFERENCES Clients(id_clients)
    );

-- 2
-- inserer au moins cinq clients dans la table Clients

INSERT INTO Clients (first_name, last_name, city)
VALUES 
	('Florian','Delafosse','Halluin'),
    ('François','Doué','Lens'),
    ('Alexandre','Penet','Lomme'),
    ('Alexandre','Messuve','Lille'),
    ('Mohamed','Boulaabi','Lille');

-- inserer au moins 10 commandes dans la table Orders et veullez a ce que des clients n'est pas effectué de commande.
INSERT INTO Orders (id_clients, product, amount)
VALUES
	(1,'Calvados 1L',19.99),
    (1,'Vodka 1L',15.99),
    (2,'Bière Pack de 5',5.99),
    (4,'Star Citizen',69.99),
    (4,'Casque Logitech G Pro X',159.99),
    (1,'Whisky',69.99),
    (4,'Souris Logitech G Pro X2',139.99),
    (1,'Ferrero Rocher',5.99),
    (4,'Chips Lays Goùt Barbecue 200gr',2.99),
    (1,'Vin rouge Saint-Emilion 1L',15.99),
    (NULL, 'Maison Blanche', 1502521.52);
    
-- 3

-- a
SELECT c.first_name, c.last_name, o.*
FROM Clients AS c
INNER JOIN Orders AS o
ON c.id_clients = o.id_clients;

-- b 
SELECT * 
FROM Clients AS c
LEFT JOIN Orders AS o
ON c.id_clients = o.id_clients;

-- c
SELECT * 
FROM Clients AS c
RIGHT JOIN Orders AS o
ON c.id_clients = o.id_clients;

-- d
SELECT * 
FROM Clients AS c
LEFT JOIN Orders AS o
ON c.id_clients = o.id_clients

UNION

SELECT * 
FROM Clients AS c
RIGHT JOIN Orders AS o
ON c.id_clients = o.id_clients;


