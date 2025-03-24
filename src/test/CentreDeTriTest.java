package test;

import model.*;

public class CentreDeTriTest {

    public static void runTest() {
        System.out.println("\n\uD83E\uDDF9=== TEST : CENTRE DE TRI ===");

        // Création du centre de tri
        CentreDeTri centre = new CentreDeTri("Centre Nord", "12 rue des Fleurs");
        System.out.println("📍 Centre : " + centre.getNom() + " | Adresse : " + centre.getAdresse());

        // Ajout de poubelles
        Poubelle p1 = new Poubelle(100, "Rue A", "VERTE");
        Poubelle p2 = new Poubelle(150, "Rue B", "JAUNE");
        centre.gererPoubelle(p1, true);
        centre.gererPoubelle(p2, true);

        // Ajout de commerce
        Commerce c1 = new Commerce("BioShop");
        Commerce c2 = new Commerce("EcoMarket");
        centre.getCommerce().add(c1);
        centre.getCommerce().add(c2);

        // Simuler dépôts
        Utilisateur u = new Utilisateur("Lina");
        u.AjouterPoints(20); // pour éventuel test
        u.DeposerDechets(p1, NatureDechet.VERRE, 10);
        u.DeposerDechets(p2, NatureDechet.PLASTIQUE, 4);

        // Collecte des déchets
        centre.collecterDechets();

        // Statistiques
        centre.genererStatistiques();

        // Traitement des rejets (placeholder)
        centre.traiterRejet();

        System.out.println("=== ✅ FIN TEST CENTRE DE TRI ===\n");
    }
}
