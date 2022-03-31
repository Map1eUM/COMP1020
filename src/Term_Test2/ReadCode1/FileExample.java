
/**
 * Write a description of class FileExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.*;

//it accept three grades from the user
//store in an array
//it will write them in a file
//calculate the average
//add it to the end
public class FileExample
{
     public static void main(String[] args) { 
         try{
            Scanner input = new Scanner(System.in);
            double[] a = new double[3];
            System.out.print("Enter your first grade: ");
            a[0] = input.nextDouble();
            System.out.print("Enter your second grade: ");
            a[1] = input.nextDouble();
            System.out.print("Enter your third grade: ");
            a[2] = input.nextDouble();

            //file writing
            PrintWriter gradeFile = new PrintWriter(new FileWriter("grades.txt"));
            for(int i=0;i<a.length;i++)
                gradeFile.println(a[i]);
            gradeFile.print((a[0]+a[1]+a[2])/3);    
            System.out.print("done!");
            gradeFile.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }

         
        }
}
