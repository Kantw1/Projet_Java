package test;

import model.*;

public class UtilisateurTest {

    public static void runTest() {
        System.out.println("=== TEST COMPLET : UTILISATEUR ===");

        // Création de l'utilisateur
        Utilisateur u = new Utilisateur("Louane");
        System.out.println("👤 Utilisateur : " + u.GetNom() + " | Code accès : " + u.GetCodeAcces());

        // Ajout de points
        u.AjouterPoints(120);
        System.out.println("Points ajoutés : 120 | Total : " + u.GetPtsFidelite());

        // Création de produits
        Produit p1 = new Produit("Sandwich Jambon non comestible", 50);
        Produit p2 = new Produit("Crypto Ecolo", 80);

        // Achat de produit
        boolean achat1 = u.AcheterProduits(p1);
        boolean achat2 = u.AcheterProduits(p2); // devrait échouer car pas assez de point

        System.out.println("Achat 1 (" + p1.getNom() + ") : " + (achat1 ? "✅" : "❌"));
        System.out.println("Achat 2 (" + p2.getNom() + ") : " + (achat2 ? "✅" : "❌"));
        System.out.println("Points restants : " + u.GetPtsFidelite());

        // Création de poubelle jaun
        Poubelle poubelleJaune = new Poubelle(200, "Rue des Lilas", "JAUNE");

        // Dépôt conforme 
        u.DeposerDechets(poubelleJaune, NatureDechet.PLASTIQUE, 5); // 5 quantits de plastique

        // Dépôt non conform
        u.DeposerDechets(poubelleJaune, NatureDechet.VERRE, 2); // devrait retirer des points

        // affichage de l'historique
        System.out.println("\nHistorique de dépôts :");
        u.ConsulterHistorique();

        // fin
        System.out.println("\nRésumé :");
        System.out.println("Points fidélité finaux : " + u.GetPtsFidelite());
        System.out.println("Produits achetés : " + u.GetListProduits());
        System.out.println("=== FIN TEST UTILISATEUR ===");
    }
} 
