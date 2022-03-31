package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static processing.core.PApplet.println;

public class Main {
    private static String FILE_NAME;

    public static void main(String[] args) {
        Airline newFlight = new Airline();
        readInputFile(FILE_NAME, newFlight);
    }

    public static void readInputFile(String fileName, Airline airline) {
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            String S = "";
            while ((S = fileReader.nextLine()) != null) {
                if (S.charAt(0) == '*') {
                    processComment(S);
                } else {
                    String[] command = S.split(" ");
                    //debug
                    println(command);
                    try {

                    } catch (Exception e) {

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void parseCommand(String[] tokens, Airline air) throws InvalidInputException {

    }

    public static void processComment(String data) {
        int index = 1;
        while (data.charAt(index) == ' ') ++index;
        System.out.println(data.substring(index));
    }

}
