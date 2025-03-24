package model;

import java.util.ArrayList;
import java.util.List;

public class CategorieProduit {

    private static int compteurId = 1;

    private int id;
    private String nom;
    private int tauxConversion;
    private List<Produit> produits;

    public CategorieProduit(String nom, int tauxConversion) {
        this.id = compteurId++;
        this.nom = nom;
        this.tauxConversion = tauxConversion;
        this.produits = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getTauxConversion() {
        return tauxConversion;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    // Associe un produit à cette catégorie (et réciproquement)
    public void associerProduit(Produit p) {
        if (!produits.contains(p)) {
            produits.add(p);
            p.assignCategorie(this);
        }
    }

    // Vérifie si un produit appartient à cette catégorie
    public boolean verifierProduit(Produit p) {
        return produits.contains(p);
    }

    @Override
    public String toString() {
        return nom + " (conversion: " + tauxConversion + " pts)";
    }
}
