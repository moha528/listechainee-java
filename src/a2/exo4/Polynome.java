package a2.exo4;

import java.util.Arrays;

public class Polynome {
    protected int[] coefficients;

    public Polynome(int... coefficients) {
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    public Polynome ajouter(Polynome autre) {
        int maxDegre = Math.max(this.coefficients.length, autre.coefficients.length);
        int[] result = new int[maxDegre];

        for (int i = 0; i < maxDegre; i++) {
            int coef1 = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            int coef2 = (i < autre.coefficients.length) ? autre.coefficients[i] : 0;
            result[i] = coef1 + coef2;
        }
        return new Polynome(result);
    }

    public Polynome derivee() {
        if (coefficients.length == 1) return new Polynome(0);
        int[] derivee = new int[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            derivee[i - 1] = i * coefficients[i];
        }
        return new Polynome(derivee);
    }

    public double evaluer(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (!sb.isEmpty()) sb.append(" + ");
                sb.append(coefficients[i]).append("x^").append(i);
            }
        }
        return sb.toString().replace("x^0", "").replace("x^1", "x");
    }

}