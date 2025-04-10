package a3.exo5;

public class VecteurCreux {
    private Maillon tete;

    public VecteurCreux() {
        this.tete = null;
    }

    public VecteurCreux(Maillon tete) {
        this.tete = tete;
    }

    public static VecteurCreux creerVecteurCreux(float[] tableau) {
        VecteurCreux vecteur = new VecteurCreux();
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] != 0) {
                vecteur.ajouterElement(i, tableau[i]);
            }
        }
        return vecteur;
    }

    private void ajouterElement(int indice, float valeur) {
        Maillon nouveau = new Maillon(indice, valeur);
        if (tete == null) {
            tete = nouveau;
            return;
        }

        if (indice < tete.getIndice()) {
            nouveau.setSuivant(tete);
            tete = nouveau;
            return;
        }

        Maillon courant = tete;
        while (courant.getSuivant() != null && courant.getSuivant().getIndice() < indice) {
            courant = courant.getSuivant();
        }

        if (courant.getSuivant() != null && courant.getSuivant().getIndice() == indice) {
            courant.getSuivant().setValeur(valeur);
        } else {
            nouveau.setSuivant(courant.getSuivant());
            courant.setSuivant(nouveau);
        }
    }

    public static VecteurCreux somme(VecteurCreux a, VecteurCreux b) {
        VecteurCreux resultat = new VecteurCreux();
        Maillon courantA = a.tete;
        Maillon courantB = b.tete;

        while (courantA != null && courantB != null) {
            if (courantA.getIndice() < courantB.getIndice()) {
                resultat.ajouterElement(courantA.getIndice(), courantA.getValeur());
                courantA = courantA.getSuivant();
            } else if (courantA.getIndice() > courantB.getIndice()) {
                resultat.ajouterElement(courantB.getIndice(), courantB.getValeur());
                courantB = courantB.getSuivant();
            } else {
                float somme = courantA.getValeur() + courantB.getValeur();
                if (somme != 0) {
                    resultat.ajouterElement(courantA.getIndice(), somme);
                }
                courantA = courantA.getSuivant();
                courantB = courantB.getSuivant();
            }
        }

        while (courantA != null) {
            resultat.ajouterElement(courantA.getIndice(), courantA.getValeur());
            courantA = courantA.getSuivant();
        }

        while (courantB != null) {
            resultat.ajouterElement(courantB.getIndice(), courantB.getValeur());
            courantB = courantB.getSuivant();
        }

        return resultat;
    }

    @Override
    public String toString() {
        if (tete == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Maillon courant = tete;
        
        while (courant != null) {
            sb.append(courant.getIndice()).append(":").append(courant.getValeur());
            if (courant.getSuivant() != null) {
                sb.append(", ");
            }
            courant = courant.getSuivant();
        }
        
        sb.append("]");
        return sb.toString();
    }
} 