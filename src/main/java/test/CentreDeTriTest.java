package test;

import model.*;

public class CentreDeTriTest {

    public static void runTest() {
        System.out.println("\n=== TEST : CENTRE DE TRI ===");

        // Création du centre de tri
        CentreDeTri centre = new CentreDeTri("Centre Nord", "1 rue de EISTI Cergy");
        System.out.println("📍 Centre : " + centre.getNom() + " | Adresse : " + centre.getAdresse());

        // Ajout de poubelles
        Poubelle p1 = new Poubelle(100, "Rue A", "VERTE");
        Poubelle p2 = new Poubelle(150, "Rue B", "JAUNE");
        centre.gererPoubelle(p1, true);
        centre.gererPoubelle(p2, true);

        // Ajout de commerce
        Commerce c1 = new Commerce("AhmedMarché");
        Commerce c2 = new Commerce("EcoQuentin");
        centre.getCommerce().add(c1);
        centre.getCommerce().add(c2);

        // Simuler dépôts
        Utilisateur u = new Utilisateur("Capucine");
        u.AjouterPoints(20);
        u.DeposerDechets(p1, NatureDechet.VERRE, 10);
        u.DeposerDechets(p2, NatureDechet.PLASTIQUE, 4);

        // Collecte des déchets
        centre.collecterDechets();

        // Statistiques
        centre.genererStatistiques();

        // Traitement des rejets
        centre.traiterRejet();

        System.out.println("=== FIN TEST CENTRE DE TRI ===\n");
    }
}
