CREATE DATABASE gestionProjets;



CREATE TABLE Comptes (
    compte_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    matriculeEMP INT,
    FOREIGN KEY (matriculeEMP) REFERENCES Employees(matricule)
);

CREATE TABLE Projets (
    projet_id INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(100),
    dateDebut DATE,
    dateFin DATE,
    MembresEquipe VARCHAR(100),
    etat varchar(100),
    project_manager_id INT,
    FOREIGN KEY (projet_manager_id) REFERENCES Comptes(compte_id)
);

CREATE TABLE Employees (
    matricule INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);






