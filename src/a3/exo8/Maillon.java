package a3.exo8;

public class Maillon {
    private int numero;
    private Maillon suiv;
    private Maillon prec;
    
    public Maillon(int numero) {
        this.numero = numero;
        this.suiv = null;
        this.prec = null;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Maillon getSuiv() {
        return suiv;
    }
    
    public void setSuiv(Maillon suiv) {
        this.suiv = suiv;
    }
    
    public Maillon getPrec() {
        return prec;
    }
    
    public void setPrec(Maillon prec) {
        this.prec = prec;
    }
}