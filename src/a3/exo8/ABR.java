package a3.exo8;

public class ABR {
    private String nom;
    private LCB numeros;
    private ABR gauche;
    private ABR droite;
    
    // Question 1: Définition du type ABR
    public ABR(String nom) {
        this.nom = nom;
        this.numeros = new LCB();
        this.gauche = null;
        this.droite = null;
    }
    
    public String getNom() {
        return nom;
    }
    
    public LCB getNumeros() {
        return numeros;
    }
    
    public ABR getGauche() {
        return gauche;
    }
    
    public void setGauche(ABR gauche) {
        this.gauche = gauche;
    }
    
    public ABR getDroite() {
        return droite;
    }
    
    public void setDroite(ABR droite) {
        this.droite = droite;
    }
    
    // Question 3: Fonction ABR_ajout_nompropre
    public static ABR ajout_nompropre(String nom, int[] pages, int nombre, ABR a) {
        // Si l'arbre est vide, créer un nouveau nœud
        if (a == null) {
            ABR nouveauNoeud = new ABR(nom);
            // Ajouter tous les numéros de page
            for (int i = 0; i < nombre; i++) {
                nouveauNoeud.getNumeros().ajout_numero(pages[i]);
            }
            return nouveauNoeud;
        }
        
        // Comparaison lexicographique
        int comparaison = nom.compareTo(a.getNom());
        
        if (comparaison == 0) {
            // Le nom existe déjà, ajouter les numéros de page
            for (int i = 0; i < nombre; i++) {
                a.getNumeros().ajout_numero(pages[i]);
            }
        } else if (comparaison < 0) {
            // Le nom est lexicographiquement inférieur, insérer à gauche
            a.setGauche(ajout_nompropre(nom, pages, nombre, a.getGauche()));
        } else {
            // Le nom est lexicographiquement supérieur, insérer à droite
            a.setDroite(ajout_nompropre(nom, pages, nombre, a.getDroite()));
        }
        
        return a;
    }
    
    // Question 4: Fonction ABR_supprimer_numero
    public static ABR supprimer_numero(String nom, int numero, ABR a) {
        if (a == null) {
            return null; // Arbre vide ou nom non trouvé
        }
        
        int comparaison = nom.compareTo(a.getNom());
        
        if (comparaison < 0) {
            // Chercher dans le sous-arbre gauche
            a.setGauche(supprimer_numero(nom, numero, a.getGauche()));
        } else if (comparaison > 0) {
            // Chercher dans le sous-arbre droit
            a.setDroite(supprimer_numero(nom, numero, a.getDroite()));
        } else {
            // Nom trouvé, supprimer le numéro de la LCB
            boolean supprime = a.getNumeros().supprimer_numero(numero);
            
            // Si la LCB est vide après suppression, supprimer le nœud
            if (a.getNumeros().getTete() == null) {
                // Cas 1: Nœud feuille
                if (a.getGauche() == null && a.getDroite() == null) {
                    return null;
                }
                // Cas 2: Nœud avec un seul enfant
                else if (a.getGauche() == null) {
                    return a.getDroite();
                } else if (a.getDroite() == null) {
                    return a.getGauche();
                }
                // Cas 3: Nœud avec deux enfants
                else {
                    // Trouver le successeur (minimum dans le sous-arbre droit)
                    ABR successeur = trouverMinimum(a.getDroite());
                    a.setDroite(supprimerMinimum(a.getDroite()));
                    
                    // Remplacer le nœud actuel par son successeur
                    successeur.setGauche(a.getGauche());
                    successeur.setDroite(a.getDroite());
                    return successeur;
                }
            }
        }
        
        return a;
    }
    
    // Méthode auxiliaire pour trouver le nœud avec la valeur minimale
    private static ABR trouverMinimum(ABR a) {
        if (a == null) {
            return null;
        }
        if (a.getGauche() == null) {
            return a;
        }
        return trouverMinimum(a.getGauche());
    }
    
    // Méthode auxiliaire pour supprimer le nœud avec la valeur minimale
    private static ABR supprimerMinimum(ABR a) {
        if (a == null) {
            return null;
        }
        if (a.getGauche() == null) {
            return a.getDroite();
        }
        a.setGauche(supprimerMinimum(a.getGauche()));
        return a;
    }
    
    // Question 6: Fonction afficher_index
    public static void afficher_index(ABR a) {
        if (a == null) {
            return;
        }
        
        // Parcours infixe pour afficher l'index par ordre alphabétique
        afficher_index(a.getGauche());
        
        System.out.println(a.getNom() + " : " + a.getNumeros());
        
        afficher_index(a.getDroite());
    }
    
    // Méthode pour représentation graphique simple
    public static void afficher_arbre(ABR a, String prefixe, boolean estDernier) {
        if (a == null) {
            return;
        }
        
        System.out.println(prefixe + (estDernier ? "└── " : "├── ") + a.getNom());
        
        // Construction du préfixe pour les enfants
        String nouveauPrefixe = prefixe + (estDernier ? "    " : "│   ");
        
        // Affichage des sous-arbres
        if (!(a.getGauche() == null && a.getDroite() == null)) {
            afficher_arbre(a.getGauche(), nouveauPrefixe, a.getDroite() == null);
            afficher_arbre(a.getDroite(), nouveauPrefixe, true);
        }
    }
}