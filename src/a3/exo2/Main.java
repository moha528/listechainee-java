package a3.exo2;

public class Main {
    public static void main(String[] args) {
        ListeBidirectionnelle liste = new ListeBidirectionnelle();
        
        // Test ajouterDevant
        liste.ajouterDevant("trois");
        liste.ajouterDevant("deux");
        liste.ajouterDevant("un");
        System.out.println("Liste après ajouterDevant : " + liste);
        
        // Test supprimer
        liste.supprimer("deux");
        System.out.println("Liste après suppression de 'deux' : " + liste);
        
        // Test avec paramètres
        Maillon premier = null;
        Maillon dernier = null;
        liste.ajouterDevant("quatre", premier, dernier);
        System.out.println("Liste après ajouterDevant avec paramètres : " + liste);
    }
} 