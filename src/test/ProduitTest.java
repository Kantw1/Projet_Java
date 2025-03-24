package test;

import model.CategorieProduit;
import model.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitTest {

    public static void runTest() {
        System.out.println("🧪=== TEST PRODUIT ===");

        // Création de produits
        Produit p1 = new Produit("Gourde inox", 100);
        Produit p2 = new Produit("Sac réutilisable", 50);

        // Vérification des infos
        System.out.println("🆕 Produit créé : " + p1.getNom() + " | ID : " + p1.getId() + " | Points : " + p1.getPrixEnPoints());
        System.out.println("🆕 Produit créé : " + p2.getNom() + " | ID : " + p2.getId() + " | Points : " + p2.getPrixEnPoints());

        // Création de catégories
        CategorieProduit cat1 = new CategorieProduit("Écologie", 100);
        CategorieProduit cat2 = new CategorieProduit("Zéro déchet", 50);

        // Association produit <-> catégorie
        p1.assignCategorie(cat1);
        p2.assignCategorie(cat2);
        p2.assignCategorie(cat1); // plusieurs catégories pour le même produit

        // Vérification
        System.out.println("📦 Catégories du produit '" + p1.getNom() + "' : ");
        for (CategorieProduit c : p1.getCategories()) {
            System.out.println(" - " + c.getNom());
        }

        System.out.println("📦 Catégories du produit '" + p2.getNom() + "' : ");
        for (CategorieProduit c : p2.getCategories()) {
            System.out.println(" - " + c.getNom());
        }

        // Lister tous les produits disponibles
        List<Produit> liste = new ArrayList<>();
        liste.add(p1);
        liste.add(p2);
        Produit.listerProduitsDisponibles(liste);

        System.out.println("✅ Fin test Produit\n");
    }
}
