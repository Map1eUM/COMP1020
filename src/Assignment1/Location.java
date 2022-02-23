package Assignment1;


public class Location {
    final static int MAXN = 20;
    private String name, address;
    private int playerNum, gameNum;
    private Player[] playerList = new Player[MAXN];
    private Game[] gameList = new Game[MAXN];
    //-----------------------Static part---------------------------

    static Location[] arrayLoc = new Location[MAXN << 2];
    static int locNum = 0;

    public static String allLocationNames() {
        String s = "";
        for (int i = 0; i < locNum; ++i) {
            s += arrayLoc[i].name + "\n";
        }
        return s;
    }

    public static String whichLocations(Player who) {
        String s = who.getName() + " is a member at:\n";
        for (int i = 0; i < locNum; ++i) {
            for (int j = 0; j < arrayLoc[i].playerNum; ++j) {
                if (arrayLoc[i].playerList[j].getName().equals(who.getName()))
                    s += arrayLoc[i].name + "\n";
            }
        }
        return s;
    }

    //----------------------------------------------------


    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        arrayLoc[locNum++] = this;
    }



    public String toString() {
        String s = "Membership list for " + this.address + " location\n";
        for (int i = 0; i < this.playerNum; ++i) {
            s += this.playerList[i].toString() + "\n";
        }

        return s;
    }

    public void addMember(Player newbie) {
        for (int i = 0; i < playerNum; ++i) {
            if (this.playerList[i].equals(newbie)) return;
        }
        this.playerList[this.playerNum++] = newbie;
    }
}