package Assignment3;

import static processing.core.PApplet.println;

public class Industrial extends Flight{
    @Override
    public void book(Payload payload) throws InvalidBookingException {
        super.book(payload);
        // won't add twice or add to multiple flights. BONUS done!
        if (payload.isPayloadAdded()) return;
        if(payload instanceof Cargo) {
            //validated
            super.loads.add(payload);
            payload.isAdded=true;
        }
        else if(payload instanceof Person) {
            if (payload instanceof Employee) {
                //validated
                super.loads.add(payload);
                payload.isAdded=true;
            }
            else throw new InvalidBookingException("Booking not valid");
        }
        else throw new InvalidBookingException("wrong booking");
    }

    @Override
    public String toString() {
        String ans="Industrial Flight "+this.id+" has a payload size of "+this.loads.size();
//        return "Should print Commercial Flight [a number] has a payload size of 0";
        return ans;
    }
    public Industrial() {
        super();
        this.id = 2;
        for (int i = 0; i < idLen-1; ++i)
            this.id *= 10;
        this.id += itemNum-1;
    }

}
