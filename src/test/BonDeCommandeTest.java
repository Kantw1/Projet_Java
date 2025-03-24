package test;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class BonDeCommandeTest {

    public static void runTest() {
        System.out.println("=== TEST BON DE COMMANDE ===");

        //1on crée un utilisateur avec des points
        Utilisateur client = new Utilisateur("Ahmed");
        client.AjouterPoints(150);
        System.out.println("Utilisateur : " + client.GetNom() + " | Points : " + client.GetPtsFidelite());

        // 2 on  Créer des produits pour les associes avec l''utilisateur
        Produit p1 = new Produit("Macbook 2013", 50);
        Produit p2 = new Produit("Chaussures tres belle", 80);

        List<Produit> produitsCommandes = new ArrayList<>();
        produitsCommandes.add(p1);
        produitsCommandes.add(p2);


        // on crée un commerce
        Commerce commerce = new Commerce("AhmedMarché");

        // le bon de commande
        BonDeCommande commande = new BonDeCommande(client, commerce);
        commande.ajouterProduit(p1);
        commande.ajouterProduit(p2);

        // 5. Vérification avant validation
        System.out.println("Montant total : " + commande.getMontantTotal() + " pts");
        System.out.println("es ce que les soldes sont suffisant ? " + commande.verifierSoldeUtilisateur());

        // 6. Valider la commande
        if (commande.validerCommande()) {
            System.out.println("commande validée");
            System.out.println("Points restants : " + client.GetPtsFidelite());
        } else {
            System.out.println("Commande refusée (solde insuffisant)");
        }

        System.out.println("État de la commande : (validee, attente, etc...)" + commande.getEtatCommande());
        System.out.println("Date : " + commande.getDateCommande());
        System.out.println("Fin test BonDeCommande\n");
    }
}
