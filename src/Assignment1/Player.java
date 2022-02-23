package Assignment1;

public class Player {
    private String name;
    private int gameNum, totalScore;

    public Player(String name) {
        this.name = name;
        this.gameNum = 0;
        this.totalScore = 0;

    }

    public Player(String name, Location givenLoc) {
        this.name = name;
        givenLoc.addMember(this);
    }

    public void addGameResult(int newScore) {
        totalScore += newScore;
        ++gameNum;
    }

    public boolean equals(Player other) {
        return this.name.equals(other.name);
    }

    public String toString() {
        if (gameNum == 0) return "Player: " + this.name + " has played no games";
        else
            return "Player: " + this.name + " has played " + this.gameNum + " game with an average of " + (this.totalScore / this.gameNum);
    }


    public String getName() {
        return this.name;
    }
}
