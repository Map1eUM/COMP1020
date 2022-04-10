package Assignment3;

import java.util.ArrayList;

import static processing.core.PApplet.println;

public class Airline {

    protected static ArrayList<Flight> track;

    public Airline() {
        track = new ArrayList<Flight>();
    }

    public String addFlight(char type) throws InvalidInputException {
        if (type == 'C') {
            Commercial newComm = new Commercial();
            track.add(newComm);
            return newComm.toString();
        } else if (type == 'I') {
            Industrial newInd = new Industrial();
            track.add(newInd);
            return newInd.toString();
        } else throw new InvalidInputException("Not a valid Flight");
    }

    public Flight getFlight(int id) {
//        println("THIS REQUIEST+"+id);
        for (Flight x : this.track) {
//            println(x.id);
            if (x.id == id) return x;
        }
        return null;
    }

}
