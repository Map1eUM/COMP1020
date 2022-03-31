package Term_Test2;

import java.util.ArrayList;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class practice {
    public static void main(String... s) {
        ArrayList<String> k = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList b = new ArrayList();
        x.add(100);
        x.add(0, 50);
        x.add(x.size(), 21);
        print(x);
        b.add("ABUS");
        b.add(120);
        b.add(1, 'c');
        print(b);
//        print(b.remove(0));
        print(b);
//        alk xxa = new alk(5, "Aka");
//        print(b.size());
//        print(b);
//        //why not????
////        print(b.indexOf(new alk(5, "Aka")));
//        alk xxb = new alk(5, "Aka");
////        print(xxa.equals(xxb));
//        ArrayList<String> sl = new ArrayList<String>();
//        sl.add("ASAS");
//        print(sl.contains("ASAS"));
//        int xaa = 0;
//        int[] a = new int[20];
//        try {
////            xaa = 5 / 0;
//            a[-1] = 1;
//        } catch (ArithmeticException e) {
//            print("129312391249412");
//        } catch (IndexOutOfBoundsException e) {
//            print("ASA");
//            a[0] = 1;
//        }
//        println("SUCCEED TO PROCEED");
//        print(a[0]);
        b.add(new alk(1231,"ABBA"));
        print(b.indexOf(new alk(-1231,"ABBA")));
    }
}
