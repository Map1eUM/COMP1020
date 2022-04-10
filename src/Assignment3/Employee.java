package Assignment3;

public class Employee extends Person {
	int empID;
	private static int empNum;
	public Employee(double w) {
		super();
		this.empID = 5;
		for (int i = 0; i < idLen-1; ++i)
			this.id *= 10;
		this.empID += empNum;
		++empNum;
	}
	
}
