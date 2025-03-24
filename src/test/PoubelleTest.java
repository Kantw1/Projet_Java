package test;

import model.*;

public class PoubelleTest {

    public static void runTest() {
        System.out.println("🧪=== TEST POUBELLE ===");

        // Création d'un utilisateur
        Utilisateur u = new Utilisateur("Bob");

        // Création d'une poubelle JAUNE
        Poubelle p = new Poubelle(10, "Avenue Verte", "JAUNE");
        System.out.println("🗑️ Poubelle créée : ID " + p.getId() + ", type : " + p.getTypePoubelle());

        // Vérification accès utilisateur
        System.out.println("🔐 Accès autorisé ? " + p.verifierAcces(u));

        // Vérifier conformité de plusieurs déchets
        System.out.println("✔️ Conformité PLASTIQUE ? " + p.verifierTypeDechets(NatureDechet.PLASTIQUE)); // true
        System.out.println("❌ Conformité VERRE ? " + p.verifierTypeDechets(NatureDechet.VERRE));         // false

        // Dépôt conforme (plastique)
        Depot d1 = new Depot(u, p, NatureDechet.PLASTIQUE, 2, 3);;
        p.ajouterDechets(d1);

        // Dépôt non conforme (verre)
        Depot d2 = new Depot(u, p, NatureDechet.VERRE, 1, -2);
        p.ajouterDechets(d2);

        // Test du calcul total
        System.out.println("📦 Quantité totale déposée : " + p.calculerQuantiteDechets());

        // Attribution des points (simulation manuelle)
        int points1 = p.attribuerPoint(NatureDechet.PLASTIQUE, 5.0);
        int points2 = p.attribuerPoint(NatureDechet.VERRE, 3.0);
        System.out.println("🎯 Points attribués (PLASTIQUE) : " + points1);
        System.out.println("❌ Points attribués (VERRE) : " + points2);

        // Déborder la capacité (ajouter encore un dépôt)
        Depot d3 = new Depot(u, p, NatureDechet.PLASTIQUE, 10, 5);
        p.ajouterDechets(d3); // ➜ devrait déclencher notification

        // Affichage final
        System.out.println("🧾 Dépôts dans la poubelle :");
        for (Depot d : p.getDepots()) {
            System.out.println(" - " + d);
        }

        System.out.println("✅ Fin test Poubelle\n");
    }
}

