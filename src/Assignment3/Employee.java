package Assignment3;

public class Employee extends Person {
    int empID;
    protected String job;
    private static int empNum;

    public Employee(double w, String firstName, String lastName,String job) {
        super(w, firstName, lastName);
        this.empID = 5;
        this.empID += empNum;
        ++empNum;
        this.job=job;
    }

    public boolean hasJob(String isItThisJob) {
        return this.job.equals(isItThisJob);
    }

    public String toString() {
        return super.toString() + ", EMP: " + this.empID + ", Job: " + this.job;
    }

}
