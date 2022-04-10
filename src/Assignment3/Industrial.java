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
        this.id += itemNum;
    }

}
