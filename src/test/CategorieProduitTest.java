package test;

import model.CategorieProduit;
import model.Produit;

public class CategorieProduitTest {

    public static void runTest() {
        System.out.println("=== TEST CATEGORIE PRODUIT ===");

        //création de la catégorie zero dechet pour verifier que la categorisation fonctionne
        CategorieProduit zeroDechet = new CategorieProduit("Zéro Déchet", 80);
        System.out.println("catégoerie créée : " + zeroDechet.getNom() + " | Taux : " + zeroDechet.getTauxConversion());

        //rcréation de produits
        Produit p1 = new Produit("brosse à dent recyclée", 90);
        Produit p2 = new Produit("éponge reutilisable", 60);

        //on associe les produit
        zeroDechet.associerProduit(p1);
        zeroDechet.associerProduit(p2);

        //on vérifie 
        System.out.println("Voici les Produits dans la catégorie '" + zeroDechet.getNom() + "' :");
        for (Produit p : zeroDechet.getProduits()) {
            System.out.println(" - " + p.getNom());
        }

        // on test la methode verifierProduit
        System.out.println("vérification d'association :");
        System.out.println("est ce qeue le produit p1 associé ? " + zeroDechet.verifierProduit(p1)); // true
        System.out.println("produit p2? " + zeroDechet.verifierProduit(p2)); // true
        Produit p3 = new Produit("tasse pour thé", 70);
        System.out.println("le produit p3? " + zeroDechet.verifierProduit(p3)); // false

        System.out.println("fin test categorieproduit, marche bien\n");
    }
}

