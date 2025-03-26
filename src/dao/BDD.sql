CREATE DATABASE IF NOT EXISTS BDD;
USE BDD;

-- Table de base
CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    PtsFidelite INT,
    CodeAcces INT
);

CREATE TABLE CentreDeTri (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    Adresse VARCHAR(255)
);

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
    Poids FLOAT,
    Quantite INT,
    HeureDepot DATETIME,
    Points INT,
    PoubelleID INT,
    UtilisateurID INT,
    FOREIGN KEY (PoubelleID) REFERENCES Poubelle(id),
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id)
);

CREATE TABLE CategorieProduit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    TauxConversion INT,
    PtsNecessaire INT
);

CREATE TABLE ProduitCategorie (
	id INT,
    Produit VARCHAR(255),
    CategorieID INT,
    PRIMARY KEY (id, CategorieID),
    FOREIGN KEY (CategorieID) REFERENCES CategorieProduit(id)
);

CREATE TABLE Commerce (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Nom VARCHAR(255),
    ContratID INT,
    CategorieProduitID INT,
    FOREIGN KEY (CategorieProduitID) REFERENCES CategorieProduit(id)
);

CREATE TABLE ContratPartenariat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    CommerceID INT,
    CentreDeTriID INT,
    DateDebut DATE,
    DateFin DATE,
    FOREIGN KEY (CentreDeTriID) REFERENCES CentreDeTri(id),
    FOREIGN KEY (CommerceID) REFERENCES Commerce(id)
);

-- Mise à jour du lien Commerce ← Contrat après la création du contrat
ALTER TABLE Commerce
    ADD CONSTRAINT fk_contrat
    FOREIGN KEY (ContratID) REFERENCES ContratPartenariat(id);

CREATE TABLE BonDeCommande (
    id INT PRIMARY KEY AUTO_INCREMENT,
    UtilisateurID INT,
    EtatCommande VARCHAR(255),
    DateCommande DATE,
    CommerceID INT,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id),
    FOREIGN KEY (CommerceID) REFERENCES Commerce(id)
);

CREATE TABLE CommandeCategorieProduit (
    BonDeCommandeID INT,
    CategorieProduitID INT,
    PRIMARY KEY (BonDeCommandeID, CategorieProduitID),
    FOREIGN KEY (BonDeCommandeID) REFERENCES BonDeCommande(id),
    FOREIGN KEY (CategorieProduitID) REFERENCES CategorieProduit(id)
);

CREATE TABLE CentrePoubelle (
    CentreID INT,
    PoubelleID INT,
    PRIMARY KEY (CentreID, PoubelleID),
    FOREIGN KEY (CentreID) REFERENCES CentreDeTri(id),
    FOREIGN KEY (PoubelleID) REFERENCES Poubelle(id)
);

CREATE TABLE CentreCommerce (
    CentreID INT,
    CommerceID INT,
    PRIMARY KEY (CentreID, CommerceID),
    FOREIGN KEY (CentreID) REFERENCES CentreDeTri(id),
    FOREIGN KEY (CommerceID) REFERENCES Commerce(id)
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
