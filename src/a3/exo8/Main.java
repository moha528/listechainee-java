package a3.exo8;

public class Main {
    public static void main(String[] args) {
        // Création de l'exemple donné dans l'exercice
        ABR index = null;
        
        // Ajout des noms et numéros de page pour Fatou
        int[] pagesFatou = {110, 250, 300};
        index = ABR.ajout_nompropre("Fatou", pagesFatou, pagesFatou.length, index);
        
        // Ajout des noms et numéros de page pour Mamadou
        int[] pagesMamadou = {3, 14, 110};
        index = ABR.ajout_nompropre("Mamadou", pagesMamadou, pagesMamadou.length, index);
        
        // Ajout des noms et numéros de page pour Ousmane
        int[] pagesOusmane = {1, 50};
        index = ABR.ajout_nompropre("Ousmane", pagesOusmane, pagesOusmane.length, index);
        
        // Ajout des noms et numéros de page pour Pierre
        int[] pagesPierre = {110, 200, 287};
        index = ABR.ajout_nompropre("Pierre", pagesPierre, pagesPierre.length, index);
        
        // Ajout des noms et numéros de page pour Soda
        int[] pagesSoda = {5, 10, 34, 66, 99};
        index = ABR.ajout_nompropre("Soda", pagesSoda, pagesSoda.length, index);
        
        System.out.println("---- Affichage de l'index initial ----");
        ABR.afficher_index(index);
        
        System.out.println("\n---- Représentation graphique de l'ABR ----");
        ABR.afficher_arbre(index, "", true);
        
        // Test de suppression d'un numéro
        System.out.println("\n---- Après suppression de la page 110 pour Pierre ----");
        index = ABR.supprimer_numero("Pierre", 110, index);
        ABR.afficher_index(index);
        
        // Test d'ajout d'un nouveau nom
        System.out.println("\n---- Après ajout de David avec les pages 7, 12, 45 ----");
        int[] pagesDavid = {7, 12, 45};
        index = ABR.ajout_nompropre("David", pagesDavid, pagesDavid.length, index);
        ABR.afficher_index(index);
        
        System.out.println("\n---- Nouvelle représentation graphique de l'ABR ----");
        ABR.afficher_arbre(index, "", true);
    }
}