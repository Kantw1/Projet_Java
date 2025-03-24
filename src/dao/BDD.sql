CREATE DATABASE BDD;
USE BDD;

CREATE TABLE Poubelle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    CapaciteMax INT,
    Emplacement VARCHAR(255),
    TypePoubelle VARCHAR(255),
    QuantiteActuelle INT
);

CREATE TABLE Depot (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Type VARCHAR(255),
    Poids VARCHAR(255),
    Quantite INT,
    HeureDepot DATETIME,
    Points INT,
    PoubelleID INT,
    UtilisateurID INT,
    FOREIGN KEY (PoubelleID) REFERENCES Poubelle(id),
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id)
);


CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    ProfilEco INT,
    CodeAcces INT
);


CREATE TABLE Produit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    PointsNecessaires INT
);


CREATE TABLE CategorieProduit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    TauxConversion INT
);


CREATE TABLE ProduitCategorie (
    ProduitID INT,
    CategorieID INT,
    PRIMARY KEY (ProduitID, CategorieID),
    FOREIGN KEY (ProduitID) REFERENCES Produit(id),
    FOREIGN KEY (CategorieID) REFERENCES CategorieProduit(id)
);


CREATE TABLE BonDeCommande (
    id INT PRIMARY KEY AUTO_INCREMENT,
    UtilisateurID INT,
    MontantTotal DOUBLE,
    EtatCommande VARCHAR(255),
    DateCommande DATE,
    CommerceID INT,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id),
    FOREIGN KEY (CommerceID) REFERENCES Commerce(id)
);


CREATE TABLE Commerce (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    ContratID INT,
    FOREIGN KEY (ContratID) REFERENCES ContratPartenariat(id)
);


CREATE TABLE ContratPartenariat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    DateDebut DATE,
    DateFin DATE
);


CREATE TABLE CentreDeTri (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Adresse VARCHAR(255)
);


CREATE TABLE CommandeProduit (
    BonDeCommandeID INT,
    ProduitID INT,
    PRIMARY KEY (BonDeCommandeID, ProduitID),
    FOREIGN KEY (BonDeCommandeID) REFERENCES BonDeCommande(id),
    FOREIGN KEY (ProduitID) REFERENCES Produit(id)
);


CREATE TABLE CentrePoubelle (
    CentreID INT,
    PoubelleID INT,
    PRIMARY KEY (CentreID, PoubelleID),
    FOREIGN KEY (CentreID) REFERENCES CentreDeTri(id),
    FOREIGN KEY (PoubelleID) REFERENCES Poubelle(id)
);


CREATE TABLE CommerceCategorieProduit (
    CommerceID INT,
    CategorieID INT,
    PRIMARY KEY (CommerceID, CategorieID),
    FOREIGN KEY (CommerceID) REFERENCES Commerce(id),
    FOREIGN KEY (CategorieID) REFERENCES CategorieProduit(id)
);


CREATE TABLE HistoriqueDepot (
    UtilisateurID INT,
    DepotID INT,
    PRIMARY KEY (UtilisateurID, DepotID),
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id),
    FOREIGN KEY (DepotID) REFERENCES Depot(id)
);


