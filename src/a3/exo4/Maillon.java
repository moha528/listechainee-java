package a3.exo4;

public class Maillon {
    private int coefficient;
    private int degre;
    private Maillon suivant;

    public Maillon(int coefficient, int degre) {
        this.coefficient = coefficient;
        this.degre = degre;
        this.suivant = null;
    }

    public Maillon(int coefficient, int degre, Maillon suivant) {
        this.coefficient = coefficient;
        this.degre = degre;
        this.suivant = suivant;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegre() {
        return degre;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }
} 