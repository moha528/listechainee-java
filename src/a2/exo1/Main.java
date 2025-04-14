package a2.exo1;

public class Main {
    public static void main(String[] args) {
        Liste liste = new Liste("D",
                new Liste("B",
                        new Liste("G",
                                new Liste("A",
                                        new Liste("F",
                                                new Liste("C",
                                                        new Liste("E", null)))))));

        System.out.println("Liste originale: " + liste);

        Liste listeAppend = new Liste("X", new Liste("Y", new Liste("Z", null)));
        Liste liste2 = new Liste("M", null);
        liste2.append(listeAppend);
        System.out.println("Test append: " + liste2);

        Liste listeInf = new Liste("M",
                new Liste("H",
                        new Liste("P",
                                new Liste("E",
                                        new Liste("Q",
                                                new Liste("J", null))))));
        System.out.println("Avant suppression des inférieurs à M: " + listeInf);
        Liste inferieurs = listeInf.suprimerInferieur();
        System.out.println("Après suppression: " + listeInf);
        System.out.println("Éléments inférieurs extraits: " + (inferieurs != null ? inferieurs : "aucun"));

        Liste listeTri = liste.quicksort();
        System.out.println("Liste triée: " + listeTri);
    }
}