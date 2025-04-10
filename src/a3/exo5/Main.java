package a3.exo5;

public class Main {
    public static void main(String[] args) {
        // Création de deux vecteurs creux
        float[] tableau1 = {0, 0, 9, 5, 0, 7, 0, 3, 0, 0};
        float[] tableau2 = {0, 2, 0, 4, 0, 0, 8, 0, 1, 0};
        
        VecteurCreux v1 = VecteurCreux.creerVecteurCreux(tableau1);
        VecteurCreux v2 = VecteurCreux.creerVecteurCreux(tableau2);
        
        System.out.println("Vecteur 1 : " + v1);
        System.out.println("Vecteur 2 : " + v2);
        
        // Test de la somme
        VecteurCreux somme = VecteurCreux.somme(v1, v2);
        System.out.println("Somme des vecteurs : " + somme);
        
        // Test avec d'autres vecteurs
        float[] tableau3 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] tableau4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        
        VecteurCreux v3 = VecteurCreux.creerVecteurCreux(tableau3);
        VecteurCreux v4 = VecteurCreux.creerVecteurCreux(tableau4);
        
        System.out.println("\nVecteur 3 : " + v3);
        System.out.println("Vecteur 4 : " + v4);
        System.out.println("Somme des vecteurs 3 et 4 : " + VecteurCreux.somme(v3, v4));
    }
} 