package Lab07;

public class List extends Data {
    private double[] val;

    public List(double[] x) {
        this.val = x;
    }

    @Override
    public double valueOf() {
        double sum = 0;
        for (int i = 0; i < this.val.length; ++i) {
            sum += this.val[i];
        }
        return sum;

    }
}
