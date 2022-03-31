/**
 * Illustrate writing to a file
 */
import java.io.*;

public class FileWriting {
  
  public static void main(String[] args) { 
    try {
      PrintWriter outFile = new PrintWriter(new FileWriter("newfile.txt"));//try to change the file name
      //Try adding ,true after "sample.txt"
      outFile.println("This is line one.");
      outFile.print("The answer is ");
      outFile.println(6*(4+2+1));
      outFile.close();
    }//try
    catch(IOException e){
      System.out.println("No such luck. Exception: "+e);
    }//catch
    System.out.println("End of FileWriting program.");
  }//main
  
}//FileWriting
