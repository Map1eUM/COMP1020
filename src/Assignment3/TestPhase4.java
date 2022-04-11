package Assignment3;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class TestPhase4 {
	public static void main(String [] args) {
		
		Airline airline = new Airline();
		Main.readInputFile("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment3\\TestPhase4.txt", airline);
		
		
		// test the methods, too
		Airline airline2 = new Airline();
		try {
			System.out.println("Should print Commercial Flight 100000003 has a payload size of 0");
			System.out.println(airline2.addFlight('C'));
			println("FIRST PART");
			System.out.println("Should print Industrial Flight 200000004 has a payload size of 0");
			System.out.println(airline2.addFlight('I'));
//			println(airline2.flightTrack);
			println("SECOND PART");
		} catch (InvalidInputException e) {
			System.out.println("Should not run!");
		}
		
		System.out.println(airline2.getFlight(100000003));

		println("THIRD PART");
		// should be null. Is a flight in the other airline
		System.out.println(airline2.getFlight(100000000));
		println("FOURTH");
		System.out.println("Should print Commercial Flight 100000000 has a payload size of 0");
		System.out.println(airline.getFlight(100000000));
		
	}

}
