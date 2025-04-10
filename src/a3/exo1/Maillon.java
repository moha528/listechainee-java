package a3.exo1;

public class Maillon {
    private String mot;
    private Maillon suiv;

    public Maillon(String mot) {
        this.mot = mot;
        this.suiv = null;
    }

    public Maillon(String mot, Maillon suiv) {
        this.mot = mot;
        this.suiv = suiv;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public Maillon getSuiv() {
        return suiv;
    }

    public void setSuiv(Maillon suiv) {
        this.suiv = suiv;
    }
} 