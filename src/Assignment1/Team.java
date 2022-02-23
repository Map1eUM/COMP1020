package Assignment1;

public class Team {
    final int MAX_NUM = 5;
    Player[] team = new Player[MAX_NUM];
    public int teamNum;

    public Team() {
        teamNum = 0;
    }

    public boolean addMember(Player newOne) {
        if (teamNum == MAX_NUM) return false;
        else {
            for (int i = 0; i < this.teamNum; ++i)
                if (this.team[i].equals(newOne))
                    return false;
            this.team[this.teamNum++] = newOne;
            return true;
        }
    }

    public boolean hasCommonPlayers(Team other) {
        for (int i = 0; i < other.teamNum; ++i) {
            for (int j = 0; j < this.teamNum; ++j)
                if (this.team[j] == other.team[i]) return true;

        }
        return false;
    }

    public boolean teamFull() {
        return this.teamNum == MAX_NUM;
    }

    public Player[] getRoster() {
        Player[] newTeam = new Player[this.teamNum];
        for (int i = 0; i < this.teamNum; ++i) {
            newTeam[i] = this.team[i];
        }
        return newTeam;
    }

    public String toString() {
        //s will be the object output.
        String s = "";
        s += "Team members:\n";
        for (int i = 0; i < teamNum; ++i) {
            s += String.valueOf(i + 1) + ": " + this.team[i].getName() + "\n";
        }
        return s + "\n";
    }

    public boolean removePlayer(Player toRemove) {
        for (int i = 0; i < this.teamNum; ++i) {
            if (this.team[i].equals(toRemove)) {
                for (int j = i + 1; j < this.teamNum; ++j)
                    this.team[j - 1] = this.team[j];
                --this.teamNum;
                return true;
            }
        }
        return false;
    }
}
