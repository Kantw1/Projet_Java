package model;

import java.util.ArrayList;
import java.util.List;

public class Poubelle {

    private static int compteurId = 1;

    private int id;
    private int capaciteMax;
    private String emplacement;
    private String typePoubelle;
    private int quantiteActuelle;
    private List<Depot> depots;

    public Poubelle(int capaciteMax, String emplacement, String typePoubelle) {
        this.id = compteurId++;
        this.capaciteMax = capaciteMax;
        this.emplacement = emplacement;
        this.typePoubelle = typePoubelle.toUpperCase();
        this.quantiteActuelle = 0;
        this.depots = new ArrayList<>();
    }

    public void identifierUtilisateur(Utilisateur utilisateur) {
        System.out.println("Utilisateur identifié: " + utilisateur.GetNom());
    }

    public int calculerQuantiteDechets() {
        return this.quantiteActuelle;
    }

    public boolean verifierTypeDechets(NatureDechet type) {
        switch (typePoubelle) {
            case "VERTE":
                return type == NatureDechet.VERRE;
            case "JAUNE":
                return type == NatureDechet.PLASTIQUE || type == NatureDechet.CARTON || type == NatureDechet.METAL;
            case "BLEUE":
                return type == NatureDechet.PAPIER;
            case "CLASSIQUE":
                return true;
            default:
                return false;
        }
    }

    public int attribuerPoint(NatureDechet type, double poids) {
        return verifierTypeDechets(type) ? (int) poids : -(int) poids;
    }

    public void notifierCentreTri() {
        if (quantiteActuelle >= capaciteMax) {
            System.out.println("Poubelle " + id + " à " + emplacement + " est pleine !");
        }
    }

    public boolean verifierAcces(Utilisateur utilisateur) {
        return utilisateur.GetCodeAcces() > 0;
    }

    public void ajouterDechets(Depot depot) {
        int total = depot.getQuantite();
        this.quantiteActuelle += total;
        this.depots.add(depot);
        notifierCentreTri();
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public String getTypePoubelle() {
        return typePoubelle;
    }

    public int getQuantiteActuelle() {
        return quantiteActuelle;
    }

    public List<Depot> getDepots() {
        return depots;
    }
} 
