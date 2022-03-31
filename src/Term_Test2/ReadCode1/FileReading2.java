/**
 * File Reading - version 2.0
 */
import java.io.*; //Any file I/O will require this import

public class FileReading2 {
  
public static void main(String[ ] args){
  try {
    FileReader fileRdr = new FileReader("junk.txt");//try an invalid name
    System.out.println("OK. I opened a FileReader. Here's the file, line by line:\n");
    
    //Open a BufferedReader.
    BufferedReader inFile = new BufferedReader(fileRdr);
    
    //Read the file line-by-line
    String line;
    do {
      //System.out.println("Reading next line now...");
      line = inFile.readLine();
      if(line!=null)
        System.out.println(line);
    } while(line!=null);
    inFile.close();
 
    //Try it all again, this time reading it character-by-character
    fileRdr = new FileReader("junk.txt");//try an invalid name
    System.out.println("\nOK. I opened a FileReader. Again. Here's the file, char by char:\n");
    
    //Open a BufferedReader.
    inFile = new BufferedReader(fileRdr);
    
    //Read the file character-by-character
    int nextChar;
    do {
      //System.out.println("Reading next char now...");  
      nextChar = inFile.read();
      if(nextChar!=-1)//not reached the end of the file
        System.out.print(nextChar);//try deleting (char)
    } while(nextChar!=-1);
    inFile.close();
  
  }//try
  
  //Since we know about exceptions we may as well catch them.
  catch(IOException e){
    System.out.println("Nope. That didn't work: "+e.getMessage());
  }
  
  System.out.println("\nProgram reached the end normally.");
  }//main

}//FileReading2
