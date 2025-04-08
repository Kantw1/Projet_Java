package test;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("==== LANCEMENT DES TESTS DU SYSTÈME ====");

        System.out.println("\nTest Utilisateur");
        UtilisateurTest.runTest();

        System.out.println("\nTest Produit");
        ProduitTest.runTest();

        System.out.println("\nTest CatégorieProduit");
        CategorieProduitTest.runTest();

        System.out.println("\nTest Dépôt");
        DepotTest.runTest();

        System.out.println("\nTest Poubelle");
        PoubelleTest.runTest();

        System.out.println("\nTest BonDeCommande");
        BonDeCommandeTest.runTest();

        System.out.println("\nTest Commerce");
        CommerceTest.runTest();

        System.out.println("\nTest Centre de Tri");
        CentreDeTriTest.runTest();

        System.out.println("\n==== FIN DES TESTS ====");
    }
}
