package a2.exo1;

public class Liste {
    // Attributs
    private String valeur;
    private Liste suite;

    // Constructeur pour une liste à un élément
    public Liste(String valeur) {
        this.valeur = valeur;
        this.suite = null;
    }

    // Constructeur pour une liste avec une valeur et une suite
    public Liste(String valeur, Liste suite) {
        this.valeur = valeur;
        this.suite = suite;
    }

    // Getters et setters
    public String getValeur() {
        return valeur;
    }

    public Liste getSuite() {
        return suite;
    }

    public void setSuite(Liste suite) {
        this.suite = suite;
    }

    // Méthode pour ajouter une liste à la fin de la liste courante
    public void append(Liste l) {
        // Si la liste l est vide, rien à faire
        if (l == null) {
            return;
        }

        // On cherche le dernier maillon de la liste courante
        Liste courant = this;
        while (courant.getSuite() != null) {
            courant = courant.getSuite();
        }

        // On ajoute la liste l à la fin
        courant.setSuite(l);
    }

    // Méthode pour supprimer les maillons inférieurs au premier et les retourner
    public Liste suprimerInferieur() {
        // Valeur de référence (premier maillon)
        String reference = this.valeur;

        // Liste résultat qui contiendra les maillons supprimés
        Liste resultat = null;

        // On commence par le deuxième maillon
        Liste precedent = this;
        Liste courant = this.suite;

        // Parcours de la liste à partir du deuxième maillon
        while (courant != null) {
            if (courant.getValeur().compareTo(reference) < 0) {
                // La valeur est inférieure à la référence, on la supprime
                precedent.setSuite(courant.getSuite());

                // On stocke temporairement le suivant du maillon courant
                Liste suivant = courant.getSuite();

                // On ajoute le maillon courant à la liste résultat
                courant.setSuite(resultat);
                resultat = courant;

                // On passe au maillon suivant (sans changer precedent)
                courant = suivant;
            } else {
                // La valeur n'est pas inférieure, on passe au maillon suivant
                precedent = courant;
                courant = courant.getSuite();
            }
        }

        return resultat;
    }

    // Méthode pour trier la liste avec l'algorithme quicksort
    public Liste quicksort() {
        // Cas de base : liste vide ou à un élément (déjà triée)
        if (this.suite == null) {
            return this;
        }

        // On utilise la valeur du premier maillon comme pivot
        String pivot = this.valeur;

        // On crée une nouvelle liste à partir du reste de la liste courante
        Liste reste = this.suite;

        // On se détache du reste pour éviter des cycles
        this.suite = null;

        // On supprime les éléments inférieurs au pivot dans le reste
        Liste inferieurs = null;
        if (reste != null) {
            // Créer une liste temporaire avec le pivot comme premier élément
            Liste temp = new Liste(pivot, reste);
            inferieurs = temp.suprimerInferieur();
            // Récupérer le reste sans le pivot temporaire
            reste = temp.getSuite();
        }

        // On trie récursivement les deux sous-listes
        Liste infsTriee = (inferieurs != null) ? inferieurs.quicksort() : null;
        Liste supTriee = (reste != null) ? reste.quicksort() : null;

        // On concatène les trois parties selon l'énoncé: supTriee + pivot + infsTriee
        Liste resultat = new Liste(pivot);

        // Ajouter la liste des valeurs inférieures triées
        if (infsTriee != null) {
            resultat.append(infsTriee);
        }

        // Ajouter la liste des valeurs supérieures triées en tête
        if (supTriee != null) {
            Liste temp = supTriee;
            while (temp.getSuite() != null) {
                temp = temp.getSuite();
            }
            temp.setSuite(resultat);
            resultat = supTriee;
        }

        return resultat;
    }

    // Méthode pour afficher la liste (utile pour les tests)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Liste courant = this;
        while (courant != null) {
            sb.append(courant.getValeur());
            if (courant.getSuite() != null) {
                sb.append(" -> ");
            }
            courant = courant.getSuite();
        }

        sb.append("]");
        return sb.toString();
    }
}