package Person;

/**
 * Write a description of class PersonList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonList {
    private Person[] people;
    private int count;

    public PersonList() {
        // initialise instance variables
        count = 0;
        people = new Person[10];

    }

    public void addPerson(Person newOne) {
        people[count] = newOne;
        count++;
    }

    public String toString() {
        //Jane(18)[i=0],Fred(21)[i=1],Sara(23)[i=2]
        String listPerson = "";
        for (int i = 0; i < count; i++) {
            listPerson += people[i]; //Jane(18)
            //listPerson +=","; //Jane(18),Fred(21),Sara(23),
            if (i < count - 1)
                listPerson += ",";
            //listPerson+","+people[i]; //,Jane(18)
        }
        return listPerson;
    }


}
