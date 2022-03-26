package Lab02;


public class HockeyTeam {
    private String name;
    private int win, loss, otLoss;
    public static int ct = 0;
    public static int columns = 100;
    private static HockeyTeam[] lst = new HockeyTeam[columns];

    public HockeyTeam(String name, int win, int loss, int otLoss) {
        this.name = name;
        this.win = win;
        this.loss = loss;
        this.otLoss = otLoss;
        this.lst[ct++] = this;
    }

    public static void listTeams() {
        for (int i = 0; i < ct; ++i) {
            System.out.println(toString(i));
        }
    }

    public void won() {
        ++this.win;
    }

    public void lost() {
        ++this.loss;
    }

    public void lostOvertime() {
        ++this.otLoss;
    }

    public static int point(int k) {
        return lst[k].win * 2 + lst[k].otLoss;
    }

    public static String toString(int k) {
        return lst[k].name + "(" + lst[k].win + "," + lst[k].loss + "," + lst[k].otLoss + "=" + point(k) + ")";
    }
}



