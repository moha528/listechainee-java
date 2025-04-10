package a3.exo2;

public class ListeBidirectionnelle {
    private Maillon premier;
    private Maillon dernier;

    public ListeBidirectionnelle() {
        this.premier = null;
        this.dernier = null;
    }

    public void ajouterDevant(String valeur) {
        Maillon nouveau = new Maillon(valeur);
        if (premier == null) {
            premier = nouveau;
            dernier = nouveau;
        } else {
            nouveau.setSuivant(premier);
            premier.setPrecedent(nouveau);
            premier = nouveau;
        }
    }

    public void ajouterDevant(String valeur, Maillon premier, Maillon dernier) {
        Maillon nouveau = new Maillon(valeur);
        if (premier == null) {
            premier = nouveau;
            dernier = nouveau;
        } else {
            nouveau.setSuivant(premier);
            premier.setPrecedent(nouveau);
            premier = nouveau;
        }
    }

    public void supprimer(String valeur) {
        Maillon courant = premier;
        while (courant != null) {
            if (courant.getValeur().equals(valeur)) {
                if (courant == premier) {
                    premier = courant.getSuivant();
                    if (premier != null) {
                        premier.setPrecedent(null);
                    } else {
                        dernier = null;
                    }
                } else if (courant == dernier) {
                    dernier = courant.getPrecedent();
                    dernier.setSuivant(null);
                } else {
                    courant.getPrecedent().setSuivant(courant.getSuivant());
                    courant.getSuivant().setPrecedent(courant.getPrecedent());
                }
                return;
            }
            courant = courant.getSuivant();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Maillon courant = premier;
        while (courant != null) {
            sb.append(courant.getValeur());
            if (courant.getSuivant() != null) {
                sb.append(" <-> ");
            }
            courant = courant.getSuivant();
        }
        return sb.toString();
    }
} 