package Term_Test2.testrun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class test {
    public static void main(String[] args) {
//        Scanner s= new Scanner("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Term_Test2\\testrun\\data");
//        println(s.next());
//
//        int[][] a = {{1, 5}, {3, 4, 5}, {6, 7, 8, 10},{2,3,1,2,4,6}};
//
//        int sum1 = sum(a); //sum1=15
//
//        int[][] b = {{1, 2}, {2, 3, 4, 5}, {1, 2, 5}, {5, 6, 7, 8, 9},{3,2,4,7,1,9}};
//
//        int sum2 = sum(b); //sum2=11
//        println(sum1);
//        println(sum2);
        readFile("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Term_Test2\\testrun\\data");
//    try {
//        int x = 0;
//        int y = 10;
//        int z = y / x;
//        println("A");
//    }catch (ArithmeticException e) {
//        println("B");
//    }
    }

    public void tryit() throws Exception {
        throw new NullPointerException("IT HAPPENED");
    }

    // COMPLETE YOUR IMPLEMENTATION
    public static int sum(int[][] array) {
        return array[0][array[0].length - 1] + array[array.length - 1][array[array.length - 1].length - 1];
    }

    public static void readFile(String inputFileName) {
        try {
            Scanner reader = new Scanner(new File(inputFileName));
            while (reader.hasNextLine()) {
                int minLen= Integer.parseInt(String.valueOf(reader.nextLine()));
//                reader.nextLine();
                println(minLen);

                //get pass the integer
                String curLine=reader.nextLine();
                int curLen=0;
                for(int i=0;i<curLine.length();++i)
                    if(curLine.charAt(i)!=' ')
                        curLen++;
                if(curLen>minLen)System.out.println(curLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}

