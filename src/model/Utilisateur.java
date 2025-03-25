package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilisateur {

    private static int compteurId = 1;

    private int id;
    private String nom;
    private int PtsFidelite;
    private int CodeAcces;
    private List<Produit> ProduitsAchetes;
    private List<Depot> historiqueDepots;

    public Utilisateur(String nom) {
        this.id = compteurId++;
        this.nom = nom;
        this.PtsFidelite = 0;
        this.CodeAcces = genererCodeAcces();
        this.ProduitsAchetes = new ArrayList<>();
        this.historiqueDepots = new ArrayList<>();
    }

    private int genererCodeAcces() {
        return new Random().nextInt(900000) + 100000;
    }

    public void DeposerDechets(Poubelle poubelle, NatureDechet type, int quantite) {
        boolean conforme = poubelle.verifierTypeDechets(type);
        double poids = type.getPoidsUnitaire() * quantite;
        int points = (int) poids;
        if (!conforme) points *= -1;
    
        Depot depot = new Depot(this, poubelle, type, quantite, points);
        historiqueDepots.add(depot);
        poubelle.ajouterDechets(depot);
    
        if (points >= 0) {
            AjouterPoints(points);
        } else {
            RetirerPoints(-points);
        }
    }
    

	public void ConsulterHistorique() {
	    System.out.println("Historique des dépôts de " + nom + " :");
	    if (historiqueDepots.isEmpty()) {
	        System.out.println("cette personne n'a fait aucun depot ");
	    } else {
	        for (Depot d : historiqueDepots) {
	            System.out.println(" - " + d);
	        }
	    }
	}
	
	public void ConvertirPoint() {
	    if (PtsFidelite >= 100) {
	        System.out.println("100 points convertis en bon d'achat de 10€");
	        RetirerPoints(100);
	    } else {
	        System.out.println("pas assez de points pour convertir :/");
	    }
	}


    public boolean AcheterProduits(Produit p) {
        if (PtsFidelite >= p.getPrixEnPoints()) {
            PtsFidelite -= p.getPrixEnPoints();
            ProduitsAchetes.add(p);
            return true;
        } else {
            System.out.println("Pas assez de points pour acheter : " + p.getNom());
            return false;
        }
    }

    // Getter
    public int GetCodeAcces() {
        return CodeAcces;
    }

    public int getId(){
        return id;
    }

    public List<Produit> GetListProduits() {
        return ProduitsAchetes;
    }

    public String GetNom() {
        return nom;
    }

    public int GetPtsFidelite() {
        return PtsFidelite;
    }

    public void AjouterPoints(int points) {
        PtsFidelite += points;
    }

    public void RetirerPoints(int points) {
        PtsFidelite -= points;
        if (PtsFidelite < 0) PtsFidelite = 0;
    }
} 
