package Term_Test2.ReadCode1;

/**
 * Illustrate throwing an exception.
 * Change the IF in methodB and see what happens.
 */
public class ExceptionThrowExample {

    public static void main(String[] args) throws Exception {
        int x = methodA();
        System.out.println("Continuing to run main...");
        System.out.println("The answer is " + x);
    }//main

    public static int methodA() throws Exception {
        int meaningOfLife = 42;
        double x = methodB();
        //meaningOfLife = meaningOfLife/0;
        System.out.println("Continuing to run method A...");
        return meaningOfLife;
    }//methodA

    public static double methodB() throws Exception {
        double answer = 22.0 / 7.0;
        if (answer > 3.0) //Change to true and false conditions
            throw new ArithmeticException("Oops! I goofed.");
        System.out.println("Continuing to run method B...");
        return answer;
    }//methodB

}//ExceptionExample
