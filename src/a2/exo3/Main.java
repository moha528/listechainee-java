public class Main {
    public static void main(String[] args) {
        // Test de création de GrandInt
        GrandInt a = new GrandInt("123456789");
        GrandInt b = new GrandInt("987654321");
        
        // Test d'affichage
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        // Test d'addition
        GrandInt somme = a.plus(b);
        System.out.println("\na + b = " + somme);
        
        // Test de multiplication
        GrandInt produit = a.multiplier(b);
        System.out.println("a * b = " + produit);
        
        // Test de comparaison
        System.out.println("\nComparaisons :");
        System.out.println("a < b : " + a.estInferieur(b));
        System.out.println("a > b : " + a.estSuperieur(b));
        System.out.println("a == b : " + a.estEgal(b));
    }
} 