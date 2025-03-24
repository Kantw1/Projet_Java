package test;

import model.*;

public class DepotTest {

    public static void runTest() {
        System.out.println("🧪=== TEST DEPOT ===");

        // Création d'un utilisateur
        Utilisateur u = new Utilisateur("Léna");

        // Création d'une poubelle BLEUE (pour PAPIER)
        Poubelle p = new Poubelle(5, "Rue du Recyclage", "BLEUE");

        // Dépôt conforme : PAPIER dans poubelle BLEUE
        Depot depot1 = new Depot(u, p, NatureDechet.PAPIER, 3, 1);  // 3 feuilles, poids = 3 * 0.1 = 0.3 ➜ 0 point

        // Dépôt non conforme : PLASTIQUE dans poubelle BLEUE
        Depot depot2 = new Depot(u, p, NatureDechet.PLASTIQUE, 2, -1);  // poids = 2 * 0.3 ➜ 0.6 ➜ -0.6 ➜ -1 point

        // Affichage des infos du dépôt 1
        System.out.println("📦 Dépôt 1 :");
        System.out.println(" - Type : " + depot1.getType());
        System.out.println(" - Quantité : " + depot1.getQuantite());
        System.out.println(" - Poids : " + depot1.getPoids());
        System.out.println(" - Points : " + depot1.getPoints());
        System.out.println(" - Heure : " + depot1.getHeureDepot());

        // Affichage des infos du dépôt 2
        System.out.println("\n🚫 Dépôt 2 :");
        System.out.println(" - Type : " + depot2.getType());
        System.out.println(" - Quantité : " + depot2.getQuantite());
        System.out.println(" - Poids : " + depot2.getPoids());
        System.out.println(" - Points : " + depot2.getPoints());
        System.out.println(" - Heure : " + depot2.getHeureDepot());

        System.out.println("✅ Fin test Depot\n");
    }
}
