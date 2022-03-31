
/**
 * Write a description of class ScannerExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class ScannerExample
{
   public static void main(String[] args) { 
       //simple example
       /*
       String test = "123 1 564 45";
       //we want to have an array and in each element we want to store one of these tokens
       int[] array = new int[4];
       Scanner scan = new Scanner(test);
       //I want to scan 123 and store it in array[0]
       array[0] = scan.nextInt();
       array[1] = scan.nextInt();
       array[2] = scan.nextInt();
       array[3] = scan.nextInt();
       
        for(int i=0; i<array.length; i++)
        System.out.println(array[i]);
        
      */
     
      //advanced example
      String test = "123 1 123.2 564 hello world 123.8";   
      Scanner scan = new Scanner(test);
      int[] intArray = new int[3];  
      double[] doubleArray = new double[3];
      String[] stringArray = new String[3];
      int countI = 0;
      int countD = 0;
      int countS = 0;
      while(scan.hasNext()){
        if(scan.hasNextInt()){
            intArray[countI] = scan.nextInt();
            countI++;
        }else if(scan.hasNextDouble()){
            doubleArray[countD] = scan.nextDouble();
            countD++;
        }else if(scan.hasNext()){
            stringArray[countS] = scan.next();
            countS++;
        }
    }
        System.out.println("list of integers");
         for(int i=0; i<intArray.length; i++)
            if(intArray[i]!=0)
                System.out.println(intArray[i]);
        
         System.out.println("list of doubles");
         for(int i=0; i<doubleArray.length; i++)
            if(doubleArray[i]!=0)
                System.out.println(doubleArray[i]);
        
        System.out.println("list of Strings");
        for(int i=0; i<stringArray.length; i++)
            if(stringArray[i] != null)
                System.out.println(stringArray[i]);
        
    }      
}