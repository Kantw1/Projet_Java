package test;

import model.*;

public class UtilisateurTest {

    public static void runTest() {
        System.out.println("\uD83E\uDDEA=== TEST COMPLET : UTILISATEUR ===");

        // Création de l'utilisateur
        Utilisateur u = new Utilisateur("Alice");
        System.out.println("👤 Utilisateur : " + u.GetNom() + " | Code accès : " + u.GetCodeAcces());

        // Ajout de points
        u.AjouterPoints(120);
        System.out.println("🎁 Points ajoutés : 120 | Total : " + u.GetPtsFidelite());

        // Création de produits
        Produit p1 = new Produit("Brosse en bambou", 50);
        Produit p2 = new Produit("Savon solide", 80);

        // Achat de produit
        boolean achat1 = u.AcheterProduits(p1);
        boolean achat2 = u.AcheterProduits(p2); // devrait échouer (manque de points)

        System.out.println("🛒 Achat 1 (" + p1.getNom() + ") : " + (achat1 ? "✅" : "❌"));
        System.out.println("🛒 Achat 2 (" + p2.getNom() + ") : " + (achat2 ? "✅" : "❌"));
        System.out.println("🎯 Points restants : " + u.GetPtsFidelite());

        // Création d'une poubelle
        Poubelle poubelleJaune = new Poubelle(200, "Rue des Lilas", "JAUNE");

        // Dépôt conforme (plastique dans poubelle jaune)
        u.DeposerDechets(poubelleJaune, NatureDechet.PLASTIQUE, 5); // 5 quantits de plastique

        // Dépôt non conforme (verre dans poubelle jaune)
        u.DeposerDechets(poubelleJaune, NatureDechet.VERRE, 2); // devrait retirer des points

        // Affichage de l'historique
        System.out.println("\n📜 Historique de dépôts :");
        u.ConsulterHistorique();

        // Résumé final
        System.out.println("\n📊 Résumé :");
        System.out.println("Points fidélité finaux : " + u.GetPtsFidelite());
        System.out.println("Produits achetés : " + u.GetListProduits());
        System.out.println("=== ✅ FIN TEST UTILISATEUR ===");
    }
} 