public class Complex {
    double a; // real
    double b; // imaginary

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double magnitude() {
        return Math.sqrt((a * a) + (b * b));
    }

    public void sqrt() {
        // (a + bi)^2 = a^2 - b^2  + 2ab
        double tmp = (a * a) - (b * b);
        b = 2.0 * a * b;
        a = tmp;
    }

    public void add(Complex c) {
        a += c.a;
        b += c.b;
    }
}
