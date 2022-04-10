package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class Main {
    private static String FILE_NAME;

    public static void main(String[] args) {
        Airline newFlight = new Airline();
        FILE_NAME = "C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment3\\TestPhase8.txt";
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
                    try {
                        parseCommand(command, airline);
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void parseCommand(String[] tokens, Airline air) throws InvalidInputException {
        //for phase 1
        switch (tokens[0]) {
            case "CREATE-FLIGHT":
                switch (tokens[1]) {
                    case "C":
                        System.out.println(air.addFlight('C'));
                        break;
                    case "I":
                        System.out.println(air.addFlight('I'));
                        break;
                    default:
                        throw new InvalidInputException("InvalidInputException: Flight Creation Command Incorrect");
                }
                break;
            case "GET-FLIGHT":
                Flight searchedFlight = air.getFlight(Integer.parseInt(tokens[1]));
                if (searchedFlight != null) System.out.println(searchedFlight);
                else System.out.println("Flight " + Integer.parseInt(tokens[1]) + " not found");
                break;
            case "CREATE-PAYLOAD":
//                println(tokens);
                switch (tokens[1]) {
                    case "P":
                        Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], null);
                        break;
                    case "E":
                        Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                        break;
                    case "C":
                        Payload.payloadFactory(tokens[1], tokens[2], null, null, null);
                        break;
                    default:
                        throw new InvalidInputException("Not a valid payload type");
                }
                break;
            case "GET-PAYLOAD":
                if (air.getPayload(Integer.parseInt(tokens[1])) != null)
                    System.out.println(air.getPayload(Integer.parseInt(tokens[1])));
                else System.out.println("No such payload exist");
                break;
            case "ASSIGN-PAYLOAD":
                try {
                    int flightID = Integer.parseInt(tokens[1]);
                    int payloadID = Integer.parseInt(tokens[2]);
                    Flight reqFlight = air.getFlight(flightID);
                    Payload reqPayload = air.getPayload(payloadID);
                    if (reqFlight == null || reqPayload == null)
                        throw new InvalidInputException("No such flight or payload");
                    reqFlight.book(reqPayload);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidInputException e) {
                    //although test template has catch too but I will still add catch here, it also work
                    System.out.println(e.getMessage());
                } catch (InvalidBookingException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "TAKEOFF":
                try {
                    int flightID = Integer.parseInt(tokens[1]);
                    Flight reqFlight = air.getFlight(flightID);
                    if (reqFlight == null) throw new InvalidInputException("Flight does not exist");
                    else System.out.println(reqFlight.doTakeoff());
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                throw new InvalidInputException("No such command");
        }
    }

    public static void processComment(String data) {
        int index = 1;
        while (data.charAt(index) == ' ') ++index;
        System.out.println(data.substring(index));
    }

}
