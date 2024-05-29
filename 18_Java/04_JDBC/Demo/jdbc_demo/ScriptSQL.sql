create database demo_jdbc;

use demo_jdbc;

create table person (
id int auto_increment primary key,
firstname varchar(50),
lastname varchar (50)
);

create table plante (
id int auto_increment primary key,
name varchar(50),
color varchar (50),
age int
);

create table film (
id int auto_increment primary key,
titre VARCHAR(50),
realisateur varchar(50),
genre varchar(50),
date_de_sortie date
);

create table commande (
id int auto_increment primary key,
prix float,
quantite int,
plante_id int not null,
foreign key (plante_id) references plante(id) on delete cascade
);

create table animal (
id int auto_increment primary key,
name varchar(50),
race varchar(50),
description varchar(250),
habitat varchar(50),
age int
);

create table meal (
id int auto_increment primary key,
description varchar(50),
meal_date datetime,
animal_id int not null,
foreign key (animal_id) references animal(id) on delete cascade
);

create table fleuriste (
id int auto_increment primary key,
name varchar(50)
);

create table commande_fleuriste (
id int auto_increment primary key,
id_commande int not null,
id_fleuriste int not null,
foreign key (id_commande) references commande(id) on delete cascade,
foreign key (id_fleuriste) references fleuriste(id) on delete cascade
);

SELECT * FROM commande AS c INNER JOIN commande_fleuriste as cf ON cf.id_commande = c.id WHERE cf.id_fleuriste = 1;

create table enclos (
id int primary key auto_increment,
name varchar(50)
);

create table enclos_animal (
id int auto_increment primary key,
id_enclos int not null,
id_animal int not null,
foreign key (id_enclos) references enclos(id) on delete cascade,
foreign key (id_animal) references animal(id) on delete cascade
);
