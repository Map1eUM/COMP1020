import java.util.Scanner; //Allows the use of Scanner input

public class RuiyangChenLab01Bronze {
    /**
     * Lab 1 Bronze exercise
     * COMP 1020
     */
    public static void main(String[] args) {
        //Call the readData() method to test it,
        int numberRead = readData();
        //and print out the result that was returned.
        System.out.println(numberRead + " valid entries were read in.");
    }//main

    static int readData() {
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
            } else {
                if (readInt == 0) return ct;
                System.out.println("Invalid entry rejected.");
            }

        } while (true);

    }//readData

}
