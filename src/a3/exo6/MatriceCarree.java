package a3.exo6;

public class MatriceCarree {
    private static final int NMAX = 100;
    private double[][] matrice;
    private int taille;

    public MatriceCarree(int taille) {
        if (taille > NMAX) {
            throw new IllegalArgumentException("La taille ne peut pas dépasser " + NMAX);
        }
        this.taille = taille;
        this.matrice = new double[taille][taille];
    }

    public void setElement(int i, int j, double valeur) {
        if (i < 0 || i >= taille || j < 0 || j >= taille) {
            throw new IllegalArgumentException("Indices hors limites");
        }
        matrice[i][j] = valeur;
    }

    public double getElement(int i, int j) {
        if (i < 0 || i >= taille || j < 0 || j >= taille) {
            throw new IllegalArgumentException("Indices hors limites");
        }
        return matrice[i][j];
    }

    public boolean estSymetrique() {
        for (int i = 0; i < taille; i++) {
            for (int j = i + 1; j < taille; j++) {
                if (matrice[i][j] != matrice[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public double[] symCompacte() {
        if (!estSymetrique()) {
            return null;
        }

        int tailleCompacte = taille * (taille + 1) / 2;
        double[] compacte = new double[tailleCompacte];
        int index = 0;

        for (int i = 0; i < taille; i++) {
            for (int j = i; j < taille; j++) {
                compacte[index++] = matrice[i][j];
            }
        }

        return compacte;
    }

    public static double acces(double[] compacte, int i, int j, int taille) {
        if (i < 0 || i >= taille || j < 0 || j >= taille) {
            throw new IllegalArgumentException("Indices hors limites");
        }

        if (i <= j) {
            return compacte[i * taille - i * (i - 1) / 2 + j - i];
        } else {
            return compacte[j * taille - j * (j - 1) / 2 + i - j];
        }
    }

    public static void traiterLigne(double[] compacte, int taille, int i, java.util.function.Consumer<Double> traiterCoef) {
        for (int j = 0; j < taille; j++) {
            traiterCoef.accept(acces(compacte, i, j, taille));
        }
    }

    public static void afficher(double[] compacte, int taille) {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.printf("%8.2f", acces(compacte, i, j, taille));
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                sb.append(String.format("%8.2f", matrice[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
} 