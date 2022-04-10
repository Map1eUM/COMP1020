package Assignment3;

public class Person extends Payload {

    protected String firstName, lastName;

    public Person(double wgt, String firstName, String lastName) {
        super(wgt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 3;
        for (int i = 0; i < idLen - 1; ++i)
            this.id *= 10;
        this.id += itemNum-1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Name: " + this.firstName;
    }
}
