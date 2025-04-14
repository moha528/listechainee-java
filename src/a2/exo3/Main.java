package a2.exo3;

/**
 * Classe Main pour tester la classe GrandInt de manière exhaustive.
 * Cette classe contient le point d'entrée de l'application et permet
 * de vérifier le bon fonctionnement des différentes méthodes de GrandInt.
 */
public class Main {
    /**
     * Point d'entrée de l'application pour tester la classe GrandInt.
     *
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        System.out.println("===== Test de la classe GrandInt =====");

        // Test du constructeur avec différents entiers
        testConstructeurInt(0);
        testConstructeurInt(9);
        testConstructeurInt(123);
        testConstructeurInt(9876543);
        testConstructeurInt(Integer.MAX_VALUE); // Test avec le plus grand entier Java standard

        // Test de grand nombre en utilisant le constructeur pour concaténer des grands entiers
        System.out.println("\n===== Test de grands nombres avec constructeur privé =====");
        GrandInt petit = new GrandInt(123);
        GrandInt moyen = new GrandInt(456);

        // On accède au constructeur privé à travers la méthode reflection (ne fonctionne pas réellement ici)
        // C'est juste pour illustrer, en pratique, il faudrait ajouter une méthode publique pour cela.
        System.out.println("Note: Le constructeur privé n'est pas accessible directement depuis cette classe.");
        System.out.println("Pour un test complet, il faudrait ajouter une méthode publique dans GrandInt");
        System.out.println("qui utilise le constructeur privé ou modifier la visibilité du constructeur.");

        // Test d'affichage pour différents nombres
        System.out.println("\n===== Test de l'affichage avec toString() =====");
        afficherGrandInt(0);
        afficherGrandInt(123);
        afficherGrandInt(10000);
        afficherGrandInt(9999999);

        // Test du nombre de chiffres
        System.out.println("\n===== Test de nombreDeChiffres() =====");
        testNombreDeChiffres(0);
        testNombreDeChiffres(7);
        testNombreDeChiffres(123);
        testNombreDeChiffres(10000);
        testNombreDeChiffres(Integer.MAX_VALUE);

        System.out.println("\n===== Fin des tests =====");
    }

    /**
     * Teste le constructeur GrandInt (int nombre) avec une valeur spécifique.
     *
     * @param valeur La valeur à tester
     */
    private static void testConstructeurInt(int valeur) {
        GrandInt g = new GrandInt(valeur);
        System.out.println("GrandInt(" + valeur + ") = " + g.toString());
    }

    /**
     * Affiche un GrandInt créé à partir d'un entier et vérifie que sa
     * représentation en chaîne correspond bien à la valeur d'origine.
     *
     * @param valeur La valeur à tester
     */
    private static void afficherGrandInt(int valeur) {
        GrandInt g = new GrandInt(valeur);
        System.out.println("Affichage de " + valeur + " : " + g.toString());
        System.out.println("Vérification: " + (g.toString().equals(String.valueOf(valeur)) ? "OK" : "ERREUR"));
    }

    /**
     * Teste la méthode nombreDeChiffres() avec une valeur spécifique
     * et vérifie le résultat.
     *
     * @param valeur La valeur à tester
     */
    private static void testNombreDeChiffres(int valeur) {
        GrandInt g = new GrandInt(valeur);
        int nombreDeChiffresAttendu = valeur == 0 ? 1 : (int) Math.log10(valeur) + 1;
        int nombreDeChiffresCalcule = g.nombreDeChiffres();

        System.out.println("Nombre de chiffres dans " + valeur + " : " + nombreDeChiffresCalcule);
        System.out.println("Vérification: " + (nombreDeChiffresCalcule == nombreDeChiffresAttendu ? "OK" : "ERREUR"));
    }
}