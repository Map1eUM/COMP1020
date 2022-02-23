package lab03;

public class Game {
    private HockeyTeam home, away;
    private int homeScore, awayScore;

    public Game(HockeyTeam A, HockeyTeam B) {
        this.home = A;
        this.away = B;
        homeScore = awayScore = 0;
    }

    public String toString() {
        return this.away.getName() + '(' + this.awayScore + ") at " + this.home.getName() + '(' + this.homeScore + ')';
    }

    public void goal(HockeyTeam A) {
        if(A.getName().equals(this.home.getName())) homeScore++;
        else if(A.getName().equals(this.away.getName())) awayScore++;
        else System.out.println("That team isn't playing in this game!");
    }

}
