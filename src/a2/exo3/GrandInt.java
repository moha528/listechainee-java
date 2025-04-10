package a2.exo3;

/**
 * Classe permettant de manipuler des grands entiers représentés sous forme de liste chaînée.
 */
public class GrandInt {
    private int chiffre; // Chiffre de l'unité
    private GrandInt suite; // Suite du nombre (chiffres plus significatifs)

    /**
     * Constructeur privé utilisé pour construire un grand entier récursivement.
     * @param chiffre Chiffre des unités.
     * @param suite Partie restante du nombre.
     */
    private GrandInt(int chiffre, GrandInt suite) {
        this.chiffre = chiffre;
        this.suite = suite;
    }

    /**
     * Constructeur public permettant de créer un GrandInt à partir d'un entier.
     * @param nombre L'entier à convertir.
     */
    public GrandInt(int nombre) {
        this.chiffre = nombre % 10;
        if (nombre / 10 != 0) {
            this.suite = new GrandInt(nombre / 10);
        } else {
            this.suite = null;
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne du grand entier.
     * @return La chaîne représentant le nombre.
     */
    @Override
    public String toString() {
        if (suite == null) {
            return Integer.toString(chiffre);
        }
        return suite.toString() + chiffre;
    }

    /**
     * Retourne le nombre de chiffres du grand entier.
     * @return Le nombre de chiffres.
     */
    public int nombreDeChiffres() {
        if (suite == null) {
            return 1;
        }
        return 1 + suite.nombreDeChiffres();
    }

    public static void main(String[] args) {
        GrandInt grand1 = new GrandInt(12345);
        System.out.println("Représentation de 12345 : " + grand1.toString());
        System.out.println("Nombre de chiffres : " + grand1.nombreDeChiffres());

        GrandInt grand2 = new GrandInt(7);
        System.out.println("Représentation de 7 : " + grand2.toString());
        System.out.println("Nombre de chiffres : " + grand2.nombreDeChiffres());
    }
}
