package Assignment3;

public class Industrial extends Flight{
    @Override
    public void book(Payload payload) throws InvalidBookingException {
        super.book(payload);
        if(payload instanceof Cargo) {
            //validated
            super.loads.add(payload);
        }
        else if(payload instanceof Person) {
            if (payload instanceof Employee) {
                //validated
                super.loads.add(payload);
            }
            else throw new InvalidBookingException("Booking not valid");
        }
        else throw new InvalidBookingException("wrong booking");
    }
}
