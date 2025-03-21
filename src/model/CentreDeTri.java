package model;

import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {
    private String nom;
    private String adresse;
    private List<Poubelle> poubelles;

    public CentreDeTri(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.poubelles = new ArrayList<>();
    }

    public void placerPoubelle(Poubelle poubelle) {
        poubelles.add(poubelle);
    }

    public void collecterDechets() {
        System.out.println("Collecte des déchets effectuée.");
    }
}