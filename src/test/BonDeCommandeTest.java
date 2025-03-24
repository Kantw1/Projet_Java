package test;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class BonDeCommandeTest {

    public static void runTest() {
        System.out.println("🧪=== TEST BON DE COMMANDE ===");

        // 1. Créer un utilisateur avec des points
        Utilisateur client = new Utilisateur("Nina");
        client.AjouterPoints(150);
        System.out.println("👤 Utilisateur : " + client.GetNom() + " | Points : " + client.GetPtsFidelite());

        // 2. Créer des produits
        Produit p1 = new Produit("Brosse bambou", 50);
        Produit p2 = new Produit("Gourde inox", 80);

        List<Produit> produitsCommandes = new ArrayList<>();
        produitsCommandes.add(p1);
        produitsCommandes.add(p2);


        // 3. Créer un commerce (partenariat fictif ici)
        Commerce commerce = new Commerce("EcoShop");

        // 4. Créer le bon de commande
        BonDeCommande commande = new BonDeCommande(client, commerce);
        commande.ajouterProduit(p1);
        commande.ajouterProduit(p2);

        // 5. Vérification avant validation
        System.out.println("🛒 Montant total : " + commande.getMontantTotal() + " pts");
        System.out.println("💰 Solde suffisant ? " + commande.verifierSoldeUtilisateur());

        // 6. Valider la commande
        if (commande.validerCommande()) {
            System.out.println("✅ Commande validée !");
            System.out.println("🎯 Points restants : " + client.GetPtsFidelite());
        } else {
            System.out.println("❌ Commande refusée (solde insuffisant)");
        }

        System.out.println("📦 État de la commande : " + commande.getEtatCommande());
        System.out.println("📅 Date : " + commande.getDateCommande());
        System.out.println("✅ Fin test BonDeCommande\n");
    }
}
