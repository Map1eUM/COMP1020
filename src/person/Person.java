package Person;

/**
 * Define a new "Person" type
 */

public class Person {
  
  //Instance variables
  //Every Person object will have a set of these
  private String name;
  private int age;
  private Person spouse;
  private PersonList children;
  //Class variable/ only one for the whole class
  private static int population = 0;

  //Constructors

  public Person() {
    name = "newborn";
    age=0;
    population++; //static variable
    children = new PersonList(); //we have to define this for all people or we get null point exception if we use this constructor and try to add a child later
  }//constructor
  
  public Person(String who, int currentAge) {
    name = who;
    age = currentAge;
    population++; //static variable
    children = new PersonList();
  }//constructor

  
  public Person(String who, int currentAge, Person otherHalf) {
    name = who;
    age = currentAge;
    spouse = otherHalf;
    //make sure the other person is married to this person
    otherHalf.spouse = this;
    children = new PersonList();

  }//constructor
  
  //Class method
  public static int census() {
    return population;
  }

  //Instance methods
  public void haveBirthday() {
    age++;
  }//haveBirthday()
  
  public void showAge() {
    System.out.println(name+"'s age is "+age);
  }//showAge()
  
  public Person clone() {
    return new Person(name, age);
    }
    
  public String toString() {
    return name + "(" + age + ")" ;
  }//toString() Jane(18)
  
  public String getName( ) {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }

    public void setAge(int age) {
    this.age = age; //how we use this but you can just use newAge instead of using the same name
  }
  
    public void marries(Person other) {
    spouse = other;
    other.spouse = this;
  }//marries

  public Person getSpouse() {
    return spouse;
  }//getSpouse
  
  
  public void addChild(Person newChild){
    children.addPerson(newChild);
    Person spouse = this.spouse; 
    spouse.children.addPerson(newChild);
    //this.spouse.children.addPerson(newChild);
  }//addChild
  
  
  public String listOfChildren(){
    return children.toString();
  }//listOfChildren
  
  public boolean equals(Person other){
    //This is not realistic, but assume the people are the same
    //if both the name and the age match.
    return age == other.age && name.equals(other.name);
  }
  
  public int compareTo(Person other){
    //Let's compare names only by alphabetical order
    return name.compareTo(other.name);
  }
  
}//Person class
