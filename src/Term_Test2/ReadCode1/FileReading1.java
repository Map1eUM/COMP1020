/**
 * File Reading - version 1.0
 */
import java.io.*; //Any file I/O will require this import

public class FileReading1 {
  
public static void main(String[ ] args) {
  try {
    //Comment out all but one of the following lines
    //Create a file named "junk.txt" in this directory
    //FileReader theFile = new FileReader("junk.txt");
    FileReader theFile = new FileReader("fffff.txt");
    //FileReader theFile = new FileReader("noSuchFile.txt");
    
    System.out.println("OK. That worked.");
    theFile.close();
  }
  //Since we know about exceptions we may as well catch them.
  catch(IOException e){
    System.out.println("Nope. That didn't work: "+e.getMessage());
  }
  
  System.out.println("Program reached the end normally.");
  }//main

}//FileReading1
