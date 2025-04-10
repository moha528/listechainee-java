package a3.exo4;

public class Main {
    public static void main(String[] args) {
        // Création d'un polynôme
        Polynome p = new Polynome();
        p.ajouterTerme(3, 4);
        p.ajouterTerme(-2, 3);
        p.ajouterTerme(1, 1);
        p.ajouterTerme(5, 0);
        
        System.out.println("Polynôme initial : " + p);
        
        // Test de la dérivée
        Polynome derivee = p.derivee();
        System.out.println("Dérivée première : " + derivee);
        
        // Test de la dérivée k-ième
        Polynome derivee2 = p.deriveeKieme(2);
        System.out.println("Dérivée seconde : " + derivee2);
        
        // Test avec un polynôme plus complexe
        Polynome p2 = new Polynome();
        p2.ajouterTerme(1, 5);
        p2.ajouterTerme(-3, 4);
        p2.ajouterTerme(2, 2);
        p2.ajouterTerme(-1, 1);
        
        System.out.println("\nAutre polynôme : " + p2);
        System.out.println("Sa dérivée : " + p2.derivee());
        System.out.println("Sa dérivée troisième : " + p2.deriveeKieme(3));
    }
} 