package Assignment3;

import static processing.core.PApplet.println;

public class TestPhase6 {
	public static void main(String [] args) {
		
		// Now we can test some stuff!
		Payload somePayload = null;
		Payload newp= null;
		try {
			somePayload = Payload.payloadFactory("C", "10", null, null, null);
		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		
		try {
			somePayload = Payload.payloadFactory("E", "225", "Bob", "Tomato", "Complaining");
			newp = Payload.payloadFactory("E", "2252", "asa", "xas", "Complaining");

		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		println(newp);
		try {
			somePayload = Payload.payloadFactory("P", "10", "Larry", "Cucumber", null);
		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		
	}

}
