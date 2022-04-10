package Assignment3;

public class Person extends Payload {

	protected String firstName,lastName;
	public Person() {
		super();
		this.id = 3;
		for (int i = 0; i < idLen-1; ++i)
			this.id *= 10;
		this.id += itemNum;
	}
}
