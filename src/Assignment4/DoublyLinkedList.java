package Assignment4;

public class DoublyLinkedList {
	/*
	The following code is provided. You are not allowed to modify it.
	*/

    //
    //Instance variables
    //
    private Node first;  //the first LinkedList.Node (or the top LinkedList.Node) of the list
    private Node last;  //the last LinkedList.Node of the list

    //
    //Instance methods
    //

    //accessor for the first LinkedList.Node
    public Node getFirst() {
        return first;
    }

    //accessor for the last LinkedList.Node
    public Node getLast() {
        return last;
    }
	
	/*
	End of the provided code.
	*/

    //Add your code below.

    public void addFront(Number data) {
        Node oldFront = this.first;
        this.first = new Node(data, null, this.first);
        if (oldFront != null) oldFront.setPrevious(this.first);
        //important special case!
        if (last == null) this.last = this.first;
    }

    public void addEnd(Number data) {
        Node oldEnd = this.last;
        this.last = new Node(data, this.last, null);
        if (oldEnd != null) oldEnd.setNext(this.last);
        //important special case!
        if (this.first == null) this.first = this.last;
    }

    public int size() {
        return sizeRec(this.first);
    }

    private int sizeRec(Node node) {
        if (node == null) return 0;
        return sizeRec(node.getNext()) + 1;
    }

    private String toStringRec(Node node) {
        if (node == null) return " >>";
        return String.valueOf(node.getData()) + " " + toStringRec(node.getNext());
    }

    public String toString() {
        return "<< " + toStringRec(this.first);
    }

    private String toStringReversedRec(Node node) {
        if (node == null) return " >>";
        return String.valueOf(node.getData()) + " " + toStringReversedRec(node.getPrevious());
    }

    public String toStringReversed() {
        return "<< " + toStringReversedRec(this.last);
    }


}