public class Main {
    public static void main(String[] args) {
        Liste liste = new Liste();
        
        // Test d'ajout d'éléments
        liste.ajouter(5);
        liste.ajouter(10);
        liste.ajouter(15);
        
        // Test d'affichage
        System.out.println("Liste après ajout :");
        liste.afficher();
        
        // Test de suppression
        liste.supprimer(10);
        System.out.println("\nListe après suppression de 10 :");
        liste.afficher();
        
        // Test de recherche
        System.out.println("\nRecherche de 5 : " + liste.rechercher(5));
        System.out.println("Recherche de 20 : " + liste.rechercher(20));
    }
} 