package a3.exo6;

public class Main {
    public static void main(String[] args) {
        // Création d'une matrice symétrique
        MatriceCarree matrice = new MatriceCarree(3);
        matrice.setElement(0, 0, 1);
        matrice.setElement(0, 1, 2);
        matrice.setElement(0, 2, 3);
        matrice.setElement(1, 0, 2);
        matrice.setElement(1, 1, 4);
        matrice.setElement(1, 2, 5);
        matrice.setElement(2, 0, 3);
        matrice.setElement(2, 1, 5);
        matrice.setElement(2, 2, 6);

        System.out.println("Matrice originale :");
        System.out.println(matrice);

        // Test de symétrie
        System.out.println("La matrice est symétrique : " + matrice.estSymetrique());

        // Test de représentation compacte
        double[] compacte = matrice.symCompacte();
        System.out.println("\nReprésentation compacte :");
        for (double d : compacte) {
            System.out.printf("%8.2f", d);
        }
        System.out.println();

        // Test d'accès aux éléments
        System.out.println("\nAccès aux éléments :");
        System.out.println("Element (1,2) : " + MatriceCarree.acces(compacte, 1, 2, 3));
        System.out.println("Element (2,1) : " + MatriceCarree.acces(compacte, 2, 1, 3));

        // Test de traitement de ligne
        System.out.println("\nTraitement de la ligne 1 :");
        MatriceCarree.traiterLigne(compacte, 3, 1, x -> System.out.printf("%8.2f", x));
        System.out.println();

        // Test d'affichage
        System.out.println("\nAffichage de la matrice à partir de la représentation compacte :");
        MatriceCarree.afficher(compacte, 3);
    }
} 