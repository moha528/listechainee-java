package a2.exo1;

public class Main {
    public static void main(String[] args) {
        Liste liste = new Liste("5");
        
        // Test d'ajout d'éléments
        liste.append(new Liste("10"));
        liste.append(new Liste("15"));
        
        // Test d'affichage
        System.out.println("Liste après ajout :");
        System.out.println(liste);
        
        // Test de suppression des éléments inférieurs
        Liste removed = liste.supprimerInferieur();
        System.out.println("\nListe après suppression des éléments inférieurs :");
        System.out.println(liste);
        System.out.println("Éléments supprimés :");
        System.out.println(removed);
        
        // Test de tri rapide
        Liste sorted = liste.quicksort();
        System.out.println("\nListe triée :");
        System.out.println(sorted);
    }
} 