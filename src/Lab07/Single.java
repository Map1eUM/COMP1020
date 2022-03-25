package Lab07;

public class Single extends Data{
    private double val;
    public Single(double x) {
        this.val = x;
    }

    @Override
    public double valueOf() {
        return this.val;
    }
}
