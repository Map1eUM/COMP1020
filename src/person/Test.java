package Person;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args) {
        Person me = new Person();
        me.setName("Fred");
        me.setAge(22);
        //System.out.println(me);
        Person her = new Person("Jane",20);
        Person herCopy= her.clone();
        /*
        System.out.println(her);
        System.out.println(herCopy);
        System.out.println(herCopy == her);
        System.out.println(herCopy.equals(her));
        System.out.println(herCopy.compareTo(her));
        */
        PersonList myPersonList = new PersonList();
        myPersonList.addPerson(me);
        myPersonList.addPerson(her);
        myPersonList.addPerson(herCopy);
        //System.out.println(myPersonList);
        //marry
        her.marries(me);
        System.out.println("Spouse of "+her+" is "+ her.getSpouse());
        System.out.println(me.getSpouse());
        //child
        Person child1 = new Person("Jim",2);
        Person child2 = new Person();
        her.addChild(child1);
        her.addChild(child2);
        System.out.println(her.listOfChildren());
        System.out.println(me.listOfChildren());


    }
}
