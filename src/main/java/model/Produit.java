package model;

import java.util.ArrayList;
import java.util.List;

public class Produit {

    private static int compteurId = 1;

    private int id;
    private String nom;
    private int pointsNecessaires;
    private List<CategorieProduit> categories;

    public Produit(String nom, int pointsNecessaires) {
        this.id = compteurId++;
        this.nom = nom;
        this.pointsNecessaires = pointsNecessaires;
        this.categories = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getPrixEnPoints() {
        return pointsNecessaires;
    }

    public List<CategorieProduit> getCategories() {
        return categories;
    }

    // Associer une catégorie à un produit
    public void assignCategorie(CategorieProduit categorie) {
        if (!categories.contains(categorie)) {
            categories.add(categorie);
        }
    }

    // Méthode pour lister les infos
    public static void listerProduitsDisponibles(List<Produit> produits) {
        System.out.println("Produits disponibles :");
        for (Produit p : produits) {
            System.out.println("- " + p.nom + " | " + p.pointsNecessaires + " points");
        }
    }

    @Override
    public String toString() {
        return nom + " (" + pointsNecessaires + " pts)";
    }
}
