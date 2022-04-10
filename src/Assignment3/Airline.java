package Assignment3;

import java.util.ArrayList;

import static processing.core.PApplet.println;

public class Airline {

    protected static ArrayList<Flight> flightTrack;
    protected static ArrayList<Payload> payloadTrack;

    public Airline() {
        flightTrack = new ArrayList<Flight>();
        payloadTrack = new ArrayList<Payload>();

    }

    public void addPayload(Payload thePayload) {
        payloadTrack.add(thePayload);
    }

    public Payload getPayload(int id) {
        for (Payload x : payloadTrack) {
            if (x.id == id) return x;
        }
        return null;
    }


    public String addFlight(char type) throws InvalidInputException {
        if (type == 'C') {
            Commercial newComm = new Commercial();
            flightTrack.add(newComm);
            return newComm.toString();
        } else if (type == 'I') {
            Industrial newInd = new Industrial();
            flightTrack.add(newInd);
            return newInd.toString();
        } else throw new InvalidInputException("Not a valid Flight");
    }

    public Flight getFlight(int id) {
        for (Flight x : this.flightTrack) {
            if (x.id == id) return x;
        }
        return null;
    }

}
