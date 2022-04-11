package Assignment3;

public abstract class Payload extends Item {

    protected double weight;
    protected boolean isAdded;

    public Payload(double wgt) {
        super();
        this.weight = wgt;
        this.isAdded=false;
    }

    public double getWeight() {
        // this will have to be updated!
        return weight;
    }

    public static Payload payloadFactory(String payloadType, String weight, String firstName, String lastName, String job) throws InvalidInputException {
        int wgt=0;
        try {
            wgt=Integer.parseInt(weight);
        }catch (NumberFormatException e) {
            throw new InvalidInputException("This is not a valid weight");
        }
        if (payloadType.equals("P")) {
            return new Person(wgt, firstName, lastName);
        } else if (payloadType.equals("E")) return new Employee(wgt, firstName, lastName, job);
        else if (payloadType.equals("C")) return new Cargo(wgt);
        //this shouldn't happen
        else throw new InvalidInputException("This is not a valid payload type");
    }

    public boolean isPayloadAdded() {
        return this.isAdded;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Weight: %4d kg", this.id, (int)this.weight);
    }

}
