package Lab02;

public class HockeyTeam {
    private String name;
    private int win, loss, otLoss;

    public HockeyTeam(String name, int win, int loss, int otLoss) {
        this.name = name;
        this.win = win;
        this.loss = loss;
        this.otLoss = otLoss;
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

    public int point() {
        return this.win * 2 + this.otLoss;
    }

    public String toString() {
        return this.name + "(" + this.win + "," + this.loss + "," + this.otLoss + "=" + point() + ")";
    }
}
