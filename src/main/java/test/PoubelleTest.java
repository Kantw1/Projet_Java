package test;

import model.*;

public class PoubelleTest {

    public static void runTest() {
        System.out.println("=== TEST POUBELLE ===");

        // Création d'un utilisateur
        Utilisateur u = new Utilisateur("Quentin");

        // Création d'une poubelle JAUNE
        Poubelle p = new Poubelle(10, "Cergy Pref", "JAUNE");
        System.out.println("Poubelle créée : ID " + p.getId() + ", type : " + p.getTypePoubelle());

        // Vérification accès utilisateur
        System.out.println("Accès autorisé ? " + p.verifierAcces(u));

        // Vérifier conformité de plusieurs déchets
        System.out.println("PLASTIQUE ? " + p.verifierTypeDechets(NatureDechet.PLASTIQUE)); // oui
        System.out.println("VERRE ? " + p.verifierTypeDechets(NatureDechet.VERRE));         // non normalement

        // Dépôt conforme : le 1er
        Depot d1 = new Depot(u, p, NatureDechet.PLASTIQUE, 2, 3);;
        p.ajouterDechets(d1);

        // Dépôt non conforme le 2e
        Depot d2 = new Depot(u, p, NatureDechet.VERRE, 1, -2);
        p.ajouterDechets(d2);

        // Test du calcul total
        System.out.println("Quantité totale déposée : " + p.calculerQuantiteDechets());

        // Attribution des points
        int points1 = p.attribuerPoint(NatureDechet.PLASTIQUE, 5.0);
        int points2 = p.attribuerPoint(NatureDechet.VERRE, 3.0);
        System.out.println("Points attribués (PLASTIQUE) : " + points1);
        System.out.println("Points attribués (VERRE) : " + points2);

        // on ajoute un depot qui normalement declenchera la notif
        Depot d3 = new Depot(u, p, NatureDechet.PLASTIQUE, 10, 5);
        p.ajouterDechets(d3); // devrait déclencher notification

        // affichage final
        System.out.println("🧾 Dépôts dans la poubelle :");
        for (Depot d : p.getDepots()) {
            System.out.println(" - " + d);
        }

        System.out.println("Fin test Poubelle\n");
    }
}

