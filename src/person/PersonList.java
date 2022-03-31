package person;

/**
 * A class for a list-of-Person type
 */
public class PersonList {
  
  //Two instance variables forming a partly-full array.
  private int listSize;
  private Person[] people;
  
  //A class constant for the maximum size of all PersonLists
  private static final int MAX_SIZE = 100;
    
  //A constructor that forms an empty list
  public PersonList() {
    listSize = 0;
    people = new Person[MAX_SIZE];
  }//constructor
  
  //Add a new person to the list
  public void addPerson(Person newPerson){
    people[listSize++] = newPerson;
    
  }//addPerson
  //people[person1,person1 , , ]
  
  //Convert the list to a string, of the form
  //   [person1,person2,...]
  public String toString(){
    String result = "[";
    for(int i=0; i<listSize; i++) {
      result += people[i];
      if(i != listSize-1)
        result += ","; //Don't add comma after last one
    }//[name,name,...]
    return result+"]";
  }//toString
  
}//PersonList
