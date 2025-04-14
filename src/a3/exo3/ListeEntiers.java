package a3.exo3;

import java.util.Scanner;

public class ListeEntiers {
    private Maillon tete;

    public ListeEntiers() {
        this.tete = null;
    }

    public ListeEntiers(Maillon tete) {
        this.tete = tete;
    }

    public void creerListe(Scanner scanner) {
        System.out.println("Entrez 10 entiers :");
        
        for (int i = 0; i < 10; i++) {
            int valeur = scanner.nextInt();
            ajouterFin(valeur);
        }
    }

    private void ajouterFin(int valeur) {
        Maillon nouveau = new Maillon(valeur);
        if (tete == null) {
            tete = nouveau;
        } else {
            Maillon courant = tete;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(nouveau);
        }
    }

    public boolean estEgale(ListeEntiers autre) {
        Maillon courant1 = this.tete;
        Maillon courant2 = autre.tete;

        while (courant1 != null && courant2 != null) {
            if (courant1.getValeur() != courant2.getValeur()) {
                return false;
            }
            courant1 = courant1.getSuivant();
            courant2 = courant2.getSuivant();
        }

        return courant1 == null && courant2 == null;
    }

    public ListeEntiers concatenerAvecNouvelleListe(ListeEntiers autre) {
        ListeEntiers resultat = new ListeEntiers();
        
        Maillon courant = this.tete;
        while (courant != null) {
            resultat.ajouterFin(courant.getValeur());
            courant = courant.getSuivant();
        }

        courant = autre.tete;
        while (courant != null) {
            resultat.ajouterFin(courant.getValeur());
            courant = courant.getSuivant();
        }

        return resultat;
    }

    public void concatenerSansNouvelleListe(ListeEntiers autre) {
        if (tete == null) {
            tete = autre.tete;
            return;
        }

        Maillon courant = tete;
        while (courant.getSuivant() != null) {
            courant = courant.getSuivant();
        }
        courant.setSuivant(autre.tete);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Maillon courant = tete;
        while (courant != null) {
            sb.append(courant.getValeur());
            if (courant.getSuivant() != null) {
                sb.append(" -> ");
            }
            courant = courant.getSuivant();
        }
        return sb.toString();
    }
} 