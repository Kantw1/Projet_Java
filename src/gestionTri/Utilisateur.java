package gestionTri;

public class Utilisateur {
    private int id;
    private String nom;
    private int pointsFidelite;
    private Corbeille corbeille;

    public Utilisateur(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.pointsFidelite = 0;
        this.corbeille = new Corbeille();
    }

    public String getNom() {
        return nom;
    }

    public void deposerDechets(Poubelle poubelle) {
        poubelle.calculerQuantiteDechets();
    }

    public void ajouterPoints(int points) {
        this.pointsFidelite += points;
    }
}