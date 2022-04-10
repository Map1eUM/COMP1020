package Assignment3;

public abstract class Payload extends Item {

    protected double weight;

    public Payload(double wgt) {
        super();
        this.weight = wgt;
    }

    public double getWeight() {
        // this will have to be updated!
        return 0;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Weight: %4d kg",this.id,this.weight);
    }

}
