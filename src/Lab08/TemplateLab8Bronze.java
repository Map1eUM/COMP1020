package Lab08;

import java.util.ArrayList;

/**
 * Template
 * Lab 8 Bronze Exercise
 * COMP 1020
 */
public class TemplateLab8Bronze {

    public static void main(String[] args) {
        //Create two sample array lists with some common elements
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
        int[] data1 = {45, 12, 98, 34, 6, 42};
        int[] data2 = {6, 81, 36, 12, 77, 42};
        for (int i = 0; i < data1.length; i++) a1.add(data1[i]);
        for (int i = 0; i < data2.length; i++) a2.add(data2[i]);
        System.out.println("a1 is " + a1);
        System.out.println("a2 is " + a2);

        //Use the extractDuplicates method and print the results.
        ArrayList removed = extractDuplicates(a1, a2);
        System.out.println("removed elements: " + removed);
        System.out.println("a1 is now " + a1);
        System.out.println("a2 is now " + a2);
    }//main

    public static ArrayList extractDuplicates(ArrayList a1, ArrayList a2) {
        ArrayList ans = new ArrayList();
        for (int i = 0; i < a1.size(); ++i) {
            for (int j = 0; j < a2.size(); ++j) {
                if (a1.get(i).equals(a2.get(j))) {
                    ans.add(a1.remove(i));
                    --i;
                    a2.remove(j);
                    break;
                }
            }
        }
        return ans;
    }
}

