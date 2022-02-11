package Lab02;

/**
 * Lab 2 Silver test program
 * 
 * This class provides a main method to test the
 * HockeyTeam class of Objects
 * 
 * Silver version: Send a class message to print the teams.
 */
public class TestLab2Silver {
  
  public static void main(String[] args) {
    
    //Create the teams in the Central division of the NHL.
    //This is intentionally very simple brute-force code.
    HockeyTeam team1 = new HockeyTeam("Winnipeg",22,14,8);
    HockeyTeam team2 = new HockeyTeam("Chicago",28,13,2);
    HockeyTeam team3 = new HockeyTeam("Colorado",18,17,8);
    HockeyTeam team4 = new HockeyTeam("St. Louis",27,13,3);
    HockeyTeam team5 = new HockeyTeam("Dallas",19,16,7);
    HockeyTeam team6 = new HockeyTeam("Minnesota",18,19,5);
    HockeyTeam team7 = new HockeyTeam("Nashville",29,9,4);

    //Print out all teams.
    System.out.println("Initial teams:");
    //Send a listTeams message to print out the teams.
    //****ADD ONE LINE HERE****
    HockeyTeam.listTeams();
    
    //Record the results of some fictional games
    team1.won(); team2.lost();          //Winnipeg beat Chicago
    team1.won(); team3.lostOvertime();  //Winnipeg beat Colorado
    team1.won(); team4.lostOvertime();  //Winnipeg beat St. Louis
    team1.won(); team5.lost();          //Winnipeg beat Dallas
    team1.won(); team6.lost();          //Winnipeg beat Minnesota
    team1.won(); team7.lostOvertime();  //Winnipeg beat Nashville
    //OK. So the Jets are really hot right now.
    team4.won(); team2.lost();          //St. Louis beat Chicago
    team3.won(); team5.lost();          //Colorado beat Dallas   
    
    //Print out the teams again, to see the changes.
    System.out.println("\nFinal teams:");
    //Send a listTeams message to print out the teams.
    //****ADD ONE LINE HERE****
    HockeyTeam.listTeams();
  }//main
  
}//TestLab2Silver
