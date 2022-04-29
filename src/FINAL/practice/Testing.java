package FINAL.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static processing.core.PApplet.*;

public class Testing {
    //have data generator, and comparison approach to test if the program is correct

    //------------------------------Data Generation------------------------------

    static int size = (int) 1e5 + 7;
    static int MAX = (int) 1e6;
    static int[] ar = new int[size];

    public static void getData(String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        int len = (int) (Math.random() * size);
//        println(len);
        for (int i = 0; i < len; ++i) {
//            println((Math.random() * MAX));
            int Num = (int) (Math.random() * MAX);
            if (Num > (int)( 0.8 * MAX)) {
                fw.write("IDIOT ");
            } else {
//                println(Num);
                fw.write(Num + " ");

            }
        }
        fw.close();
    }


    //----------------------------------------------------------------------

    //-------------------------------Functional code--------------------------


    //----------------------------------------------------------------------

    //----------------------------Testing logic---------------------------

    public static void test() throws IOException {
        getData("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data");
        String path1 = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\out1";
        String path2 = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\out2";

        //-----------------------Your original code should output to path1----------------
        MergeSort newSort = new MergeSort("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data");
        FileWriter fw1 = new FileWriter("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\out1");
        int[] sorted = newSort.MergeSort();
        for (int i = 0; i < newSort.length; ++i) {
            fw1.write(sorted[i] + " ");
        }
        //--------------------------------------------------------------------------------

        //------------------------Your compare code should output to path2----------------
        int[] arr = new int[0];
        init(arr, "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data");
        sort(arr);
        FileWriter fw2 = new FileWriter("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\out2");
        for (int i = 0; i < arr.length; ++i) {
            fw2.write(arr[i] + " ");
        }
        fw2.close();
        //--------------------------------------------------------------------------------
    }


    public static void init(int[] ar, String path) throws FileNotFoundException {
        Scanner S = new Scanner(new FileReader(path));
        ArrayList<Integer> a = new ArrayList<>();
        int len = 0;
        while (S.hasNext()) {
            if (S.hasNextInt()) a.add(S.nextInt());
            else S.next();
        }
        ar = new int[a.size()];
        for (int x : a) ar[len++] = x;
    }

    public static boolean Compare(String path1, String path2) throws FileNotFoundException {
        Scanner s1 = new Scanner(new FileReader(path1));
        Scanner s2 = new Scanner(new FileReader(path2));
        boolean flag = true;
        int[] dif = new int[size];
        int lineNum = 0;
        while (s1.hasNextLine() && s2.hasNextLine()) {
            ++lineNum;
            if (s1.nextLine().equals(s2.nextLine())) {
                flag = false;
                dif[++dif[0]] = lineNum;
            }
        }
        return flag;
    }

    //-----------------------------------------------------------------------

    //----------------------------Main----------------------------------------

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data";

        int TestingTimes = 3;

        for (int i = 0; i < TestingTimes; ++i) {
            test();
        }
//        getData("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\FINAL\\practice\\data");
//        MergeSort newSort=new MergeSort(path);
//        println(newSort.MergeSort());
    }

    //------------------------------------------------------------------------
}
