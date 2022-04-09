package Assignment3;

import java.util.ArrayList;

abstract public class Flight {
    ArrayList<Payload> loads=new ArrayList<Payload>();
    protected static int MAX_WEIGHT=200;
    protected static int MAX_PAYLOAD=100;

    public void book(Payload payload) throws InvalidBookingException {

    }

}
