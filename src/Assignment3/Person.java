package Assignment3;

public class Person extends Payload {

	public Person() {
		super();
		this.id = 3;
		for (int i = 0; i < 9; ++i)
			this.id *= 10;
		this.id += itemNum;
	}
}
