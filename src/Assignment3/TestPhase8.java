package Assignment3;

public class TestPhase8 {
	public static void main(String [] args) {

		Airline air = new Airline();
		Main.readInputFile("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment3\\TestPhase8.txt", air);



		/*Commercial Flight 100000000 has a payload size of 0
Commercial Flight 100000001 has a payload size of 0
Industrial Flight 200000002 has a payload size of 0
No such flight or payload
No such flight or payload
Flight 100000001 can not take off
Flight does not exist
ID: 300000006, Weight:   30 kg, Name: Jesse, EMP: 6, Job: Trainer
ID: 300000007, Weight:   30 kg, Name: James, EMP: 7, Job: Trainer
Should print false
false
Should print "Flight 200000002 can not take off"
Flight 200000002 can not take off
Should print "Flight 200000002 takes off at the speed of light!
Flight 200000002 takes off at the speed of light!
/
		 */
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
