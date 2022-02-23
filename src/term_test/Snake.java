package term_test;

public class Snake {
    private int id, numLegs;
    static int totalCount = 0;
    private String name;

    public void Snake(int id, String name) {
        this.id = id;
        this.name = name;
        this.numLegs = 0;
        ++totalCount;
    }

    public String makeSound() {
        return "hiss";
    }

    public static boolean equals(Snake a, Snake b) {
        if (a.id != b.id || a.name != b.name) return false;
        return true;
    }
}
