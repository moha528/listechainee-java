package a3.exo7;

public class ArbreBinaire {
    private int valeur;
    private ArbreBinaire gauche;
    private ArbreBinaire droit;

    public ArbreBinaire(int valeur) {
        this.valeur = valeur;
        this.gauche = null;
        this.droit = null;
    }

    public ArbreBinaire(int valeur, ArbreBinaire gauche, ArbreBinaire droit) {
        this.valeur = valeur;
        this.gauche = gauche;
        this.droit = droit;
    }

    public void afficherFeuilles() {
        if (gauche == null && droit == null) {
            System.out.print(valeur + " ");
        }
        if (gauche != null) {
            gauche.afficherFeuilles();
        }
        if (droit != null) {
            droit.afficherFeuilles();
        }
    }

    public void afficherDegres() {
        int degre = 0;
        if (gauche != null) degre++;
        if (droit != null) degre++;
        System.out.println("Noeud " + valeur + " : degré " + degre);

        if (gauche != null) {
            gauche.afficherDegres();
        }
        if (droit != null) {
            droit.afficherDegres();
        }
    }

    public int profondeur(int x) {
        return profondeurRec(x, 0);
    }

    private int profondeurRec(int x, int profondeurActuelle) {
        if (valeur == x) {
            return profondeurActuelle;
        }

        int profondeurGauche = -1;
        int profondeurDroit = -1;

        if (gauche != null) {
            profondeurGauche = gauche.profondeurRec(x, profondeurActuelle + 1);
        }
        if (droit != null) {
            profondeurDroit = droit.profondeurRec(x, profondeurActuelle + 1);
        }

        return Math.max(profondeurGauche, profondeurDroit);
    }

    public int hauteur() {
        if (gauche == null && droit == null) {
            return 0;
        }

        int hauteurGauche = 0;
        int hauteurDroit = 0;

        if (gauche != null) {
            hauteurGauche = gauche.hauteur();
        }
        if (droit != null) {
            hauteurDroit = droit.hauteur();
        }

        return 1 + Math.max(hauteurGauche, hauteurDroit);
    }

    public int sommeNoeuds() {
        int somme = valeur;
        if (gauche != null) {
            somme += gauche.sommeNoeuds();
        }
        if (droit != null) {
            somme += droit.sommeNoeuds();
        }
        return somme;
    }

    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }

    public void setDroit(ArbreBinaire droit) {
        this.droit = droit;
    }

    public ArbreBinaire getGauche() {
        return gauche;
    }

    public ArbreBinaire getDroit() {
        return droit;
    }

    public int getValeur() {
        return valeur;
    }
} 