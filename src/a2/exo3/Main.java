package a2.exo3;

public class Main {
    public static void main(String[] args) {
        // Test de création de GrandInt
        GrandInt a = new GrandInt(12345);
        GrandInt b = new GrandInt(7);
        
        // Test d'affichage
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        // Test du nombre de chiffres
        System.out.println("\nNombre de chiffres :");
        System.out.println("a : " + a.nombreDeChiffres());
        System.out.println("b : " + b.nombreDeChiffres());
    }
} 