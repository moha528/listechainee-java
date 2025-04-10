package a2.exo4;

public class Polynome2 extends Polynome {
    public Polynome2(int a, int b, int c) {
        super(c, b, a);
    }

    public double[] ResoudreEquation() {
        int a = coefficients[2];
        int b = coefficients[1];
        int c = coefficients[0];
        double delta = b * b - 4 * a * c;

        if (delta < 0) return new double[]{};
        if (delta == 0) return new double[]{-b / (2.0 * a)};
        return new double[]{
                (-b + Math.sqrt(delta)) / (2.0 * a),
                (-b - Math.sqrt(delta)) / (2.0 * a)
        };
    }

    @Override
    public String toString() {
        int a = coefficients[2];
        int b = coefficients[1];
        int c = coefficients[0];
        return String.format("%dx² + %dx + %d", a, b, c);
    }
}

