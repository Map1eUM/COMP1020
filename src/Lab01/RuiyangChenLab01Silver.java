package Lab01;

import java.util.Scanner;

public class RuiyangChenLab01Silver {
    /**
     * Lab 1 Bronze exercise
     * COMP 1020
     */


    public static void main(String[] args) {
        //Call the readData() method to test it,
        final int columns = 1000;
        int[] num = new int[columns];
        int numberRead = readData(num);
        //and print out the result that was returned.
        System.out.println(numberRead + " valid entries were read in：");
        printArray(num, numberRead);
        System.out.print("Their average is " + average(num, numberRead));
    }//main

    public static void printArray(int[] a, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(a[i] + (i != n - 1 ? "," : "\n"));
        }
    }

    public static double average(int[] a, int n) {
        double avg = 0;
        for (int i = 0; i < n; ++i) avg += a[i];
        avg /= n;
        return avg;
    }

    static int readData(int[] num) {
        /* Prompt the user to enter integer values, one at a time.
         * Values between 1 and 100 are valid. They will be accepted,
         * and echoed in a suitable message. A value of 0 will
         * cause the method to terminate. All other values will
         * cause an error message to be printed. The number of valid
         * values entered (1-100, but not 0) will be returned.
         */
        Scanner keyboard = new Scanner(System.in);

        //**********YOUR CODE HERE******************
        int ct = 0;
        int readInt;
        do {
            System.out.print("Enter an integer from 1 to 100 (0 to quit):");
            readInt = keyboard.nextInt();
            if (readInt > 0 && readInt <= 100) {
                ++ct;
                System.out.println("Entry " + readInt + " accepted");
                num[ct - 1] = readInt;
            } else {
                if (readInt == 0) return ct;
                System.out.println("Invalid entry rejected.");
            }

        } while (true);

    }//readData
}
