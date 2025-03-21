package model;

import java.util.ArrayList;
import java.util.List;

public class Commerce {
    private String nom;
    private List<String> categoriesProduits;

    public Commerce(String nom) {
        this.nom = nom;
        this.categoriesProduits = new ArrayList<>();
    }

    public void echangerPoints(Utilisateur utilisateur) {
        System.out.println("Points échangés contre des produits.");
    }
}