package model;

import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {

    private String nom;
    private String adresse;
    private List<Poubelle> listePoubelle;
    private List<Commerce> listeCommerce;

    public CentreDeTri(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listePoubelle = new ArrayList<>();
        this.listeCommerce = new ArrayList<>();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Poubelle> getPoubelle() {
        return listePoubelle;
    }

    public List<Commerce> getCommerce() {
        return listeCommerce;
    }

    // Méthodes
    public void gererPoubelle(Poubelle p, boolean ajouter) {
        if (ajouter) {
            listePoubelle.add(p);
        } else {
            listePoubelle.remove(p);
        }
    }

    public void collecterDechets() {
        System.out.println("\nCollecte des déchets par le centre de tri :");
        for (Poubelle p : listePoubelle) {
            System.out.println(" - Poubelle " + p.getId() + " à " + p.getEmplacement() + ": " + p.getQuantiteActuelle() + " unités");
        }
    }

    public void genererStatistiques() {
        System.out.println("\nStatistiques du centre de tri :");
        int total = 0;
        for (Poubelle p : listePoubelle) {
            total += p.getQuantiteActuelle();
        }
        System.out.println(" - Total déchets collectés : " + total);
        System.out.println(" - Nombre de poubelles : " + listePoubelle.size());
        System.out.println(" - Nombre de commerces partenaires : " + listeCommerce.size());
    }

    public void traiterRejet() {
        System.out.println("a voir avec le prof si rajouter ou pas");
    }
}
