package a3.exo7;

public class Main {
    public static void main(String[] args) {
        // Création d'un arbre binaire
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7
        ArbreBinaire arbre = new ArbreBinaire(1);
        arbre.setGauche(new ArbreBinaire(2));
        arbre.setDroit(new ArbreBinaire(3));
        arbre.getGauche().setGauche(new ArbreBinaire(4));
        arbre.getGauche().setDroit(new ArbreBinaire(5));
        arbre.getDroit().setGauche(new ArbreBinaire(6));
        arbre.getDroit().setDroit(new ArbreBinaire(7));

        // Test de l'affichage des feuilles
        System.out.println("Feuilles de l'arbre :");
        arbre.afficherFeuilles();
        System.out.println();

        // Test de l'affichage des degrés
        System.out.println("\nDegrés des nœuds :");
        arbre.afficherDegres();

        // Test de la profondeur
        System.out.println("\nProfondeur du nœud 5 : " + arbre.profondeur(5));
        System.out.println("Profondeur du nœud 3 : " + arbre.profondeur(3));
        System.out.println("Profondeur du nœud 8 : " + arbre.profondeur(8));

        // Test de la hauteur
        System.out.println("\nHauteur de l'arbre : " + arbre.hauteur());

        // Test de la somme des nœuds
        System.out.println("\nSomme des nœuds : " + arbre.sommeNoeuds());

        // Test avec un arbre plus complexe
        //        10
        //      /    \
        //     5      15
        //    / \    /  \
        //   3   7  12  20
        //  / \   \   \
        // 1   4   8   13
        ArbreBinaire arbreComplexe = new ArbreBinaire(10);
        arbreComplexe.setGauche(new ArbreBinaire(5));
        arbreComplexe.setDroit(new ArbreBinaire(15));
        arbreComplexe.getGauche().setGauche(new ArbreBinaire(3));
        arbreComplexe.getGauche().setDroit(new ArbreBinaire(7));
        arbreComplexe.getDroit().setGauche(new ArbreBinaire(12));
        arbreComplexe.getDroit().setDroit(new ArbreBinaire(20));
        arbreComplexe.getGauche().getGauche().setGauche(new ArbreBinaire(1));
        arbreComplexe.getGauche().getGauche().setDroit(new ArbreBinaire(4));
        arbreComplexe.getGauche().getDroit().setDroit(new ArbreBinaire(8));
        arbreComplexe.getDroit().getGauche().setDroit(new ArbreBinaire(13));

        System.out.println("\n\nTests avec un arbre plus complexe :");
        System.out.println("Feuilles de l'arbre complexe :");
        arbreComplexe.afficherFeuilles();
        System.out.println();

        System.out.println("\nDegrés des nœuds de l'arbre complexe :");
        arbreComplexe.afficherDegres();

        System.out.println("\nProfondeur du nœud 8 : " + arbreComplexe.profondeur(8));
        System.out.println("Profondeur du nœud 13 : " + arbreComplexe.profondeur(13));

        System.out.println("\nHauteur de l'arbre complexe : " + arbreComplexe.hauteur());
        System.out.println("Somme des nœuds de l'arbre complexe : " + arbreComplexe.sommeNoeuds());
    }
} 