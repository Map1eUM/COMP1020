package Assignment3;

public class Commercial extends Flight{
    @Override
    public void book(Payload payload) throws InvalidBookingException {
        super.book(payload);
        if(payload instanceof Person) {
            //validated
            super.loads.add(payload);
        } else throw new InvalidBookingException("Invalid booking");

    }
}
