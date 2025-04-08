package test;

import model.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class CommerceTest {

    public static void runTest() {
        System.out.println("\n=== TEST COMMERCE ===");

        // 1. Création d'un commerce
        Commerce commerce = new Commerce("ShopEtwally");
        System.out.println("Nom du commerce : " + commerce.getNom());

        // 2. Création d'un contrat de partenariat
        List<CategorieProduit> categories = new ArrayList<>();
        categories.add(new CategorieProduit("Hygiène", 10));
        categories.add(new CategorieProduit("Maison", 8));
        Date dateDebut = new Date();
        Date dateFin = new Date(dateDebut.getTime() + 1000L * 60 * 60 * 24 * 30 * 6); // +6 mois
        ContratPartenariat contrat = new ContratPartenariat(dateDebut, dateFin, categories);

        // 3. Association du contrat au commerce
        commerce.setContrat(contrat);

        // 4. Vérification des conditions du contrat
        boolean valide = commerce.VerifierConditionsContrat(contrat);
        System.out.println("Contrat valide ? " + (valide ? "✅" : "❌"));

        // 5. Création d'un utilisateur et de produits
        Utilisateur client = new Utilisateur("Ahmed");
        client.AjouterPoints(100);
        Produit p = new Produit("éponge réutilisable", 60);

        // 6. Création d'une commande
        BonDeCommande commande = new BonDeCommande(client, commerce);
        commande.ajouterProduit(p);

        // 7. Traitement de la commande
        commerce.AccepterCommande(commande);

        // 8. Affichage des commandes
        System.out.println("Commandes du commerce :");
        for (BonDeCommande c : commerce.getCommandes()) {
            System.out.println(c);
        }

        System.out.println("Points restants utilisateur : " + client.GetPtsFidelite());
        System.out.println("=== FIN TEST COMMERCE ===");
    }
}
