package Assignment3;

public class Cargo extends Payload {

	public Cargo(double w) {
		super(w);
		this.id = 1;
		for (int i = 0; i < 9; ++i)
			this.id *= 10;
		this.id += itemNum;
	}

}
