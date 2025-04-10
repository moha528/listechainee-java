package a3.exo8;

public class Maillon {
    private int numero;
    private Maillon suivant;
    private Maillon precedent;

    public Maillon(int numero) {
        this.numero = numero;
        this.suivant = null;
        this.precedent = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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