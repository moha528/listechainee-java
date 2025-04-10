package a2.exo4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Polynome p1 = new Polynome(2, 0, -3, 0, 1);
        Polynome p2 = new Polynome(2, 0, -3, 0, 1);
        System.out.println("P1 : " + p1);
        System.out.println("P2 : " + p2);
        System.out.println("P1 + P2 : " + p1.ajouter(p2));
        System.out.println("Dérivée de P1 : " + p1.derivee());
        System.out.println("P1 évalué en x=2 : " + p1.evaluer(2));

        Polynome2 pQuad = new Polynome2(1, -3, 2);
        System.out.println("Solutions de l'équation quadratique : " + Arrays.toString(pQuad.ResoudreEquation()));
    }
}
