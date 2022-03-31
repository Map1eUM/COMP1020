package person2;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person //Student is Person
{
    //extra instance variables
    private int studentNumber;
    private double GPA;
    
    public Student(){
        //calling the constructor of Person with no parameter
        studentNumber = 123;
        GPA = 4.5;
    }
    
    public Student(int newStNo, double initGPA){
        //calling the constructor of Person with no parameter
        studentNumber = newStNo;
        GPA = initGPA;
    }
    
    public Student(String name, int age, int newStNo){
        super(name,age);//call this specific constructor from Person //we are NOT creating a new Person object in this line
        studentNumber = newStNo;
        GPA = 0;
    }
    
    public String toString() {
        String a = super.toString() + GPA + " student Number "+ studentNumber;
        return a;
  }//toString()
  

    public double getGpa(){
        return GPA;
    }
}
