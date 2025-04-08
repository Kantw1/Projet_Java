package model;

import java.util.Date;

public class Depot {

    private Utilisateur utilisateur;
    private Poubelle poubelle;

    private NatureDechet type;
    private double poids;
    private int quantite;
    private Date heureDepot;
    private int points;

    public Depot(Utilisateur utilisateur, Poubelle poubelle, NatureDechet type, int quantite, int points) {
        this.utilisateur = utilisateur;
        this.poubelle = poubelle;
        this.type = type;
        this.quantite = quantite;
        this.poids = type.getPoidsUnitaire() * quantite;
        this.heureDepot = new Date();
        this.points = points;
    }

    // Getters
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Poubelle getPoubelle() {
        return poubelle;
    }

    public NatureDechet getType() {
        return type;
    }

    public double getPoids() {
        return poids;
    }

    public int getQuantite() {
        return quantite;
    }

    public Date getHeureDepot() {
        return heureDepot;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "utilisateur=" + utilisateur.GetNom() +
                ", poubelle=" + poubelle.getId() +
                ", type=" + type +
                ", poids=" + poids +
                ", quantite=" + quantite +
                ", heureDepot=" + heureDepot +
                ", points=" + points +
                '}';
    }
}
