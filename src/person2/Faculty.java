package person2;

/**
 * Write a description of class Faculty here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Faculty extends Person //Faculty is Person
{
    //extra instance variables
    private int numBooks;
    
    public void buyBook(){
        numBooks++;
    }
    
    public int countBooks(){
        return numBooks;
    }
    
    
    public String toString(){
        return "I am a faculty member.";
    }
    
}
