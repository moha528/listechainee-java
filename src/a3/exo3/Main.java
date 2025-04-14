package a3.exo3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListeEntiers liste1 = new ListeEntiers();
        ListeEntiers liste2 = new ListeEntiers();
        
        System.out.println("Création de la première liste :");
        liste1.creerListe(scanner);
        System.out.println("Liste 1 : " + liste1);
        
        System.out.println("\nCréation de la deuxième liste :");
        liste2.creerListe(scanner);
        System.out.println("Liste 2 : " + liste2);
        
        System.out.println("\nTest d'égalité :");
        System.out.println("Les listes sont égales : " + liste1.estEgale(liste2));
        
        System.out.println("\nConcaténation avec nouvelle liste :");
        ListeEntiers liste3 = liste1.concatenerAvecNouvelleListe(liste2);
        System.out.println("Liste 3 : " + liste3);
        
        System.out.println("\nConcaténation sans nouvelle liste :");
        liste1.concatenerSansNouvelleListe(liste2);
        System.out.println("Liste 1 après concaténation : " + liste1);
        
        scanner.close();
    }
} 