package Lab06;

public class Complex extends Real {
    double imaginary;

    public Complex(double x, double y) {
        super(x);
        this.imaginary = y;
    }

    public String toString() {
        return super.toString() + (this.imaginary > 0 ? "+" : "-") + String.format("%4.2f", Math.abs(this.imaginary)) + "i";
    }

    public double magnitude() {
        return Math.sqrt(super.magnitude() * super.magnitude() + this.imaginary * this.imaginary);
    }
}
