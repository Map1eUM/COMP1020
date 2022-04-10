package Assignment3;

public class TestPhase7 {
	public static void main(String [] args) {

		Airline air = new Airline();
		Payload load = null;
		try {
			load = Payload.payloadFactory("C", "100", null, null, null);
		} catch (InvalidInputException e) {
			System.out.println("Shouldn't be here");
		}


		System.out.println("Should print \"ID: 400000000, Weight:  100 kg\" twice");

		System.out.println(load);
		air.addPayload(load);
		System.out.println(air.getPayload(400000000));

		System.out.println("Should print null");
		System.out.println(air.getPayload(-1));

	}

}
