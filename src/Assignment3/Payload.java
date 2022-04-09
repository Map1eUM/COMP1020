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

    public Payload() {
        //Delete this constructor once Phase 5 is complete!
    }

}
