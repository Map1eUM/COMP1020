package person2;

public class Test
{
    public static void main(String[] args){
       // Person p = new Person();
        //System.out.println(p.toString());
        
        //Student s1 = new Student();
       // System.out.println(s1.toString());
       
       //Student s2 = new Student("Jane", 23,12345);
       //System.out.println(s2.toString());
       
       //Student s3 = new Student(54326, 3.4);
       //System.out.println(s3.toString());
       
       Student s1 = new Student();
       System.out.println(s1.name); //try to see how protected works in one package
       
       //type compatibilty
       Person ps1 = new Student(1234321, 2.9);
       ps1.haveBirthday(); //we have access to this Person method
       System.out.println(ps1.toString());
       //ps1.getGpa(); we do not have access to subclass methods!
       //Person ps = new Student("a name", 14); it will look at Student constructors
       //Student a = new Person(); error
       
       System.out.println("Testing casting");
       
       Student s2 = (Student)ps1;
       System.out.println(s2.getGpa());
       
       Person p1 = new Person();
       //Student s3 = (Student)p1;
     
       if(ps1 instanceof Student){
            s2 = (Student)ps1;
            System.out.println(s2.getGpa());
        }
        
       if(p1 instanceof Student){
            s2 = (Student)ps1;
            System.out.println(s2.getGpa());
        }
       
       System.out.println("Testing a superclass array");
       Person[] everyone = new Person[6];
       everyone[0] = new Student(1234322, 2.5);
       everyone[1] = new Student();
       everyone[2] = new Undergrad();
       everyone[3] = new Faculty();
       everyone[4] = new Student(123456, 3);
       everyone[5] = new Person("Jane", 21);
       
       for(int i=0; i<6; i++){
           //adding a condition for Undergrad
           //???
           if (everyone[i] instanceof Undergrad){
               System.out.println("Undergrad Student");
            } 
           else if(everyone[i] instanceof Student){
                System.out.println("Student");
                s2 = (Student)everyone[i];
                System.out.println(s2.getGpa());
        }
           else if(everyone[i] instanceof Person){
               System.out.println("Not a Student");
               everyone[i].showAge();
            }
    }
    
    System.out.println("Testing a superclass array for polymorphism");
        for(int i=0; i<6; i++){
           //adding a condition for Undergrad
           //???
           System.out.println(everyone[i]);
    }
    System.out.println("Testing other stuff");
    Undergrad us1 = new Undergrad();
    System.out.println(us1);
    //if we delete the toString method in Undergrad?

    Person us2 = new Undergrad();
    System.out.println(us2);
    //us2.onlyInUndergrad();
    
    //Undergrad ust1 =(Undergrad)s2;
    
}
    //if you have:
    //Class A (Person)
    //B (Student) extends A
    //C (Undergrad)extends B
    //A and B have toString() methods
    //C does not have a toString() method
    //C c1 = new C();
    //c1.toString();
    //which toString method will run?
    
}