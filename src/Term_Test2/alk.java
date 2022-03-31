package Term_Test2;

import static processing.core.PApplet.print;

public class alk {
    int k;
    String name;

    public alk(int k, String name) {
        this.k = k;
        this.name = name;
    }

    public boolean equals(Object x) {
//        print("IF THIS EQUAL?" + String.valueOf(this.k * this.k == x.k * x.k && this.name.equals(x.name)));
        if (x instanceof alk) {

            if (((alk) x).name.equals(this.name) && ((alk) x).k * ((alk) x).k == this.k * this.k)
                return true;
            return false;
        }
        else return x.equals(this);
    }
}
