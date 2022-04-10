package Assignment3;

public class Cargo extends Payload {

    public Cargo(double w) {
        super(w);
        this.id = 4;
        for (int i = 0; i < idLen - 1; ++i)
            this.id *= 10;
        this.id += itemNum - 1;
    }

}
