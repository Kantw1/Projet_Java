package model;

import java.util.ArrayList;
import java.util.List;

public class Commerce {

    private String nom;
    private List<String> CategoriesProduits;
    private List<BonDeCommande> commandes;
    private ContratPartenariat contrat;

    public Commerce(String nom) {
        this.nom = nom;
        this.CategoriesProduits = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    public void EchangerPoints() {
        System.out.println("💱 Points échangés contre des produits ou avantages.");
    }

    public List<String> GetCategoriesProduits() {
        return CategoriesProduits;
    }

    public boolean VerifierConditionsContrat(ContratPartenariat contrat) {
        // Logique basique : comparer la date ou les catégories concernées
        return contrat != null && !contrat.GetCategorie().isEmpty();
    }

    public void AccepterCommande(BonDeCommande commande) {
        if (commande != null && commande.validerCommande()) {
            commandes.add(commande);
            System.out.println("✅ Commande acceptée par le commerce : " + nom);
        } else {
            System.out.println("❌ Commande refusée par le commerce : " + nom);
        }
    }

    // Getters 
    public String getNom() {
        return nom;
    }

    public List<BonDeCommande> getCommandes() {
        return commandes;
    }

    public ContratPartenariat getContrat() {
        return contrat;
    }

    public void setContrat(ContratPartenariat contrat) {
        this.contrat = contrat;
    }
} 
