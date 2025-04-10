package a3.exo4;

public class Polynome {
    private Maillon tete;

    public Polynome() {
        this.tete = null;
    }

    public Polynome(Maillon tete) {
        this.tete = tete;
    }

    public void ajouterTerme(int coefficient, int degre) {
        if (coefficient == 0) return;
        
        Maillon nouveau = new Maillon(coefficient, degre);
        if (tete == null) {
            tete = nouveau;
            return;
        }

        if (degre > tete.getDegre()) {
            nouveau.setSuivant(tete);
            tete = nouveau;
            return;
        }

        Maillon courant = tete;
        while (courant.getSuivant() != null && courant.getSuivant().getDegre() > degre) {
            courant = courant.getSuivant();
        }

        if (courant.getSuivant() != null && courant.getSuivant().getDegre() == degre) {
            courant.getSuivant().setCoefficient(courant.getSuivant().getCoefficient() + coefficient);
            if (courant.getSuivant().getCoefficient() == 0) {
                courant.setSuivant(courant.getSuivant().getSuivant());
            }
        } else {
            nouveau.setSuivant(courant.getSuivant());
            courant.setSuivant(nouveau);
        }
    }

    public Polynome derivee() {
        Polynome derivee = new Polynome();
        Maillon courant = tete;
        
        while (courant != null) {
            if (courant.getDegre() > 0) {
                derivee.ajouterTerme(courant.getCoefficient() * courant.getDegre(), courant.getDegre() - 1);
            }
            courant = courant.getSuivant();
        }
        
        return derivee;
    }

    public Polynome deriveeKieme(int k) {
        Polynome resultat = this;
        for (int i = 0; i < k; i++) {
            resultat = resultat.derivee();
        }
        return resultat;
    }

    @Override
    public String toString() {
        if (tete == null) return "0";
        
        StringBuilder sb = new StringBuilder();
        Maillon courant = tete;
        
        while (courant != null) {
            if (courant.getCoefficient() > 0 && courant != tete) {
                sb.append(" + ");
            } else if (courant.getCoefficient() < 0) {
                sb.append(" - ");
            }
            
            int coefAbs = Math.abs(courant.getCoefficient());
            if (coefAbs != 1 || courant.getDegre() == 0) {
                sb.append(coefAbs);
            }
            
            if (courant.getDegre() > 0) {
                sb.append("x");
                if (courant.getDegre() > 1) {
                    sb.append("^").append(courant.getDegre());
                }
            }
            
            courant = courant.getSuivant();
        }
        
        return sb.toString();
    }
} 