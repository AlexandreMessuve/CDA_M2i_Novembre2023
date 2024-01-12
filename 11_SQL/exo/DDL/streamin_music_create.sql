-- création base de données
CREATE DATABASE IF NOT EXISTS stream_music;

-- utilisation  de la base de données
USE stream_music;

-- suppression des tables si ils existent
DROP TABLE IF EXISTS Songs_Playlists;
DROP TABLE IF EXISTS Playlists;
DROP TABLE IF EXISTS Songs;
DROP TABLE IF EXISTS Users;

-- création des tables
CREATE TABLE Users (
	id_users INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at DATE NOT NULL,
    country VARCHAR(50) NOT NULL
	);

CREATE TABLE Songs (
	id_songs INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    artist VARCHAR(50) NOT NULL,
    album VARCHAR(50) NOT NULL,
    duration TIME NOT NULL,
    genre VARCHAR(50) NOT NULL,
    release_year YEAR NOT NULL
    );

CREATE TABLE Playlists (
	id_playlists INT AUTO_INCREMENT PRIMARY KEY,
    id_users INT,
    playlists_name VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    FOREIGN KEY (id_users)
		REFERENCES Users(id_users)
    );

CREATE TABLE Songs_Playlists (
	id_songs INT,
    id_playlists INT,
	PRIMARY KEY ( id_songs, id_playlists),
    CONSTRAINT Const_Songs_fk
		FOREIGN KEY (id_songs)
			REFERENCES Songs(id_songs),
	CONSTRAINT Const_Playlists_fk
		FOREIGN KEY (id_playlists)
			REFERENCES Playlists(id_playlists),
	INDEX (id_songs),
    INDEX (id_playlists)
    );



