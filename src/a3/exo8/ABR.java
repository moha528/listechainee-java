package a3.exo8;

public class ABR {
    private NoeudABR racine;

    public ABR() {
        this.racine = null;
    }

    public NoeudABR getRacine() {
        return racine;
    }

    public void setRacine(NoeudABR racine) {
        this.racine = racine;
    }

    public ABR ajoutNomPropre(String nom, int[] pages) {
        if (racine == null) {
            racine = new NoeudABR(nom);
            for (int page : pages) {
                racine.getNumeros().ajoutNumero(page);
            }
            return this;
        }

        NoeudABR courant = racine;
        NoeudABR parent = null;

        while (courant != null) {
            parent = courant;
            int comparaison = nom.compareTo(courant.getNom());
            
            if (comparaison < 0) {
                courant = courant.getGauche();
            } else if (comparaison > 0) {
                courant = courant.getDroit();
            } else {
                // Le nom existe déjà, on ajoute les numéros de pages
                for (int page : pages) {
                    courant.getNumeros().ajoutNumero(page);
                }
                return this;
            }
        }

        NoeudABR nouveau = new NoeudABR(nom);
        for (int page : pages) {
            nouveau.getNumeros().ajoutNumero(page);
        }

        if (nom.compareTo(parent.getNom()) < 0) {
            parent.setGauche(nouveau);
        } else {
            parent.setDroit(nouveau);
        }

        return this;
    }

    public ABR supprimerNumero(String nom, int numero) {
        NoeudABR courant = racine;
        
        while (courant != null) {
            int comparaison = nom.compareTo(courant.getNom());
            
            if (comparaison < 0) {
                courant = courant.getGauche();
            } else if (comparaison > 0) {
                courant = courant.getDroit();
            } else {
                courant.getNumeros().supprimerNumero(numero);
                return this;
            }
        }
        
        return this;
    }

    public void afficherIndex() {
        afficherIndex(racine);
    }

    private void afficherIndex(NoeudABR noeud) {
        if (noeud != null) {
            afficherIndex(noeud.getGauche());
            noeud.afficher();
            afficherIndex(noeud.getDroit());
        }
    }
} 