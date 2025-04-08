package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContratPartenariat {

    private Date DateDebut;
    private Date DateFin;
    private List<CategorieProduit> CategoriesConcernees;

    public ContratPartenariat(Date dateDebut, Date dateFin, List<CategorieProduit> categoriesConcernees) {
        this.DateDebut = dateDebut;
        this.DateFin = dateFin;
        this.CategoriesConcernees = new ArrayList<>(categoriesConcernees);
    }

    public void DefinirRegleUtilisation() {
        System.out.println("Règles d'utilisation du contrat définies.");
    }

    public List<CategorieProduit> GetCategorie() {
        return CategoriesConcernees;
    }

    // Ajout d'une catégorie concernée par le contrat
    public void ajouterCategorie(CategorieProduit categorie) {
        if (!CategoriesConcernees.contains(categorie)) {
            CategoriesConcernees.add(categorie);
        }
    }

    // Getters utiles
    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public List<CategorieProduit> getCategoriesConcernees() {
        return CategoriesConcernees;
    }
} 
