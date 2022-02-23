package Assignment1;

public class Game {
    Team home, away;

    public Game(Team home, Team away) {
        this.away = away;
        this.home = home;

    }

    public boolean validGame() {
        if (!this.home.teamFull() || !this.away.teamFull()) return false;
        for (int i = 0; i < this.home.teamNum; ++i) {
            for (int j = 0; j < this.away.teamNum; ++j) {
                if (this.home.team[i] == this.away.team[j])
                    return false;
            }
        }
        return true;
    }

    public void awardWinner(Team winner, int points) {
        for (int i = 0; i < winner.teamNum; ++i) {
            winner.team[i].addGameResult(points / winner.teamNum);
        }
        Team lost;
        if (winner.team[0].equals(this.home.team[0])) lost = away;
        else lost = home;

        for (int i = 0; i < lost.teamNum; ++i) {
            lost.team[i].addGameResult(0);
        }
    }

    public String toString() {
        if (!validGame()) return "Not a valid game";
        String s = "";
        s += "Team rosters:\n";
        final int LEFT_LEN = 25;
        for (int i = 0; i < home.teamNum; ++i) {
            s += this.home.team[i].getName();
            for (int j = 0; j < LEFT_LEN - this.home.team[i].getName().length(); ++j) s += ' ';
            s += this.away.team[i].getName();
            s += "\n";
        }
        return s;
    }
}
