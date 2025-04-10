package a3.exo1;

public class Main {
    public static void main(String[] args) {
        Liste liste = new Liste();
        
        // Test ajouteDebut
        liste.ajouteDebut("trois");
        liste.ajouteDebut("deux");
        liste.ajouteDebut("un");
        System.out.println("Liste après ajouteDebut : " + liste);
        
        // Test ajouteFin
        liste.ajouteFin("quatre");
        liste.ajouteFin("cinq");
        System.out.println("Liste après ajouteFin : " + liste);
        
        // Test supprimer
        liste.supprimer("deux");
        System.out.println("Liste après suppression de 'deux' : " + liste);
        
        // Test premiers
        System.out.println("\nPremiers 3 éléments :");
        liste.premiers(3);
        
        // Test purifie
        liste.ajouteFin("un");
        liste.ajouteFin("un");
        System.out.println("\nListe avant purifie : " + liste);
        liste.purifie();
        System.out.println("Liste après purifie : " + liste);
    }
}
