package Assignment3;

public class Commercial extends Flight {
    @Override
    public void book(Payload payload) throws InvalidBookingException {
        super.book(payload);
        if (payload instanceof Person) {
            //validated
            super.loads.add(payload);
        } else throw new InvalidBookingException("Invalid booking");

    }

    @Override
    public String toString() {
        String ans = "Commercial Flight " + this.id + " has a payload size of " + this.loads.size();
//        return "Should print Commercial Flight [a number] has a payload size of 0";
        return ans;
    }


}
