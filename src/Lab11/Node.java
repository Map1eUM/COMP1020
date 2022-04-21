package Lab11;

public class Node {

    /* This class defines the Nodes used in a
     * simple linear linked list of integer values.
     */
    private int data;
    private Node link;

    public Node(int d, Node l) {
        data = d;
        link = l;
    }

    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node l) {
        link = l;
    }

}//LinkedList.Node