package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BonDeCommande {

    private static int compteurId = 1;

    private int id;
    private Utilisateur utilisateur;
    private List<Produit> produits;
    private double montantTotal;
    private String etatCommande;
    private Commerce commerce;
    private LocalDate dateCommande;

    public BonDeCommande(Utilisateur utilisateur, Commerce commerce) {
        this.id = compteurId++;
        this.utilisateur = utilisateur;
        this.commerce = commerce;
        this.produits = new ArrayList<>();
        this.etatCommande = "EN_ATTENTE";
        this.dateCommande = LocalDate.now();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        montantTotal += produit.getPrixEnPoints();
    }

    public boolean verifierSoldeUtilisateur() {
        return utilisateur.GetPtsFidelite() >= montantTotal;
    }

    public boolean utiliserPoints() {
        if (verifierSoldeUtilisateur()) {
            utilisateur.RetirerPoints((int) montantTotal);
            return true;
        }
        return false;
    }

    public boolean validerCommande() {
        if (utiliserPoints()) {
            etatCommande = "VALIDÉE";
            for (Produit p : produits) {
                utilisateur.AcheterProduits(p);
            }
            return true;
        } else {
            etatCommande = "REFUSÉE";
            return false;
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    @Override
    public String toString() {
        return "BonDeCommande #" + id +
                " | Utilisateur : " + utilisateur.GetNom() +
                " | Montant : " + montantTotal +
                " pts | État : " + etatCommande;
    }
}

