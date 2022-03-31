package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static processing.core.PApplet.println;

public class Main {
    private static String FILE_NAME;

    public static void main(String[] args) {
        Airline newFlight = new Airline();
        FILE_NAME = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment3\\TestPhase1.txt";
        readInputFile(FILE_NAME, newFlight);
    }

    public static void readInputFile(String fileName, Airline airline) {
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            String S = "";
            while (fileReader.hasNextLine()) {
                S = fileReader.nextLine();
                if (S.charAt(0) == '*') {
                    processComment(S);
                } else {
                    String[] command = S.split(" ");
                    //debug
                    println(command);
                    try {

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void parseCommand(String[] tokens, Airline air) throws InvalidInputException {
        //for phase 1
        throw new InvalidInputException("InvalidInputException: Command not found");
//        switch (tokens[0]) {
//
//        }
    }

    public static void processComment(String data) {
        int index = 1;
        while (data.charAt(index) == ' ') ++index;
        System.out.println(data.substring(index));
    }

}
