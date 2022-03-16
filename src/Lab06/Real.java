package Lab06;

public class Real {
    private double num;
    public Real(double val) {
        this.num = val;
    }
    public String toString() {
        return String.format("%4.2f", this.num);
    }
    public double magnitude() {
        if (this.num < 0) return -this.num;
        return this.num;
    }
}
