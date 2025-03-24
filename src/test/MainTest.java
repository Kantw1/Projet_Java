package test;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("🧪==== LANCEMENT DES TESTS DU SYSTÈME ====");

        System.out.println("\n🔹 Test Utilisateur");
        UtilisateurTest.runTest();

        System.out.println("\n🔹 Test Produit");
        ProduitTest.runTest();

        System.out.println("\n🔹 Test CatégorieProduit");
        CategorieProduitTest.runTest();

        System.out.println("\n🔹 Test Dépôt");
        DepotTest.runTest();

        System.out.println("\n🔹 Test Poubelle");
        PoubelleTest.runTest();

        System.out.println("\n🔹 Test BonDeCommande");
        BonDeCommandeTest.runTest();

        System.out.println("\n🔹 Test Commerce");
        CommerceTest.runTest();

        System.out.println("\n🔹 Test Centre de Tri");
        CentreDeTriTest.runTest();

        System.out.println("\n✅==== FIN DES TESTS ====");
    }
}
