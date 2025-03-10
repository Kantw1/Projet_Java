package gestionTri;

import java.util.ArrayList;
import java.util.List;

public class Corbeille {
    private List<Dechet> listeDechets;

    public Corbeille() {
        this.listeDechets = new ArrayList<>();
    }

    public void ajouterDechet(Dechet dechet) {
        listeDechets.add(dechet);
    }
}