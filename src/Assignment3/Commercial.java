package Assignment3;

public class Commercial extends Flight {
    @Override
    public void book(Payload payload) throws InvalidBookingException {
        super.book(payload);
        // won't add twice or add to multiple flights. BONUS done!
        if (payload.isPayloadAdded()) return;
        if (payload instanceof Person) {
            //validated
            super.loads.add(payload);
            payload.isAdded = true;
        } else throw new InvalidBookingException("Invalid booking");

    }

    @Override
    public String toString() {
        String ans = "Commercial Flight " + this.id + " has a payload size of " + this.loads.size();
//        return "Should print Commercial Flight [a number] has a payload size of 0";
        return ans;
    }


    public Commercial() {
        super();
        this.id = 1;
        for (int i = 0; i < idLen - 1; ++i)
            this.id *= 10;
        this.id += itemNum - 1;

    }

}
