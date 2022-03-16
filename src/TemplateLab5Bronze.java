 /**
 * Template
 * COMP 1020
 * Lab 5 Bronze Exercise
 */

import java.io.*; //Required for most I/O operations

public class TemplateLab5Bronze {

    static final String INPUT_FILE = "testLab5Bronze.txt";
    static final String OUTPUT_FILE = "outputLab5Bronze.txt";
    static BufferedReader inFile;
    static FileReader fileReader;
    static FileWriter outFile;

    static {
        try {
            outFile = new FileWriter(OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileReader = new FileReader(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static PrintWriter fileWriter = new PrintWriter(outFile);

    public TemplateLab5Bronze() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        inFile = new BufferedReader(fileReader);
        String fileLine;
        String output = "";
        int ct = 0;
        while ((fileLine = inFile.readLine()) != null) {
            ct++;
            output += String.valueOf(ct) + ": " + fileLine + '\n';
        }
        fileWriter.print(output);
        fileWriter.close();

    }//main

}//TemplateLab5Bronze
