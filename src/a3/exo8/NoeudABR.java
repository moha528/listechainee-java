package a3.exo8;

public class NoeudABR {
    private String nom;
    private LCB numeros;
    private NoeudABR gauche;
    private NoeudABR droit;

    public NoeudABR(String nom) {
        this.nom = nom;
        this.numeros = new LCB();
        this.gauche = null;
        this.droit = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LCB getNumeros() {
        return numeros;
    }

    public void setNumeros(LCB numeros) {
        this.numeros = numeros;
    }

    public NoeudABR getGauche() {
        return gauche;
    }

    public void setGauche(NoeudABR gauche) {
        this.gauche = gauche;
    }

    public NoeudABR getDroit() {
        return droit;
    }

    public void setDroit(NoeudABR droit) {
        this.droit = droit;
    }

    public void afficher() {
        System.out.print(nom + " : ");
        numeros.afficher();
    }
} 