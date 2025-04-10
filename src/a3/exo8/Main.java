package a3.exo8;

public class Main {
    public static void main(String[] args) {
        // Création de l'index
        ABR index = new ABR();

        // Ajout des noms et des pages selon l'exemple
        index.ajoutNomPropre("Fatou", new int[]{10, 250, 300});
        index.ajoutNomPropre("Mamadou", new int[]{3, 14, 101});
        index.ajoutNomPropre("Oussenou", new int[]{11, 50});
        index.ajoutNomPropre("Pierre", new int[]{3, 7, 100, 237});
        index.ajoutNomPropre("Soda", new int[]{6, 10, 34, 66, 98});

        // Affichage de l'index
        System.out.println("Index initial :");
        index.afficherIndex();
        System.out.println();

        // Test de suppression d'un numéro de page
        System.out.println("Après suppression de la page 10 pour Fatou :");
        index.supprimerNumero("Fatou", 10);
        index.afficherIndex();
        System.out.println();

        // Test d'ajout de nouvelles pages
        System.out.println("Après ajout de la page 200 pour Mamadou :");
        index.ajoutNomPropre("Mamadou", new int[]{200});
        index.afficherIndex();
        System.out.println();

        // Test avec un nouveau nom
        System.out.println("Après ajout de 'Alpha' avec les pages 1, 2, 3 :");
        index.ajoutNomPropre("Alpha", new int[]{1, 2, 3});
        index.afficherIndex();
    }
} 