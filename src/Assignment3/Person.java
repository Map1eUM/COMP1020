package Assignment3;

public class Person extends Payload {

    protected String firstName, lastName;

    public Person(double wgt, String firstName, String lastName) {
        super(wgt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 3;
        for (int i = 0; i < idLen - 1; ++i)
            this.id *= 10;
        this.id += itemNum;
    }

    private int digit(int x) {
        int ans = 0;
        while (x > 0) {
            x /= 10;
            ans++;
        }
        return ans;
    }

    @Override
    public String toString() {
        return super.toString() + ", Name: " + this.firstName;
    }
}
