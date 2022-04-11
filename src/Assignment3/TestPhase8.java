package Assignment3;

import static processing.core.PApplet.println;

public class TestPhase8 {
	public static void main(String [] args) {
		
		Airline air = new Airline();
		Main.readInputFile("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment3\\TestPhase8.txt", air);

		println("PART 1 FINISHED");
		try {
			Payload p =Payload.payloadFactory("E", "30", "Jesse", "Rocket", "Trainer");
			System.out.println(p);
			air.addPayload(p);
			p =  Payload.payloadFactory("E", "30", "James", "Rocket", "Trainer");
			System.out.println(p);
			air.addPayload(p);
		} catch (InvalidInputException e) {
			System.out.println("Should not be here!");
		}

		println("PART 2 FINISHED");
		
		try {
			air.addFlight('C');
		} catch (InvalidInputException e) {
			System.out.println("Should not be here either");
		}
		
		
		Flight rocket = air.getFlight(200000002);
		
		System.out.println("Should print false");
		System.out.println(rocket.canTakeoff());
		try {
			rocket.book(air.getPayload(300000006));
			System.out.println("Should print \"Flight 200000002 can not take off\"");
			System.out.println(rocket.doTakeoff());
			rocket.book(air.getPayload(300000007));
		} catch (InvalidBookingException e) {
			System.out.println("Nope, not here either");
		}
		
		System.out.println("Should print \"Flight 200000002 takes off at the speed of light!");
		System.out.println(rocket.doTakeoff());
		
	}

}
