package Assignment3;

import java.util.ArrayList;

abstract public class Flight extends Item {
    ArrayList<Payload> loads = new ArrayList<Payload>();
    protected static int MAX_WEIGHT = 200;
    protected static int MAX_PAYLOAD = 100;

    public void book(Payload payload) throws InvalidBookingException {
        /* empty method for polymorphism */

    }

    @Override
    public String toString() {
        //dummy for polymorphism
        return "";
    }
    public Flight() {
        super();
    }
}
