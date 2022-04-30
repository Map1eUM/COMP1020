package FINAL.practice;

import static processing.core.PApplet.print;

public class tryclass {


    public static void init(int[] x) {
        x = new int[100];
    }
    public static void main(String[] args) {
        int[] x = new int[0];
        init(x);
        print(x.length);
    }
}
