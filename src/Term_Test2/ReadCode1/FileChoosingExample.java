/**
 * Show how a file can be chosen using a dialog box.
 */
import java.io.*;
import javax.swing.JFileChooser; //For a fancy file choosing dialog box.

public class FileChoosingExample {
  
  public static void main(String[] args) {
    //One of these can open any files that you want.
    JFileChooser chooser = new JFileChooser(".");
    //JFileChooser chooser = new JFileChooser();
    
    //Select a file to read in, but be friendly (almost)
    chooser.showOpenDialog(null); //This shows a normal "open" (reading) dialog
    //To choose a file for writing, use showSaveDialog instead.
    
    //Use a method to get the chosen File
    File chosenFile = chooser.getSelectedFile();
    //This can be used to open the chosen file
    BufferedReader inFile = null;
    try {
      inFile = new BufferedReader(new FileReader(chosenFile));
    }//try e
    catch(NullPointerException e){
      System.out.println("You cancelled it.");
    }
    catch(FileNotFoundException e) {
      System.out.println("That file could not be found.");
    }//catch
    
    //Now let's read in and write out the file, as before.
    String line;
    try {
      do {
        line = inFile.readLine();
        if(line!=null)System.out.println(line);
      } while(line!=null);
      inFile.close();
    }//try
    catch(IOException e){
      System.out.println("While reading the file, this happened: "+e);
    }//catch
    
  }//main
  
}//FileChoosingExample
