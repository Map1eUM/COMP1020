package Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static processing.core.PApplet.print;

public class testIO {

    public testIO() {
    }

    public static void IOtest() throws IOException {
        try {
            Scanner test = new Scanner(new BufferedReader(new FileReader(String.valueOf("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment2\\data"))));
            int a = Integer.parseInt(String.valueOf(test.next()));
            int b = Integer.parseInt(String.valueOf(test.next()));
            int c = Integer.parseInt(String.valueOf(test.next()));


        } catch (FileNotFoundException e) {
            throw new IOException("FileNotFoundException");
        } catch (NoSuchElementException e) {
            throw new IOException("There's no grid to read");
        } catch (NumberFormatException e) {
            throw new IOException("Bad dimentions");
        }
    }

    public static boolean isNum(int x) {
        return x >= '0' && x <= '9';
    }

//    private void passSpace(BufferedReader br) throws IOException {
//        while (br.read() == ' ') ;
//    }

//    private int readInt(BufferedReader br) throws IOException {
//        int c;
//        int ans = 0;
//        do {
//            c = br.read();
//            if (isNum(c)) ans = ans * 10 + c;
//            else if(!isNum(c) && !(c==' ')) throw new IOException("
//        } while (c != ' ');
//        return ans;
//    }

    private int getValidChar(BufferedReader br) throws IOException {
        //atmost one space char. There's no exception to handle according to logic
        //only pass ' ', \cr will be important
        int c = 0;
        c = br.read();
        while (c == ' ') c = br.read();
        return c;
    }
    private int getDimension(BufferedReader br) throws IOException {
        int ans = 0;
        int c = 0;
        do {
            c = getValidChar(br);
            if (c >= '0' && c <= '9') ans = ans * 10 + (c - 48);
        } while (c != ' ' && c != 13 && c != 10);
        return ans;
    }
    public static void testBufferedReader() throws IOException {
        String fileName="C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment2\\data";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int a =br.read();
//        if (!isNum(a)) throw new IOException("bad dimensions");
        int b = br.read();

        int c=br.read();

        int d=br.read();

        print(a,b,c,d);
    }

    public static void main(String[] parms) throws IOException {
//        testBufferedReader();
            try {
                IOtest();
            }  catch (IOException e) {
                print(e.getMessage());
            }


    }

}
