package Assignment3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

abstract public class Flight extends Item {
    ArrayList<Payload> loads = new ArrayList<Payload>();
    protected static int MAX_WEIGHT = 200;
    protected static int MAX_PAYLOAD = 100;
    boolean hasTakenoff;

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
        hasTakenoff = false;
    }

    @NotNull
    public boolean canTakeoff() {
        if (hasTakenoff) return false;
        if (this.loads.size() < 2) return false;
        boolean hasEmp = false;
        for (Payload x : loads) {
            if (x instanceof Employee)
                hasEmp = true;
        }
        return hasEmp;
    }

    public String doTakeoff() {
        if (!canTakeoff()) return "Flight "+this.getID()+" can not take off";
        else {
            hasTakenoff = true;
            return "Flight "+this.getID()+" takes off at the speed of light!";
        }
    }

}
