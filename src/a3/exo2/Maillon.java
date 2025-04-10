package a3.exo2;

public class Maillon {
    private String valeur;
    private Maillon suivant;
    private Maillon precedent;

    public Maillon(String valeur) {
        this.valeur = valeur;
        this.suivant = null;
        this.precedent = null;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    public Maillon getPrecedent() {
        return precedent;
    }

    public void setPrecedent(Maillon precedent) {
        this.precedent = precedent;
    }
} 