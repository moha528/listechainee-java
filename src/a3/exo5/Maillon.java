package a3.exo5;

public class Maillon {
    private int indice;
    private float valeur;
    private Maillon suivant;

    public Maillon(int indice, float valeur) {
        this.indice = indice;
        this.valeur = valeur;
        this.suivant = null;
    }

    public Maillon(int indice, float valeur, Maillon suivant) {
        this.indice = indice;
        this.valeur = valeur;
        this.suivant = suivant;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }
} 