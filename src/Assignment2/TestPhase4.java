//package Assignment2;
//
//import java.io.IOException;
//
//public class TestPhase4 {
//  public static void main(String [] parms) {
//    System.out.println("Testing endTerror() and isRoamingCity() methods...\n\n");
//
//    BigCity game = null;
//    String expectedGrid = null;
//
//      System.out.println("This should print BigCity without errors");
//      game = new BigCity("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment2\\CityGrid_GoodData4.txt");
//      System.out.println(game);
//
//      System.out.println("This should print true");
//    System.out.println(game.isRoamingCity());
//
//    System.out.println("\nAny valid move should end game. Go right.");
//    game.move('d');
//
//    System.out.println("\nGame is ended so this should print false");
//    System.out.println(game.isRoamingCity());
//
//    System.out.println("\nPrint BigCity again without errors Showing Suzie at top right corner");
//    expectedGrid = ". s\n" + "b b\n";
//    System.out.println("This should print:\n" + expectedGrid);
//    System.out.println(game);
//  } // main
//} // class TestPhase4