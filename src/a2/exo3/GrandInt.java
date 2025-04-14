package a2.exo3; /**
 * La classe GrandInt permet de manipuler des entiers de taille arbitraire
 * représentés sous forme de liste de chiffres.
 * Par convention, le chiffre le plus significatif est en fin de liste
 * et il est non nul, sauf pour la valeur zéro.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrandInt {
    // Liste des chiffres du grand entier
    private List<Integer> chiffres;

    /**
     * Constructeur privé qui construit un grand entier avec un chiffre suivi
     * d'un autre grand entier.
     *
     * @param chiffre Le chiffre à ajouter en début de liste
     * @param suite Le grand entier à ajouter après le chiffre
     */
    private GrandInt(int chiffre, GrandInt suite) {
        this.chiffres = new ArrayList<>();
        this.chiffres.add(chiffre);
        if (suite != null) {
            this.chiffres.addAll(suite.chiffres);
        }

        // Normalisation pour s'assurer que le chiffre le plus significatif n'est pas zéro
        this.normaliser();
    }

    /**
     * Constructeur public qui convertit un nombre entier en grand entier.
     *
     * @param nombre Le nombre à convertir en grand entier
     */
    public GrandInt(int nombre) {
        this.chiffres = new ArrayList<>();

        // Cas spécial pour le zéro
        if (nombre == 0) {
            this.chiffres.add(0);
            return;
        }

        // Conversion du nombre en liste de chiffres
        while (nombre > 0) {
            this.chiffres.add(nombre % 10);
            nombre /= 10;
        }
    }

    /**
     * Normalise la représentation du grand entier en supprimant les zéros
     * non significatifs en fin de liste, sauf pour la valeur zéro.
     */
    private void normaliser() {
        while (this.chiffres.size() > 1 && this.chiffres.get(this.chiffres.size() - 1) == 0) {
            this.chiffres.remove(this.chiffres.size() - 1);
        }
    }

    /**
     * Retourne une chaîne de caractères représentant la liste des chiffres du grand entier.
     *
     * @return Une chaîne représentant le grand entier
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Parcours de la liste en commençant par le chiffre le plus significatif
        for (int i = this.chiffres.size() - 1; i >= 0; i--) {
            sb.append(this.chiffres.get(i));
        }

        return sb.toString();
    }

    /**
     * Retourne le nombre de chiffres du grand entier.
     *
     * @return Le nombre de chiffres
     */
    public int nombreDeChiffres() {
        return this.chiffres.size();
    }

}