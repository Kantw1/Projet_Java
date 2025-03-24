package test;

import model.CategorieProduit;
import model.Produit;

public class CategorieProduitTest {

    public static void runTest() {
        System.out.println("🧪=== TEST CATEGORIE PRODUIT ===");

        // Création de la catégorie
        CategorieProduit zeroDechet = new CategorieProduit("Zéro Déchet", 80);
        System.out.println("📁 Catégorie créée : " + zeroDechet.getNom() + " | Taux : " + zeroDechet.getTauxConversion());

        // Création de produits
        Produit p1 = new Produit("Brosse à dents en bambou", 90);
        Produit p2 = new Produit("Éponge lavable", 60);

        // Association
        zeroDechet.associerProduit(p1);
        zeroDechet.associerProduit(p2);

        // Vérification
        System.out.println("📦 Produits dans la catégorie '" + zeroDechet.getNom() + "' :");
        for (Produit p : zeroDechet.getProduits()) {
            System.out.println(" - " + p.getNom());
        }

        // Test de la méthode verifierProduit
        System.out.println("🔍 Vérification d'association :");
        System.out.println("Produit p1 associé ? " + zeroDechet.verifierProduit(p1)); // true
        System.out.println("Produit p2 associé ? " + zeroDechet.verifierProduit(p2)); // true
        Produit p3 = new Produit("Tasse en inox", 70);
        System.out.println("Produit p3 associé ? " + zeroDechet.verifierProduit(p3)); // false

        System.out.println("✅ Fin test CategorieProduit\n");
    }
}

