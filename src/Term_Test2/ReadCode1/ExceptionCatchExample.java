/**
 * Illustrate catching a thrown exception.
 * Change the IF in methodB and see what happens.
 * Also try uncommenting the error in main()
 */
package Term_Test2.ReadCode1;


import static processing.core.PApplet.print;

public class ExceptionCatchExample {

    public static void main(String[] args) throws Exception {
        int x = 0;
//        try {
            x = methodA();
            //int[] a = new int[10]; a[-1]=0; //obviously an Exception here
            //5/0

            System.out.println("methodA worked fine...");
//        } catch (ArithmeticException whatHappened) {
//            System.out.println("Something went wrong!");
//            System.out.println("The message was: " + whatHappened.getMessage());
//        }
        System.out.println("Continuing to run main...");
        System.out.println("The answer is " + x);
    }//main

    public static int methodA() throws Exception {
      int meaningOfLife = 42;
      try {
        double x = methodB();
      } catch (ArithmeticException e) {
        print("ASA\n");
      }
//      print("IT CONTINUED IN METHOD A!\n");

        System.out.println("Continuing to run method A...");
        return meaningOfLife;
    }//methodA

    public static double methodB() throws Exception {
        double answer = 12.0 / 7.0;
        if (answer < 3.0) //Try both true and false conditions here
            throw new ArithmeticException("Oops! I goofed.");
        System.out.println("Continuing to run method B...");
        return answer;
    }//methodB

}//ExceptionExample
