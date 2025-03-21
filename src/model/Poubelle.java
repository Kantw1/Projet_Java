package model;

import java.util.ArrayList;
import java.util.List;

public class Poubelle {
	private int id;
	private int capaciteMax;
	private String emplacement;
	private List<Dechet> contenu;

 public Poubelle(int id, int capaciteMax, String emplacement) {
     this.id = id;
     this.capaciteMax = capaciteMax;
     this.emplacement = emplacement;
     this.contenu = new ArrayList<>();
 }

 public void identifierUtilisateur(Utilisateur utilisateur) {
     System.out.println("Utilisateur identifié: " + utilisateur.getNom());
 }

 public void calculerQuantiteDechets() {
     int total = contenu.size();
     System.out.println("Quantité de déchets dans la poubelle: " + total);
 }

 public void verifierCategorieDechets() {
     // Logique de vérification des catégories
 }

 public void attribuerPoint(Utilisateur utilisateur) {
     utilisateur.ajouterPoints(10);
 }

 public void notifierCentreTri() {
     System.out.println("Notification envoyée au centre de tri: Poubelle pleine.");
 }
}