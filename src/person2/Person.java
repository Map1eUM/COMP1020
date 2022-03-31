package person2;

/**
 * Define a new "Person" type
 * Version 2: Adds clone, spouse,
 */

public class Person {

    //Variables
    //=========

    //Instance variables - every Person object will have a set of these
    protected String name;
    private int age;
    private Person spouse;
    private PersonList children;

    //Class variable only one for the whole class
    private static int population = 0;

    //Constructors
    //============

    public Person() {//try commenting this to see the error
        name = "newborn";
        age = 0;
        population++;
        children = new PersonList();
        //System.out.println("Person first constructor ");
    }//constructor

    public Person(String who, int currentAge) {
        name = who;
        age = currentAge;
        population++;
        children = new PersonList();
        //System.out.println("Person second constructor");

    }//constructor

    public Person(String who, int currentAge, Person otherHalf) {
        name = who;
        age = currentAge;
        spouse = otherHalf;
        //make sure the other person is married to this person
        otherHalf.spouse = this;
        children = new PersonList();
        //System.out.println("Person third constructor");
    }//constructor

    //Class method
    //============
    public static int census() {
        return population;
    }

    //Instance methods
    //================

    public void haveBirthday() {
        age++;
    }//haveBirthday()

    public void showAge() {
        System.out.println(name + "'s age is " + age);
    }//showAge()

    public void marries(Person other) {
        spouse = other;
        other.spouse = this;
    }//marries

    public boolean isMarried() {
        return spouse != null;
    }//isMarried

    public Person getSpouse() {
        return spouse;
    }//getSpouse

    public void addChild(Person newChild) {
        children.addPerson(newChild);
    }//addChild

    public String listOfChildren() {
        return children.toString();
    }//listOfChildren

    //Get/set methods (accessors/mutators)
    //====================================

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    //Standard instance methods
    //=========================

    public String toString() {
        return name + "(" + age + ")";
    }//toString()

    public Person clone() {
        return new Person(name, age);
    }

    public boolean equals(Person other) {
        //This is not realistic, but assume the people are the same
        //if both the name and the age match.
        return age == other.age && name.equals(other.name);
    }

    public int compareTo(Person other) {
        //Let's compare names only by alphabetical order
        return name.compareTo(other.name);
    }

}//Person class
