package Assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;


public class myTest {
    //aim to test Phase 1~3
    public static ArrayList<Number> myLst = new ArrayList<>();


    public static ArrayList<Number> setMyLst(String filename) {
        try {
            myLst.clear();
            Scanner reader = new Scanner(new FileReader(filename));

//            ArrayList<Number> newList = new ArrayList<>();
//            println("HERE1");
            parseScanner(reader, myLst);
//            println("NOW RETURN THE LIST:"+newList);
            return myLst;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseScanner(Scanner reader, ArrayList newList) {
        if (!reader.hasNext()) return;
        try {
            newList.add(NumberFormat.getInstance().parse(reader.next()));
//            println("HERE2");
//            println("NEW LIST NOW!:"+ newList);
            parseScanner(reader, newList);
        } catch (ParseException e) {
            //This should never happen, unless you pass something is not even a number.
//            throw new RuntimeException(e);
            parseScanner(reader, newList);
        }
    }

    }
