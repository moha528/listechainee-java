package a3.exo3;

public class Maillon {
    private int valeur;
    private Maillon suivant;

    public Maillon(int valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    public Maillon(int valeur, Maillon suivant) {
        this.valeur = valeur;
        this.suivant = suivant;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }
} 