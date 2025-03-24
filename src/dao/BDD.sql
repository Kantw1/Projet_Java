CREATE TABLE Poubelle (
    id INT PRIMARY KEY,
    CapaciteMax INT,
    Emplacement VARCHAR(255),
    TypePoubelle VARCHAR(255),
    QuantiteActuelle INT
);

CREATE TABLE Depot (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Type VARCHAR(255),
    Classe VARCHAR(255),
    Quantite INT,
    HeureDepot DATETIME,
    Points INT
);

CREATE TABLE Utilisateur (
    id INT PRIMARY KEY,
    Nom VARCHAR(255),
    ProfilEco INT,
    CodeAcces INT
);

CREATE TABLE Produit (
    id INT PRIMARY KEY,
    Nom VARCHAR(255),
    PointsNecessaires INT
);

CREATE TABLE CategorieProduit (
    id INT PRIMARY KEY,
    Nom VARCHAR(255),
    tauxConversion INT
);

CREATE TABLE ProduitCategorie (
    ProduitID INT,
    CategorieID INT,
    PRIMARY KEY (ProduitID, CategorieID),
    FOREIGN KEY (ProduitID) REFERENCES Produit(id),
    FOREIGN KEY (CategorieID) REFERENCES CategorieProduit(id)
);

CREATE TABLE BonDeCommande (
    id INT PRIMARY KEY,
    UtilisateurID INT,
    MontantTotal DOUBLE,
    EtatCommande VARCHAR(255),
    CommerceID INT,
    DateCommande DATE,
    FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id)
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

ALTER TABLE Depot ADD COLUMN PoubelleID INT, ADD FOREIGN KEY (PoubelleID) REFERENCES Poubelle(id);
ALTER TABLE BonDeCommande ADD COLUMN CommerceID INT, ADD FOREIGN KEY (CommerceID) REFERENCES Commerce(id);
ALTER TABLE Produit ADD COLUMN UtilisateurID INT, ADD FOREIGN KEY (UtilisateurID) REFERENCES Utilisateur(id);