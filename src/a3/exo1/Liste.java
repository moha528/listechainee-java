package a3.exo1;

public class Liste {
    private Maillon tete;

    public Liste() {
        this.tete = null;
    }

    public Liste(Maillon tete) {
        this.tete = tete;
    }

    public Maillon ajouteDebut(String mot) {
        Maillon nouveau = new Maillon(mot, tete);
        tete = nouveau;
        return tete;
    }

    public Maillon ajouteFin(String mot) {
        Maillon nouveau = new Maillon(mot);
        if (tete == null) {
            tete = nouveau;
        } else {
            Maillon courant = tete;
            while (courant.getSuiv() != null) {
                courant = courant.getSuiv();
            }
            courant.setSuiv(nouveau);
        }
        return tete;
    }

    public Maillon supprimer(String mot) {
        if (tete == null) return null;
        
        if (tete.getMot().equals(mot)) {
            tete = tete.getSuiv();
            return tete;
        }

        Maillon precedent = tete;
        Maillon courant = tete.getSuiv();
        
        while (courant != null) {
            if (courant.getMot().equals(mot)) {
                precedent.setSuiv(courant.getSuiv());
                return tete;
            }
            precedent = courant;
            courant = courant.getSuiv();
        }
        return tete;
    }

    public void premiers(int n) {
        Maillon courant = tete;
        int compteur = 0;
        while (courant != null && compteur < n) {
            System.out.println(courant.getMot());
            courant = courant.getSuiv();
            compteur++;
        }
    }

    public void purifie() {
        if (tete == null) return;
        
        Maillon courant = tete;
        while (courant != null) {
            Maillon precedent = courant;
            Maillon suivant = courant.getSuiv();
            
            while (suivant != null) {
                if (suivant.getMot().equals(courant.getMot())) {
                    precedent.setSuiv(suivant.getSuiv());
                } else {
                    precedent = suivant;
                }
                suivant = suivant.getSuiv();
            }
            courant = courant.getSuiv();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Maillon courant = tete;
        while (courant != null) {
            sb.append(courant.getMot());
            if (courant.getSuiv() != null) {
                sb.append(" -> ");
            }
            courant = courant.getSuiv();
        }
        return sb.toString();
    }
} 