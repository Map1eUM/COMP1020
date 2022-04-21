package LinkedList;

public class Node {
    Node nxt;
    Node pre;
    Object data;

    private int id;

    public static int idNum;

    public Node(Object data) {
        this.data = data;
        ++idNum;
        this.id = idNum;
    }
}
